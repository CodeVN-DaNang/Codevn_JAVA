package com.example.codevn_3.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.codevn_3.model.entity.ProductCategory;

@Repository
public class ProductCategoryRepository {

    public ArrayList<ProductCategory> getAllProductCategory() throws Exception {
        ArrayList<ProductCategory> productCategoryList = new ArrayList<>();
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select * from product_category");
        while (rs.next()) {
            int productCategoryId = rs.getInt("product_category_id");
            String productCategoryName = rs.getString("product_category_name");
            ProductCategory productCategory = new ProductCategory(productCategoryId, productCategoryName);
            productCategoryList.add(productCategory);
        }
        stm.close();
        return productCategoryList;
    }

    public ProductCategory getProductCategoryById(int productCategoryId) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement pst = conn.prepareStatement("select * from product_category where product_category_id = ?");
        pst.setInt(1, productCategoryId);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String productCategoryName = rs.getString("product_category_name");
        ProductCategory productCategory = new ProductCategory(productCategoryId, productCategoryName);
        pst.close();
        return productCategory;
    }

}
