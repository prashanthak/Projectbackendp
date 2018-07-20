package com.niit.ecommerce.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value={"/home","/"})
    //handler method to get homepage
    public String homePage(Model m,HttpSession ses,Principal p) {
		List<Product> products=productDao.getAllProducts();
		System.out.println(p.getName());
		ses.setAttribute("LoggedInUser", "anilk@gmail.com");
		m.addAttribute("productsAttr",products);
   	 return "homepage";  //	logical view name
    }
    @RequestMapping("/aboutus")
    public String aboutUs() {
   	 return "aboutus";
    }
    @RequestMapping("/login")
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
   }
	
}
