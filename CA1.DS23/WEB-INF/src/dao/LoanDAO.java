package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Loan;
import entities.Customer;

public class LoanDAO {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public LoanDAO() {

	}

	public void persist(Loan loan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Loan loan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(loan));
		em.getTransaction().commit();
		em.close();
	}

	public Loan merge(Loan loan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan updatedLoan = em.merge(loan);
		em.getTransaction().commit();
		em.close();
		return updatedLoan;
	}

	public List<Loan> getAllLoans() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Loan> loansFromDB = new ArrayList<Loan>();
		loansFromDB = em.createNamedQuery("Loan.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return loansFromDB;
	}

	public Loan getLoanByAmount(double loanAmount) {
		EntityManager em = emf.createEntityManager();
		List<Loan> loans = (List<Loan>) em.createNamedQuery("Loan.findByAmount").setParameter("loanAmount", loanAmount)
				.getResultList();
		em.close();
		Loan ln = new Loan();
		for (Loan l : loans) {
			ln = l;
		}
		return ln;
	}

}
