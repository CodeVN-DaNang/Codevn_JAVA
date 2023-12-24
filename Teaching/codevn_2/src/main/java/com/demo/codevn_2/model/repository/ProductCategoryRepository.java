package com.demo.codevn_2.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.demo.codevn_2.model.entity.ProductCategory;

@Repository
public class ProductCategoryRepository {

    public ArrayList<ProductCategory> getAllCategories() throws Exception {
        ArrayList<ProductCategory> productCategorieList = new ArrayList<>();
        Connection conn = BaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product_management_test.product_category");
        while (rs.next()) {
            int productCategoryId = rs.getInt("product_category_id");
            String productCategoryName = rs.getString("product_category_name");
            ProductCategory productCategory = new ProductCategory(productCategoryId, productCategoryName);
            productCategorieList.add(productCategory);
        }
        conn.close();
        return productCategorieList;
    }

    public ProductCategory getProductCategoryById(int productCategoryId) throws Exception {
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "select * from product_management_test.product_category where product_management_test.product_category.product_category_id = ?");
        ps.setInt(1, productCategoryId);
        ResultSet rs = ps.executeQuery();   
        rs.next();
        String productCategoryName = rs.getString("product_category_name");
        ProductCategory productCategory = new ProductCategory(productCategoryId, productCategoryName);
        conn.close();
        return productCategory;
    }

}
