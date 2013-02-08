package com.in6k.servlet;

import com.in6k.dao.UserDAOimpl;
import com.in6k.entity.User;
import com.in6k.form.UserForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> users = null;

        try {
            users = UserDAOimpl.load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", users);

        request.getRequestDispatcher("/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserForm uf = new UserForm();
        uf.setId(request.getParameter("id"));
        uf.setName(request.getParameter("name"));
        uf.setEmail(request.getParameter("email"));
        uf.setPassword(request.getParameter("password"));

        User user = new User(uf);

        UserDAOimpl.save(user);

        request.setAttribute("form", user);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
