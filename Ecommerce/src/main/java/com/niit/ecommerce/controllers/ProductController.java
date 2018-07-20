package com.niit.ecommerce.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


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

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.domain.Product;
@Controller
public class ProductController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	
	//http:localhost:8086/Ecommerce/all/getallproducts
	@RequestMapping(value="/all/getallproducts")
	public ModelAndView getAllProducts(){
		List<Product> products=productDao.getAllProducts();//select * from product
		//Model is like map
		//Key and Value pair
		//Key                     Value
		//productsAttr            products [list of product objects]
		return new ModelAndView("productlist","productsAttr",products);
	}
	@RequestMapping(value="/all/getproduct/{id}")
	public ModelAndView getProduct(@PathVariable int id){
		Product product=productDao.getProduct(id);
		//Key - productAttr
		//value- product object [1 object]
		return new ModelAndView("productindetail","productAttr",product);
	}
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id,HttpServletRequest request){
		productDao.deleteProduct(id);
		String rootContext=request.getSession().getServletContext().getRealPath("/");
		Path path=Paths.get(rootContext + "/WEB-INF/resources/images/"+ id+".png");
		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return "redirect:/all/getallproducts";
	}
	//http:localhost:8086/projectfrontendp/productform
	@RequestMapping(value="/admin/getproductform")//blank form
	public String getproductform(Model model){
		//Two model attribute [data] to the productform.jsp
		//1. product=new Product()
		//2. categories =List<Category>
		model.addAttribute("product",new Product());
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "productform";
	}
	
	@RequestMapping("/admin/updateproductform/{id}")//form with previous values
	public String getUpdateProductForm(@PathVariable int id,Model model){
		Product product=productDao.getProduct(id);
		model.addAttribute("product",product);
		model.addAttribute("categories",categoryDao.getAllCategories());
		return "updateproductform";
	}
	
	//handler method to get new product object
	@RequestMapping(value="/admin/saveorupdateproduct")
	public String saveOrUpdateProduct(@Validated @ModelAttribute(name="product") Product product,BindingResult result ,Model model,HttpServletRequest request){//input from jsp pages
		if(result.hasErrors()){
			model.addAttribute("categories",categoryDao.getAllCategories());
			if(product.getId()==0)//insert
			return "productform";
			else
				return "updateproductform";
		}
		System.out.println("Product Id in SaveProduct method " + product.getId());
        String rootContext= request.getSession().getServletContext().getRealPath("/");
        //........ project1frontend
        System.out.println(rootContext);
        
		productDao.saveOrUpdateProduct(product);
		
		Path paths=Paths.get(rootContext + "\\WEB-INF\\resources\\images\\"+product.getId()+".png");
		MultipartFile productImage=product.getPimage();
		System.out.println(productImage);
		if(productImage!=null && !productImage.isEmpty()){
			try {
				System.out.println("Pimage is "+productImage);
				productImage.transferTo(new File(paths.toString()));
				System.out.println("Image is uploaded to "+paths);
			}  catch (Exception e) {
				System.out.println("Image uploading failed");
				e.printStackTrace();
			}
		}
		return "redirect:/all/getallproducts";
	}
}
