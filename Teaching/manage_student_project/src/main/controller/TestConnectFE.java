package main.controller;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestConnectFE {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            // Reading cookies
            Cookie[] c = request.getCookies();
            // Displaying User name value from cookie
            pwriter.print("Name here: " + c[0].getValue());
            pwriter.print("Password: " + c[1].getValue());
            pwriter.print("<a href='welcome'>View Details</a>");
            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }

    }

}