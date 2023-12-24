package src.main.resources.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.ProductService;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ProductService productService = new ProductService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String errorString = "";
    ArrayList<Product> list;
    try {
      list = productService.getAllProducts();
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }

    // Store info in request attribute, before forward to views
    request.setAttribute("errorString", errorString);
    request.setAttribute("productList", list);

    // Forward to /WEB-INF/views/productListView.jsp
    RequestDispatcher dispatcher = request.getServletContext()
        .getRequestDispatcher("/WEB-INF/templates/productListView.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}