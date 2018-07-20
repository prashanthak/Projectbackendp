package com.niit.ecommerce.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.domain.Product;
import com.niit.domain.Supplier;

@SuppressWarnings("unused")
@Controller
public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	CategoryDao categoryDao;
	
	//http:localhost:8086/Ecommerce/all/getallproducts
	@RequestMapping(value="/all/getallsuppliers")
	public ModelAndView getAllSuppliers(){
		List<Supplier> suppliers=supplierDao.getAllSuppliers();//select * from product
		//Model is like map
		//Key and Value pair
		//Key                     Value
		//productsAttr            products [list of product objects]
		return new ModelAndView("suppliers","suppliersAttr",suppliers);
	}
	@RequestMapping(value="/all/getsupplier/{id}")
	public ModelAndView getSupplier(@PathVariable int id){
		Supplier supplier=supplierDao.getSupplier(id);
		//Key - productAttr
		//value- product object [1 object]
		return new ModelAndView("supplierindetail","supplierAttr",supplier);
	}
	@RequestMapping(value="/admin/deletesupplier/{id}")
	public String deleteSupplier(@PathVariable int id,HttpServletRequest request){
		supplierDao.deleteSupplier(id);
		String rootContext=request.getSession().getServletContext().getRealPath("/");
		Path path=Paths.get(rootContext + "/WEB-INF/resources/images/"+ id+".png");
		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return "redirect:/all/getallsupplierS";
	}
	//http:localhost:8086/projectfrontendp/productform
	@RequestMapping(value="/admin/getsupplierform")//blank form
	public String getsupplierform(Model model){
		//Two model attribute [data] to the productform.jsp
		//1. product=new Product()
		//2. categories =List<Category>
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "addsuppliers";
	}
	
	@RequestMapping("/admin/updatesupplierform/{id}")//form with previous values
	public String getUpdateProductForm(@PathVariable int id,Model model){
		Supplier supplier=supplierDao.getSupplier(id);
		model.addAttribute("supplier",supplier);
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "updatesupplierform";
	}
	
	//handler method to get new supplier object
	@RequestMapping(value="/admin/saveorupdatesupplier")
	public String saveOrUpdateSupplier(@Validated @ModelAttribute(name="supplier") Supplier supplier,BindingResult result ,Model model,HttpServletRequest request){//input from jsp pages
		if(result.hasErrors()){
			model.addAttribute("categories",categoryDao.getAllCategories());
			if(supplier.getSid()==0)//insert
			return "supplierform";
			else
				return "updatesupplierform";
		}
		
        
        supplierDao.saveOrUpdateSupplier(supplier);
		
		return "redirect:/all/getallsuppliers";
	}
}	