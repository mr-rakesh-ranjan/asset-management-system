package com.assestmanagement.service;


import com.assestmanagement.entity.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public void deleteCategory(String categoryId);
    public List<Category> allCategory();
}
