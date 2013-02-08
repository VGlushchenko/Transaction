package com.in6k.dao;

import com.in6k.com.in6k.util.HibernateUtil;
import com.in6k.entity.Transaction;
import org.hibernate.Session;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOimpl /*implements TransactionDAO */{

    public static void save(Transaction transaction) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static List<Transaction> load() throws IOException, SQLException {

        Session session = null;
        List<Transaction> list = new ArrayList<Transaction>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Transaction.class).list();

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
        Transaction transaction = getById(id);

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(transaction);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Error", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Transaction getById(Integer id) throws SQLException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = (Transaction) session.get(Transaction.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return transaction;
    }

    public static void update(Integer id, Transaction transaction) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(transaction);
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
