package model.repository;

import java.util.ArrayList;

import model.entity.Product;

public class ProductRepository {
    ArrayList<Product> productList = new ArrayList<>();

    // read write
    
    public ArrayList<Product> getAllProduct(){
        return productList;
    }

    public Product getProductById(int id){
        for (int i = 0; i < productList.size(); i++) {
            if(id == productList.get(i).getProductId()){
                return productList.get(i);
            }
        }
        return null;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void deleteProduct(Product product){
        productList.remove(product);
    }

    public void editProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (product.getProductId() == productList.get(i).getProductId()) {
                productList.set(i, product);
                return;
            }
        }
    }

}
