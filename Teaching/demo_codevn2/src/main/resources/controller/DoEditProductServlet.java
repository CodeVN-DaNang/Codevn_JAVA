package src.main.resources.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import beans.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/doEditProduct" })
public class DoEditProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public DoEditProductServlet() {
    super();
  }

  
  ProductService productService = new ProductService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    String code = (String) request.getParameter("code");
    String name = (String) request.getParameter("name");
    String priceStr = (String) request.getParameter("price");
    float price = 0;
    try {
      price = Float.parseFloat(priceStr);
    } catch (Exception e) {
    }
    Product product = new Product(code, name, price);

    String errorString = null;

    try {
      productService.editProduct(code, product);
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }

    // Store infomation to request attribute, before forward to views.
    request.setAttribute("errorString", errorString);
    request.setAttribute("product", product);


    // If error, forward to Edit page.
    if (errorString != null) {
      RequestDispatcher dispatcher = request.getServletContext()
                                     .getRequestDispatcher("/WEB-INF/templates/editProductView.jsp");
      dispatcher.forward(request, response);
    }

    // If everything nice.
    // Redirect to the product listing page.
    else {
      response.sendRedirect(request.getContextPath() + "/productList");
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doGet(request, response);
  }

}