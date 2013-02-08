package com.in6k.dao;

import com.in6k.com.in6k.util.HibernateUtil;
import com.in6k.entity.Account;
import org.hibernate.Session;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOimpl /*implements AccountDAO*/ {

    public static void save(Account account) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static List<Account> load() throws IOException, SQLException {
        Session session = null;
        List<Account> list = new ArrayList<Account>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Account.class).list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return list;
    }

    public static void delete(Integer id) throws SQLException {
        Session session = null;
        Account account = getById(id);

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(account);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Error", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Account getById(Integer id) throws SQLException {
        Session session = null;
        Account account = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            account = (Account) session.get(Account.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return account;
    }

    public static void update(Integer id, Account account) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Update Error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
