package com.in6k.servlet;

import com.in6k.dao.AccountDAOimpl;
import com.in6k.dao.UserDAOimpl;
import com.in6k.entity.Account;
import com.in6k.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = null;

        try {
            accounts = AccountDAOimpl.load();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("accounts", accounts);

        request.getRequestDispatcher("/account.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = new Integer(request.getParameter("userId"));
        User user = null;

        try {
            user = UserDAOimpl.getById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Account acc = new Account();
        acc.setName(request.getParameter("name"));
        acc.setUser(user);
        acc.setTypeId(25);

        AccountDAOimpl.save(acc);

        response.sendRedirect("/account");
    }
}
