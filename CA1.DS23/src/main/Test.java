package main;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import dao.LoanDAO;
import dao.DepositDAO;
import entities.Customer;
import entities.Loan;
import entities.Deposit;

public class Test {
	
	public Test() {
		CustomerDAO cDAO = new CustomerDAO();
		LoanDAO lDAO = new LoanDAO();
		DepositDAO dDAO = new DepositDAO();
		
		
		
		//Add comments
		Deposit d1 = new Deposit("10/1/23", 200.00);
		Deposit d2 = new Deposit("10/2/23", 200.00);
		Deposit d3 = new Deposit("10/3/23", 200.00);
		dDAO.persist(d1);
		dDAO.persist(d2);
		dDAO.persist(d3);
		
		List<Deposit> deposits = new ArrayList<Deposit>();
		deposits.add(d1);
		deposits.add(d2);
		deposits.add(d3);
		
		Loan loan = new Loan("Buy a house", 500000.00, deposits);
		lDAO.persist(loan);
		
		Customer customer = new Customer("Faruuq", "0871183078", "11 Elder Heath Driver", 60000, loan);
		cDAO.persist(customer);
		
		ArrayList<Customer> customers = (ArrayList<Customer>) cDAO.getAllCustomers();
		for(Customer c : customers) {
			System.out.println("Customers object name is "+c.getName());
			System.out.println("Customer's Loan says "+ c.getLoan().getDescription());
			System.out.println("Customer's first Loan deposit is "+c.getLoan().getDeposits().get(0).getDepositAmount());
		}

		customer.setName("STEVO");
		cDAO.merge(customer);

		dDAO.remove(d3);
		
		System.out.println(cDAO.getCustomerByName("STEVO").getPhoneNumber());

}
	public static void main(String[] args) {
		new Test();
	}
}