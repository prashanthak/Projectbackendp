package com.niit.ecommerce.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.domain.CartItem;
import com.niit.domain.Category;
import com.niit.domain.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	CartItemDao cartItemDao;
	
	@RequestMapping(value={"/home","/"})
    //handler method to get homepage
    public String homePage(Model m,HttpSession ses,Principal p) {
		List<Product> products=productDao.getAllProducts();
		List<Category> categories=categoryDao.getAllCategories();
		m.addAttribute("productsAttr",products);
		m.addAttribute("categoriesAttr",categories);
		
		if(p!=null)
		{
		System.out.println(p.getName());
		ses.setAttribute("LoggedInUser", p.getName());
		
		
		String email=p.getName();
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		
		ses.setAttribute("cartSize",cartItems.size() );
		}
   	 return "homepage";  //	logical view name
    }
    @RequestMapping(value= {"/aboutus"})
   /* public String aboutusPage(Model m,HttpSession ses,Principal p) {
		List<Product> products=productDao.getAllProducts();
		List<Category> categories=categoryDao.getAllCategories();
    m.addAttribute("productsAttr",products);
	m.addAttribute("categoriesAttr",categories);
    }*/
    public String aboutUs() {
   	 return "aboutus";
    }
   /* @RequestMapping("/login")
    public String login() {
   	 return "login";
    }
    @RequestMapping("/logout")
    public String logout(Model m) {
    	m.addAttribute("logoutmsg","You are logged out");
   	 return "login";
    }
    @RequestMapping("/loginerror")
   public String loginerror(Model m)
   {
    	m.addAttribute("loginerror","Username or password is incorrect");
    	return "login";
   }*/
	
}
