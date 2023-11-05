package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Deposit;
import entities.Loan;
import entities.Customer;

public class DepositDAO {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public DepositDAO() {

	}

	public void persist(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(deposit);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(deposit));
		em.getTransaction().commit();
		em.close();
	}

	public Deposit merge(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposit updatedDeposit = em.merge(deposit);
		em.getTransaction().commit();
		em.close();
		return updatedDeposit;
	}

	public List<Deposit> getAllDeposits() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Deposit> depositsFromDB = new ArrayList<Deposit>();
		depositsFromDB = em.createNamedQuery("Deposit.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return depositsFromDB;
	}

	public Deposit getDepositByDate(String depositDate) {
		EntityManager em = emf.createEntityManager();
		List<Deposit> deposits = (List<Deposit>) em.createNamedQuery("Deposit.findByDate")
				.setParameter("depositDate", depositDate).getResultList();
		em.close();
		Deposit dep = new Deposit();
		for (Deposit d : deposits) {
			dep = d;
		}
		return dep;
	}

}
