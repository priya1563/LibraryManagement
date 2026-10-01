package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAO {

    // CREATE
    public void addBook(Book book) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(book);

            transaction.commit();

            System.out.println("Book added successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // READ - All Books
    public List<Book> getAllBooks() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Book> query =
                    session.createQuery("from Book", Book.class);

            return query.getResultList();
        }
    }


    // READ - Book by ID
    public Book getBookById(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Book.class, id);
        }
    }


    // UPDATE
    public void updateBook(Book book) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(book);

            transaction.commit();

            System.out.println("Book updated successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteBook(int id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Book book = session.get(Book.class, id);

            if (book != null) {
                session.remove(book);
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}