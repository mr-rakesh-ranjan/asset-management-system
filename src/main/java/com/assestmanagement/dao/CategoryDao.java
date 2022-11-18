package com.assestmanagement.dao;

import com.assestmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao  extends JpaRepository<Category, String> {

    @Query("select u from Category u where u.categoryId= :e")
    public Category findByCategoryId(@Param("e") String categoryId);

}
