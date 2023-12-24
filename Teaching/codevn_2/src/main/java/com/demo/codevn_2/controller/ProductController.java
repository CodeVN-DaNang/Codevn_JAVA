package com.demo.codevn_2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.codevn_2.model.entity.Product;
import com.demo.codevn_2.model.entity.ProductCategory;
import com.demo.codevn_2.model.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService productService = new ProductService();

    // show list
    @GetMapping(value = "/")
    public String showList(Model model) throws Exception {
        ArrayList<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "index";
    }

    // add product
    @GetMapping(value = "/addProduct")
    public String showAdd(Model model, Product product) throws Exception {
        ArrayList<ProductCategory> productCategoriList = productService.getAllProductCategories();
        model.addAttribute("productCategoriList", productCategoriList);
        model.addAttribute("product", product);
        return "addProductTemplate";
    }

    @PostMapping(value = "/addProduct/add")
    public String addProduct(@ModelAttribute("product") Product product,
            @RequestParam("productCategoryId") int productCategoryId) throws Exception {
        ProductCategory productCategory = productService.getProductCategoryById(productCategoryId);
        product.setProductCategory(productCategory);
        productService.addProduct(product);
        return showAdd(null, product);
    }

}
