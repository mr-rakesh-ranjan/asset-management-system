package com.assestmanagement.service.impl;

import ch.qos.logback.core.CoreConstants;
import com.assestmanagement.dao.CategoryDao;
import com.assestmanagement.entity.Category;
import com.assestmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    //creating new category and save to database
    @Override
    public Category addCategory(Category category) {
//        System.out.println("sevice 34 " + category);
        Category category1 =  this.categoryDao.save(category);
//        System.out.println("service" + category1); //for debugging purpose
        return  category1;
    }


    //update category
    @Override
    public Category updateCategory(Category category) {
        Category category1 = this.categoryDao.save(category);
        return category1;
    }

    //delete category
    @Override
    public void deleteCategory(String categoryId) {
        Category category = this.categoryDao.findByCategoryId(categoryId);
        //System.out.println(category); //for debugging purpose
        this.categoryDao.delete(category);
    }

    //list of all category
    @Override
    public List<Category> allCategory() {
        return this.categoryDao.findAll();
    }


}
