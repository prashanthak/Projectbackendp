package com.niit.ecommerce.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;



@Controller
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;
	
	
	//http://localhost:8086/projectfrontendp/all/getallcategories
	@RequestMapping(value="/all/getallcategories")
	public ModelAndView getAllcategories(){
		List<Category> categories=categoryDao.getAllCategories();//select * from category
		//Model is like map
		//Key and Value pair
		//Key                     Value
		//categoriesAttr            categories [list of category objects]
		return new ModelAndView("categorylist","categoriesAttr",categories);
	}
	
	
		
	@RequestMapping(value="/all/getcategory/{id}")
	public ModelAndView getCategory(@PathVariable int id){
		Category category=categoryDao.getCategory(id);
		//Key - categoryAttr
		//value- category object [1 object]
		return new ModelAndView("categoryindetail","categoryAttr",category);
	}
	@RequestMapping(value="/admin/deletecategory/{id}")
	public String deleteCategory(@PathVariable int id,HttpServletRequest request){
		categoryDao.deleteCategory(id);
//		String rootContext=request.getServletContext().getRealPath("/");
//		Path path=Paths.get(rootContext + "/WEB-INF/resources/images/"+ id+".png");
//		if(Files.exists(path)){
//			try {
//				Files.delete(path);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return "redirect:/all/getallcategories";
	}
	//http://localhost:8086/projectfrontendp/categoryform
	@RequestMapping(value="/admin/getcategoryform")//blank form
	public String getcategoryform(Model model){
		//Two model attribute [data] to the categoryform.jsp
		//1. category=new Category()
		//2. categories =List<Category>
		model.addAttribute("category",new Category());
		//model.addAttribute("categories",categoryDao.getAllCategories());
		return "categoryform";
	}
	
	@RequestMapping("/admin/updatecategoryform/{id}")//form with previous values
	public String getUpdateCategoryForm(@PathVariable int id,Model model){
		Category category=categoryDao.getCategory(id);
		model.addAttribute("category",category);
		//model.addAttribute("categories",categoryDao.getAllCategories());
		return "updatecategoryform";
	}
	
	//handler method to get new category object
	@RequestMapping(value="/admin/saveorupdatecategory")
	public String saveOrUpdateCategory(@Validated @ModelAttribute(value="category") Category category,BindingResult result ,Model model,HttpServletRequest request){//input from jsp pages
		if(result.hasErrors()){
			//model.addAttribute("categories",productDao.getAllCategories());
			if(category.getCid()==0)//insert
			return "categoryform";
			else
				return "updatecategoryform";
		}
		System.out.println("Category Id in SaveCategory method " + category.getCid());

		categoryDao.saveOrUpdateCategory(category);
				
		return "redirect:/all/getallcategories";
	}
}
