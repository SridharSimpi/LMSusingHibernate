package LibraryJPA;

import java.time.LocalDate;

import LibraryDAO.LibraryDAO;
import entity.Book;
import entity.Member;
import entity.Transaction;

public class LibraryMain {
    public static void main(String[] args) {

        // Create Book
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setAvailable(true);

        // Create Member
        Member member = new Member();
        member.setName("Sridhar");
        member.setEmail("sridhar@123");

        // Create Transaction
        Transaction transaction = new Transaction();
        transaction.setIssueDate(LocalDate.of(2025, 6, 10));
        transaction.setReceivedDate(LocalDate.of(2025, 7, 1));
        transaction.setStatus("ISSUED");
        transaction.setBook(book);     // Set book
        transaction.setMember(member); // Set member

        // Save everything via DAO
        LibraryDAO dao = new LibraryDAO();
        dao.saveBook(book);       // Save book first
        dao.saveMember(member);   // Save member
        dao.saveTransaction(transaction); // Then transaction

        System.out.println("Transaction saved successfully.");
    }
}
