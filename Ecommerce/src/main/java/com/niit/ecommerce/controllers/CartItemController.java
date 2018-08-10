package com.niit.ecommerce.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerOrderDao;
import com.niit.dao.ProductDao;
import com.niit.dao.ShippingAddressDao;
import com.niit.domain.CartItem;
import com.niit.domain.Category;
import com.niit.domain.Customer;
import com.niit.domain.CustomerOrder;
import com.niit.domain.Product;
import com.niit.domain.ShippingAddress;
import com.niit.domain.User;

@Controller
public class CartItemController {
	 @Autowired
		private ProductDao productDao;
		@Autowired
	   private CartItemDao cartItemDao;
		@Autowired
		private CustomerOrderDao customerOrderDao;
		@Autowired
		private ShippingAddressDao shippingaddressDao;
		@Autowired
		private CategoryDao categoryDao;
		
	@RequestMapping(value="/cart/addtocart/{productId}")
	/*public ModelAndView getAllProducts(Model m)*/
	public String addToCart(@PathVariable int productId,@AuthenticationPrincipal  Principal principal, Model m){
		System.out.println("In cart controller");
		String email=principal.getName();//Email id of the logged in user
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		
		Product product=productDao.getProduct(productId);
		for(CartItem cartItem:cartItems){
			if(cartItem.getProduct().getId()==productId){
				cartItem.setQuantity(1);
				cartItem.setTotalPrice(1 * product.getPrice() );
				cartItemDao.saveOrUpdateCartItem(cartItem);//update
				List<Category> categories=categoryDao.getAllCategories();
				m.addAttribute("categoriesAttr",categories);
				return "redirect:/cart/purchasedetails";
			}
		}
		
		
		CartItem cartItem=new CartItem();
		
		User user=cartItemDao.getUser("anilk@gmail.com");
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setUser(user);
		cartItem.setTotalPrice(1 * product.getPrice());
		cartItemDao.saveOrUpdateCartItem(cartItem);//insert
		return "redirect:/cart/purchasedetails";
	}
	
	@RequestMapping(value="/cart/purchasedetails")
	public String getPurchaseDetails(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		model.addAttribute("cartItems",cartItems);
		session.setAttribute("cartSize",cartItems.size() );
		
		model.addAttribute("cartSize",cartItems.size() );
		return "cart";
	}
	
	@RequestMapping(value="/cart/deletecartitem/{itemId}")// cart/**  ROLE_USER
	public String removeCartItem(@PathVariable int itemId){
		cartItemDao.removeCartItem(itemId);
		return "redirect:/cart/purchasedetails";
	}
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		for(CartItem cartItem:cartItems){
			cartItemDao.removeCartItem(cartItem.getItemId());
		}
		return "redirect:/cart/purchasedetails";
	}






@RequestMapping(value="/cart/shippingaddress")
public String getshippingaddress(@AuthenticationPrincipal Principal principal,Model model)
{
	System.out.println("getting SA");
String email=principal.getName();
User user= cartItemDao.getUser(email);
Customer customer=user.getCustomer();
ShippingAddress shippingAddress=customer.getShippingaddress();
model.addAttribute("shippingaddress",shippingAddress);
return "shippingaddress";
}


@RequestMapping(value="/cart/createorder")
public String createOrder(@ModelAttribute ShippingAddress shippingaddress,@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
String email=principal.getName();
User user=cartItemDao.getUser(email);
Customer customer=user.getCustomer();

customer.setShippingaddress(shippingaddress);//setting updated shippingaddress
shippingaddress.setCustomer(customer);
shippingaddressDao.saveOrUpdateShippingAddress(shippingaddress);
user.setCustomer(customer);//set the updated customer to user
//Check if requested Quantity is available or not
List<CartItem> cartItems=cartItemDao.getCartItems(email);
for(CartItem cartItem:cartItems){
	Product product=cartItem.getProduct();
	if((product.getQuantity()-cartItem.getQuantity())<0){
		cartItemDao.removeCartItem(cartItem.getItemId());
		model.addAttribute("productNA",product);
		return "productnotavailable";
	}
}


//Calculate grandTotal

double grandTotal=0;
for(CartItem cartItem:cartItems){//for(T o:collection)
	grandTotal=grandTotal+cartItem.getTotalPrice();
}

//create CustomerOrder object
CustomerOrder customerOrder=new CustomerOrder();
customerOrder.setPurchaseDate(new Date());
customerOrder.setUser(user);//customerOrder -> user -> customer -> shippingaddress
customerOrder.setGrandTotal(grandTotal);
if(cartItems.size()>0)
 customerOrder=customerOrderDao.saveOrUpdateCustomerOrder(customerOrder);
 
 
//Remove all cartitems from the cartItem table
//decrement the quantity of the product
//add customerorder and List<CartItem> to an model attributes and return "orderdetails"
 
for(CartItem cartItem:cartItems){
	Product product=cartItem.getProduct();
	product.setQuantity(product.getQuantity() - cartItem.getQuantity());//decrement the product quantity
	productDao.saveOrUpdateProduct(product );//update product set quantity=7 where id=38
	cartItemDao.removeCartItem(cartItem.getItemId());
}
model.addAttribute("customerorder",customerOrder);//order=[orderId,purchaseDate,grandTotal,User]
model.addAttribute("cartItems",cartItems);
session.setAttribute("cartSize", 0);
return "orderdetails";
}
}


