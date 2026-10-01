package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO dao = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowDAO borrowDAO=new BorrowDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add Student Member");
            System.out.println("7. View All Members");
            System.out.println("8. Issue / Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. View Borrowed Books");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ADD BOOK
                case 1:

                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(title, author, category, quantity);

                    dao.addBook(book);

                    System.out.println("Book added successfully!");

                    break;


                // VIEW ALL BOOKS
                case 2:

                    List<Book> books = dao.getAllBooks();

                    if (books.isEmpty()) {
                        System.out.println("No books found!");
                    } else {

                        System.out.println("\n===== ALL BOOKS =====");

                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }

                    break;


                // SEARCH BOOK BY ID
                case 3:

                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    Book foundBook = dao.getBookById(searchId);

                    if (foundBook != null) {

                        System.out.println("Book found:");
                        System.out.println(foundBook);

                    } else {

                        System.out.println("Book not found!");
                    }

                    break;


                // UPDATE BOOK
                case 4:

                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Book updateBook = dao.getBookById(updateId);

                    if (updateBook != null) {

                        System.out.print("Enter new title: ");
                        updateBook.setTitle(sc.nextLine());

                        System.out.print("Enter new author: ");
                        updateBook.setAuthor(sc.nextLine());

                        System.out.print("Enter new category: ");
                        updateBook.setCategory(sc.nextLine());

                        System.out.print("Enter new quantity: ");
                        updateBook.setQuantity(sc.nextInt());
                        sc.nextLine();

                        dao.updateBook(updateBook);

                        System.out.println("Book updated successfully!");

                    } else {

                        System.out.println("Book not found!");
                    }

                    break;


                // DELETE BOOK
                case 5:

                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    dao.deleteBook(deleteId);

                    System.out.println("Book deleted successfully!");

                    break;


                // ADD STUDENT MEMBER
                case 6:

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    Member member = new Member(name, email, phone);

                    memberDAO.addMember(member);

                    System.out.println("Member added successfully!");

                    break;


                // VIEW ALL MEMBERS
                case 7:

                    List<Member> members = memberDAO.getAllMembers();

                    System.out.println("\n===== ALL MEMBERS =====");

                    if (members.isEmpty()) {

                        System.out.println("No members found!");

                    } else {

                        for (Member member1 : members) {
                            System.out.println(member1);
                        }
                    }

                    break;


                // ISSUE / BORROW BOOK
                case 8:

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    Borrow borrow = new Borrow(memberId, bookId);

                    borrowDAO.borrowBook(borrow);

                    System.out.println("Book borrowed successfully!");

                    break;


                // RETURN BOOK
                case 9:

                    System.out.print("Enter Borrow ID to return: ");
                    int borrowId = sc.nextInt();
                    sc.nextLine();

                    borrowDAO.returnBook(borrowId);

                    System.out.println("Book returned successfully!");

                    break;


                // VIEW BORROWED BOOKS
                case 10:

                    List<Borrow> borrowedBooks = borrowDAO.getAllBorrowedBooks();

                    if (borrowedBooks.isEmpty()) {
                        System.out.println("No borrowed books found!");
                    } else {

                        System.out.println("\n===== BORROWED BOOKS =====");

                        for (Borrow borrow1 : borrowedBooks) {
                            System.out.println(borrow1);
                        }
                    }

                    break;


                // EXIT
                case 11:

                    System.out.println("Thank you for using Library Management System!");

                    sc.close();

                    return;


                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}