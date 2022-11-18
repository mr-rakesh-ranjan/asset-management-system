package com.assestmanagement.controller;

import com.assestmanagement.constants.Status;
import com.assestmanagement.entity.Asset;
import com.assestmanagement.entity.Category;
import com.assestmanagement.entity.Employee;
import com.assestmanagement.service.impl.AssetServiceImpl;
import com.assestmanagement.service.impl.CategoryServiceImpl;
import com.assestmanagement.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private AssetServiceImpl assetService;

    @GetMapping("/home")
    public String home(){
        return "this is home url";
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee emp){
        this.employeeService.addEmployee(emp);
        return emp;
    }


    // create new category
    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category category){
//        System.out.println("controller12"+category); //for debugging purpose
        Category category1 = this.categoryService.addCategory(category);
//        System.out.println("controller"+category1); //for debugging purpose
        return category1;
    }

    //update a category
    @PutMapping("/update-category")
    public Category updateCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.updateCategory(category);
        System.out.println(category1);
        return category1;
    }

    //delete a category
    @DeleteMapping("/delete-category/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String categoryId){
        try {
            this.categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //list of all category
    @GetMapping("/categories")
    public List<Category> allCategory(){
        return this.categoryService.allCategory();

    }

//    ----------------------------Assets functionality start here-------------------------------


    //create a new asset
    @PostMapping("/asset")
    public Asset addAsset(@RequestBody Asset asset){
        System.out.println(asset);
        Asset asset1 = this.assetService.addAsset(asset);
        System.out.println(asset1);
        return asset1;
    }

    //list of all assets
    @GetMapping("/assets")
    public List<Asset> allAsset(){
        return  this.assetService.allAssets();
    }

    //get asset by name
    @GetMapping("/asset/{assetName}")
    public List<Asset> getAssetByName(@PathVariable String assetName){
        return this.assetService.getAssetByName(assetName);
//        System.out.println(asset);
//        return asset;
    }

    //update old asset
    @PutMapping("update-asset")
    public Asset updateAsset(@RequestBody Asset asset){
        Asset asset1 = this.assetService.updateAsset(asset);
        System.out.println("new asset" + asset1);
        return asset1;
    }

    //delete asset
    @DeleteMapping("/asset/{assetId}")
    public ResponseEntity<HttpStatus> deleteAsset(@PathVariable String assetId) {
        try {
            this.assetService.deleteAsset(assetId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //asset assigned to employee
    @PutMapping("/asset/{assetId}/{status}")
    public String assetAssignedTOEmployee(@PathVariable String assetId, @PathVariable Status status){
        String result = "";
        if(status == Status.AVAILABLE){
            result = this.assetService.assignedAssetToEmployee(status, assetId);
        } else if(status == Status.RCOVERED) {
            result = this.assetService.recoveredAssetFromEmployee(status, assetId);
        }
        System.out.println(result);
        return result;
    }
}
