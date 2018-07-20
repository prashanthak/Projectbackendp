package com.niit.ecommerce.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.BillingAddressDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.PaymentDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.domain.BillingAddress;
import com.niit.domain.Customer;
import com.niit.domain.Payment;
import com.niit.domain.Product;
import com.niit.domain.ShippingAddress;
import com.niit.domain.User;

@Controller
public class PaymentController {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	BillingAddressDao billingaddressDao;
	@Autowired
	Customer customer;
	@Autowired
	UserDao userDao;
	
	//http:localhost:8086/Ecommerce/all/getallproducts
	@RequestMapping(value="/all/getallpayments")
	public ModelAndView getAllPayments(){
		List<Payment> payments=paymentDao.getAllPayments();//select * from product
		//Model is like map
		//Key and Value pair
		//Key                     Value
		//productsAttr            products [list of product objects]
		return new ModelAndView("paymentlist","paymentsAttr",payments);
	}
	@RequestMapping(value="/all/getpayment/{id}")
	public ModelAndView getPayment(@PathVariable int id){
		Payment payment=paymentDao.getPayment(id);
		//Key - productAttr
		//value- product object [1 object]
		return new ModelAndView("paymentindetail","paymentAttr",payment);
	}
	
	//http:localhost:8086/projectfrontendp/productform
	@RequestMapping(value="/user/getpaymentform")//blank form
	public String getpaymentform(Model model,HttpSession ses){
				model.addAttribute("payment",new Payment());
				String uname=(String) ses.getAttribute("LoggedInUser");
				User u=userDao.getUser(uname);
	//			customerDao.getCustomer(id)
			BillingAddress ba=customer.getBillingaddress();
			int bid=ba.getId();
			ba=billingaddressDao.getBillingAddress(bid);
			System.out.println(ba.getId());
		//model.addAttribute("Payments",paymentDao.getAllPayments());
		return "payment";
	}
	
//	@RequestMapping("/admin/updatepaymentform/{id}")//form with previous values
//	public String getUpdatePaymentForm(@PathVariable int id,Model model){
//		Payment payment=paymentDao.getPayment(id);
//		model.addAttribute("payment",payment);
//		model.addAttribute("payments",paymentDao.getAllPayments());
//		return "updatepaymentform";
//	}
	
	//handler method to get new product object
	@RequestMapping(value="/admin/saveorupdatepayment")
	public String saveOrUpdatePayment(@Validated @ModelAttribute(name="payment") Payment payment,BindingResult result ,Model model,HttpServletRequest request){//input from jsp pages
		
		System.out.println("Payment Id in SavePayment method " + payment.getPayment_id());
        
		paymentDao.paymentsave(payment);
		
		return "redirect:/home";
//		
//		return "redirect:/all/getallpayments";
	}
}
