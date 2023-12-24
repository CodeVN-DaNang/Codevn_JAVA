package com.demo.codevn_2.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.codevn_2.model.entity.Product;
import com.demo.codevn_2.model.entity.ProductCategory;

@Repository
public class ProductRepository {
    @Autowired
    ProductCategoryRepository productCategoryRepository = new ProductCategoryRepository();

    public ArrayList<Product> getAllProducts() throws Exception {
        ArrayList<Product> productList = new ArrayList<>();
        Connection conn = BaseConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product_management_test.product");
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            String productCode = rs.getString("product_code");
            int productCategoryId = rs.getInt("product_category_id");
            ProductCategory productCategory = productCategoryRepository
                    .getProductCategoryById(productCategoryId);
            Product product = new Product(productId, productCode, productCategory);
            productList.add(product);
        }
        conn.close();
        return productList;
    }

    public Product getProductById(int productId) throws Exception {
        Connection conn = BaseConnection.getConnection();
        PreparedStatement st = conn
                .prepareStatement("select * from product_management_test.product where product.product_id = ?;");
        st.setInt(1, productId);
        ResultSet rs = st.executeQuery();
        rs.next();
        String productCode = rs.getString("product_code");
        int productCategoryId = rs.getInt("product_category_id");
        ProductCategory productCategory = productCategoryRepository
                .getProductCategoryById(productCategoryId);
        Product product = new Product(productId, productCode, productCategory);
        conn.close();
        return product;
    }

    public boolean addProduct(Product product) throws Exception {
        Connection conn = BaseConnection.getConnection();
        PreparedStatement st = conn
                .prepareStatement(
                        "insert into product_management_test.product(product_code, product_category_id) values (?, ?);");
        st.setString(1, product.getProductCode());
        st.setInt(2, product.getProductCategory().getProductCategoryId());
        int check = st.executeUpdate();
        if (check > 0) {
            return true;
        }
        throw new Exception("Stupid dog");
    }

}
