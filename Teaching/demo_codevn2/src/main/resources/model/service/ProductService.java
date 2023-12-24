package model.service;

import java.util.ArrayList;

import model.entity.Product;
import model.repository.ProductRepository;

public class ProductService {
    
    ProductRepository productRepository = new ProductRepository();

    public ArrayList<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(String code){
        return productRepository.getProductById(code);
    }

    public void addNewProduct(Product product){
        productRepository.addNewProduct(product);
    }

    public void deleteProduct(String code){
        productRepository.deleteProduct(code);
    }

    public void editProduct(String code, Product product){
        productRepository.editProduct(code, product);
    }

}
