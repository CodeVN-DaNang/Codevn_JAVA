package src.main.resources.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public DeleteProductServlet() {
    super();
  }

  ProductService productService = new ProductService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

    String code = (String) request.getParameter("code");

    String errorString = null;

    try {
      productService.deleteProduct(code);
    } catch (SQLException e) {
      e.printStackTrace();
      errorString = e.getMessage();
    }


    // If an error redirected to an error page.
    if (errorString != null) {

      // Store the information in the request attribute, before forward to views.
      request.setAttribute("errorString", errorString);
      //
      RequestDispatcher dispatcher = request.getServletContext()
                                     .getRequestDispatcher("/WEB-INF/templates/deleteProductErrorView.jsp");
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