package LibraryDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Book;
import entity.Member;
import entity.Transaction;

public class LibraryDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("lmshibernate");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void saveBook(Book book) {
		transaction.begin();
		manager.persist(book);
		transaction.commit();
	}

	public void findBook(int id) {
		Book book = manager.find(Book.class, id);
		if (book != null) {
			System.out.println(book);
		} else {
			System.out.println("Book is Not Available..!");
		}
	}

	public void findAvailableBook() {
		Query query = manager.createQuery("SELECT b FROM Book b WHERE b.available = true");
		List<Book> book = query.getResultList();
		for (Book b : book) {
			System.out.println(b);
		}
	}

	public void updateBook(Book book) {
		transaction.begin();
		manager.merge(book);
		transaction.commit();
	}

	// --------Memeber DAO

	public void saveMember(Member member) {
		transaction.begin();
		manager.persist(member);
		transaction.commit();
	}

	public void findMemberByID(int id) {
		Member member = manager.find(Member.class, id);
		if (member != null) {
			System.out.println(member);
		} else {
			System.out.println("Member not Found...!");
		}
	}

	// ---------Transaction

	public void saveTransaction(Transaction tras) {
		transaction.begin();
		manager.persist(tras);
		transaction.commit();
	}

	public void updateTransaction(Transaction trans) {
		transaction.begin();
		manager.merge(trans);
		transaction.commit();
	}

	public void findById(int id) {
		Transaction trans = manager.find(Transaction.class, id);
		System.out.println(trans);
	}
}
