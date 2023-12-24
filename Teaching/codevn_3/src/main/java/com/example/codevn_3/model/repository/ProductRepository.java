package com.example.codevn_3.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.codevn_3.model.entity.Product;
import com.example.codevn_3.model.entity.ProductCategory;

@Repository
public class ProductRepository {
    @Autowired
    ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();

    public ArrayList<Product> getAllProduct() throws Exception {
        ArrayList<Product> productList = new ArrayList<>();
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select * from product");
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            String productCode = rs.getString("product_code");
            int productCategoryId = rs.getInt("product_category_id");
            ProductCategory productCategory = productCategoryRepository.getProductCategoryById(productCategoryId);
            Product product = new Product(productId, productCode, productCategory);
            productList.add(product);
        }
        stm.close();
        return productList;
    }

    public Product getProductById(int productId) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement psm = conn.prepareStatement("select * from product where product_id = ?");
        psm.setInt(1, productId);
        ResultSet rs = psm.executeQuery();
        rs.next();
        String productCode = rs.getString("product_code");
        int productCategoryId = rs.getInt("product_category_id");
        ProductCategory productCategory = productCategoryRepository.getProductCategoryById(productCategoryId);
        Product product = new Product(productId, productCode, productCategory);
        psm.close();
        return product;
    }

    public void addProduct(Product product) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement psm = conn.prepareStatement("insert into product(product_code, product_category_id) values (?, ?)");
        psm.setString(1, product.getProductCode());
        psm.setInt(2, product.getProductCategory().getProductCategoryId());
        psm.executeUpdate();
        psm.close();
    }

    public void deleteProduct(int productId) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement psm = conn.prepareStatement("delete from product where product_id = ?");
        psm.setInt(1, productId);
        psm.executeUpdate();
        psm.close();
    }

    public void editProduct(Product product)throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement psm = conn.prepareStatement("update product set product_code = ?, product_category_id = ? where product_id = ?");
        psm.setString(1, product.getProductCode());
        psm.setInt(2, product.getProductCategory().getProductCategoryId());
        psm.setInt(3, product.getProductId());
        psm.executeUpdate();
        psm.close();
    }

}
