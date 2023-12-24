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

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EditProductServlet() {
    super();
  }

  ProductService productService = new ProductService();


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    Connection conn = MyUtils.getStoredConnection(request);

    String code = (String) request.getParameter("code");

    Product product = null;

    String errorString = null;

    try {
      product = productService.getProductById(code);
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }


    // If no error.
    // The product does not exist to edit.
    // Redirect to productList page.
    if (errorString != null && product == null) {
      response.sendRedirect(request.getServletPath() + "/productList");
      return;
    }

    // Store errorString in request attribute, before forward to views.
    request.setAttribute("errorString", errorString);
    request.setAttribute("product", product);

    RequestDispatcher dispatcher = request.getServletContext()
                                   .getRequestDispatcher("/WEB-INF/templates/editProductView.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doGet(request, response);
  }

}