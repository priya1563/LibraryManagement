package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BorrowDAO {

    // Issue / Borrow Book
    public void borrowBook(Borrow borrow) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(borrow);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // View all borrowed books
    public List<Borrow> getAllBorrowedBooks() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Borrow> query =
                    session.createQuery("from Borrow", Borrow.class);

            return query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // Return Book
    public void returnBook(int borrowId) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Borrow borrow = session.get(Borrow.class, borrowId);

            if (borrow != null) {
                session.remove(borrow);
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