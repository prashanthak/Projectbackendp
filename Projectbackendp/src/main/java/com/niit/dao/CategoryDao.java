package com.niit.dao;

import java.util.List;

import com.niit.domain.Category;

public interface CategoryDao {
Category saveOrUpdateCategory(Category category);
Category getCategory(int cid);
void deleteCategory(int cid);
List<Category> getAllCategories();
}
