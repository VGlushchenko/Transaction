package com.in6k.dao;

import com.in6k.com.in6k.util.HibernateUtil;
import com.in6k.entity.User;
import org.hibernate.Session;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl {

    public static void save(User user) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static List<User> load() throws IOException, SQLException {
        Session session = null;
        List<User> list = new ArrayList<User>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(User.class).list();

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
        User user = getById(id);

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Error", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static User getById(Integer id) throws SQLException {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return user;
    }

    public static void update(Integer id, User user) throws SQLException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
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
