package com.demo.codevn_2.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.codevn_2.model.entity.Product;
import com.demo.codevn_2.model.entity.ProductCategory;
import com.demo.codevn_2.model.repository.ProductCategoryRepository;
import com.demo.codevn_2.model.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository = new ProductRepository();
    ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();

    public ArrayList<Product> getAllProducts() throws Exception{
        return productRepository.getAllProducts();
    }

    public ArrayList<ProductCategory> getAllProductCategories() throws Exception {
        return productCategoryRepository.getAllCategories();
    }

    public Product getProductById(int productId) throws Exception{
        return productRepository.getProductById(productId);
    }

    public ProductCategory getProductCategoryById(int productCategoryId) throws Exception {
        return productCategoryRepository.getProductCategoryById(productCategoryId);
    }

    public void addProduct(Product product) throws Exception {
        productRepository.addProduct(product);
    }
}
