package com.niit.ecommerce.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.AuthoritiesDao;
import com.niit.dao.CustomerDao;
import com.niit.domain.Authorities;
import com.niit.domain.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private AuthoritiesDao authoritiesDao;
	@Autowired
	Authorities authorities;
		@RequestMapping(value="/all/registrationform")
		public ModelAndView getRegistrationForm(){
			return new ModelAndView("registrationform","customer",new Customer());
		}
		
		
		@RequestMapping(value="/all/register")
		public String registerCustomer(@ModelAttribute(value="customer") Customer customer,Model model)
		{
			System.out.println("Customer emial id "+customer.getUser().getEmail());
			System.out.println(customerDao.isEmailUnique(customer.getUser().getEmail()));
			if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
				model.addAttribute("error","Email Id already Exists.. please enter different email address");
				return "registrationform";
			}
			else
			{
			customer.getUser().setRole("ROLE_USER");
			customer.getUser().setEnabled(true);
		   	customerDao.saveOrUpdateCustomer(customer);
		   	System.out.println("Customer added");
//		   	authorities.setRole("ROLE_USER");
//		   	authorities.setUser(customer.getUser());
//		   
//		   	authoritiesDao.saveOrUpdateAuthorities(authorities);
		   	return "login";
		}
		}
		
		
		@RequestMapping(value = "/login")
	    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
	            required = false) String logout, Model model) {
	        if (error!=null) {
	        	System.out.println("Error.....");
	            model.addAttribute("error", "...Invalid username and password");
	        }
	        	
	        if(logout!=null) {
	        	System.out.println("Logout called.....");
	            model.addAttribute("msg", "...You have been logged out");
	        }

	        return "login";
	 }
		
		
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
		}
}
