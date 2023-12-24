package com.example.codevn_3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codevn_3.model.entity.Product;
import com.example.codevn_3.model.entity.ProductCategory;
import com.example.codevn_3.model.service.ProductService;

@Controller
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    ProductService productService = new ProductService();

    int status = 0;

    @GetMapping(value = "/show")
    public String showList(Model model) {
        ArrayList<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAdd(Model model) {
        Product product = new Product();
        ArrayList<ProductCategory> productCategoryList = productService.getAllProductCategories();
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping(value = "/add/addNew")
    public String addNewProduct(@ModelAttribute("product") Product product,
            @RequestParam("productCategorySelect") int productCategoryId) {
        ProductCategory productCategory = productService.getProductCategoryById(productCategoryId);
        product.setProductCategory(productCategory);
        productService.addNewProduct(product);
        return "add";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        productService.deleteProduct(id);
        return showList(model);
    }

    @GetMapping(value = "/view/{id}")
    public String showInforProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        ArrayList<ProductCategory> productCategoryList = productService.getAllProductCategories();
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("product", product);
        this.status = id;
        return "view";
    }

    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute("product") Product product,
            @RequestParam("productCategorySelect") int productCategoryId, Model model) {
        product.setProductId(this.status);
        ProductCategory productCategory = productService.getProductCategoryById(productCategoryId);
        product.setProductCategory(productCategory);
        productService.editProduct(product);
        return showInforProduct(product.getProductId(), model);
    }
}
