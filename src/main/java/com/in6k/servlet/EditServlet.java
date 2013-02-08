package com.in6k.servlet;

import com.in6k.dao.AccountDAOimpl;
import com.in6k.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer accId = new Integer(request.getParameter("accId"));

        if (request.getParameter("action").equals("update")) {
            Account account = null;

            try {
                account = AccountDAOimpl.getById(accId);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            request.setAttribute("accName", account.getName());
            request.getRequestDispatcher("/index.jsp").include(request, response);
        }
        else if (request.getParameter("action").equals("delete")) {
            try {
                AccountDAOimpl.delete(accId);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/account.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
