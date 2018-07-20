package com.niit.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
		public String registerCustomer(@ModelAttribute(name="customer") Customer customer,Model model){
			System.out.println("Customer emial id "+customer.getUser().getEmail());
			System.out.println(customerDao.isEmailUnique(customer.getUser().getEmail()));
			if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
				model.addAttribute("error","Email Id already Exists.. please enter different email address");
				return "registrationform";
			}
			else
			{
			customer.getUser().setRole("ROLE_USER");
		   	customerDao.saveOrUpdateCustomer(customer);
		   	System.out.println("Customer added");
//		   	authorities.setRole("ROLE_USER");
//		   	authorities.setUser(customer.getUser());
//		   
//		   	authoritiesDao.saveOrUpdateAuthorities(authorities);
		   	return "login";
		}
		}
}
