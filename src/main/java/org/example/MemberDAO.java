package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MemberDAO {

    public void addMember(Member member) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(member);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Query<Member> query =
                    session.createQuery("from Member", Member.class);

            return query.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}