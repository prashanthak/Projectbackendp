package com.niit.dao;

import java.util.List;

import com.niit.domain.Category;

public interface CategoryDao {
CategoryDao saveOrUpdateCategory(Category category);
CategoryDao getCategory(int cid);
void deleteCategory(int cid);
List<Category> getAllCategory();
}
