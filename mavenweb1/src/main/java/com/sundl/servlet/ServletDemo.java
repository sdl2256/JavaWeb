package com.sundl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SDL on 2015/5/8.
 */
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String action = req.getParameter("action");
        if ("login_input".equals(action)) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if ("login".equals(action)) {
            String name = req.getParameter("name");
            String password = req.getParameter("password");

            System.out.println("name->" + name + ",password->" + password);
        }
    }
}
