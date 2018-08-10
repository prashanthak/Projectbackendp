package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.domain.Category;
@Repository("categoryDao")
public interface CategoryDao {
Category saveOrUpdateCategory(Category category);
Category getCategory(int cid);
void deleteCategory(int cid);
List<Category> getAllCategories();
Category getByName(String name);
}
