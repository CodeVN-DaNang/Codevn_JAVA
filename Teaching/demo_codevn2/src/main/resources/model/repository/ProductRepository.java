package model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Product;

public class ProductRepository {

    BaseConnection bc = new BaseConnection();

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement pstm = bc.getConnection().prepareStatement("select * from product;");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String idProduct = rs.getString("code");
            String nameProduct = rs.getString("name");
            float price = rs.getFloat("price");
            Product product = new Product(idProduct, nameProduct, price);
            products.add(product);
        }
        return products;
    }

    public Product findProductById(String id) {
        PreparedStatement pstm = bc.getConnection().prepareStatement("select * from product where code = ?;");
        pstm.setString(1, id);
        ResultSet rs = pstm.executeQuery();
        String idProduct = rs.getString("code");
        String nameProduct = rs.getString("name");
        float price = rs.getFloat("price");
        Product product = new Product(idProduct, nameProduct, price);
        return product;
    }

    public void addNewProduct(Product product){
        PreparedStatement pstm = bc.getConnection().prepareStatement("insert into product(code, name, price) values (?, ?, ?);");
        pstm.setString(1, product.getIdProduct());
        pstm.setString(2, product.getNameProduct());
        pstm.setString(3, product.getPrice());
        ResultSet rs = pstm.executeQuery();
    }

    public void deleteProduct(String id){
        PreparedStatement pstm = bc.getConnection().prepareStatement("delete from product where code = ?;");
        pstm.setString(1, product.getIdProduct());
        ResultSet rs = pstm.executeQuery();
    }

    public void editProduct(String id, Product product){
        PreparedStatement pstm = bc.getConnection().prepareStatement("update product set name = ?, price = ? where code = ?;");
        pstm.setString(1, product.getNameProduct());
        pstm.setString(2, product.getPrice());
        pstm.setString(3, product.getIdProduct());
    }

}
