package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowed_books")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowId;

    private int memberId;
    private int bookId;

    public Borrow() {
    }

    public Borrow(int memberId, int bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", memberId=" + memberId +
                ", bookId=" + bookId +
                '}';
    }
}