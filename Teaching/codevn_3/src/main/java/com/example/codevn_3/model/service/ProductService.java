package com.example.codevn_3.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codevn_3.model.entity.Product;
import com.example.codevn_3.model.entity.ProductCategory;
import com.example.codevn_3.model.repository.ProductCategoryRepository;
import com.example.codevn_3.model.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository = new ProductRepository();
    ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();

    public ArrayList<Product> getAllProduct() {
        try {
            return productRepository.getAllProduct();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductById(int productId) {
        try {
            return productRepository.getProductById(productId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void addNewProduct(Product product){
        try {
            productRepository.addProduct(product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            productRepository.deleteProduct(productId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editProduct(Product product) {
        try {
            productRepository.editProduct(product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<ProductCategory> getAllProductCategories() {
        try {
            return productCategoryRepository.getAllProductCategory();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return null;       
    }

    public ProductCategory getProductCategoryById(int productCategoryId) {
        try {
            return productCategoryRepository.getProductCategoryById(productCategoryId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
