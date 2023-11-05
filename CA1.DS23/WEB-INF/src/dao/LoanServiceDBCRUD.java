package dao;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Customer;
import entities.Loan;
import main.Test;

@Path("/loanserviceDBCRUD")
public class LoanServiceDBCRUD {

	private static Map<String, Loan> loans = new HashMap<String, Loan>();

	static {

		Loan loan1 = new Loan();
		loan1.setDescription("Buy a new house");
		loan1.setLoanAmount(500000);
		loans.put(loan1.getDescription(), loan1);

		Loan loan2 = new Loan();
		loan2.setDescription("Buy some land");
		loan2.setLoanAmount(600000);
		loans.put(loan2.getDescription(), loan2);
	}

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello World";
	}

	@GET
	@Path("/helloworld")
	@Produces("text/plain")
	public String helloWorld() {
		return "Hello World New";
	}

	@GET
	@Path("/echo/{message}")
	@Produces("text/plain")
	public String echo(@PathParam("message") String message) {
		return message;
	}

	@GET
	@Path("/loans")
	@Produces("application/xml")
	public List<Loan> listLoans() {
		return new ArrayList<Loan>(loans.values());
	}

	@GET
	@Path("/loan/{loanAmount}")
	@Produces("application/xml")
	public Loan getLoan(@PathParam("loanAmount") double loanAmount) {
		return loans.get(loanAmount);
	}

	@POST
	@Path("/createxml")
	@Consumes("application/xml")
	public String addLoan(Loan loan) {
		return "Loan added " + loan.getDescription();
	}

	@POST
	@Path("/createjson")
	@Consumes("application/json")
	public String addJSONLoan(Loan loan) {
		return "Loan added " + loan.getDescription();
	}

	@GET
	@Path("/json/loans")
	@Produces("application/json")
	public List<Loan> listLoansJSON() {
		return new ArrayList<Loan>(loans.values());
	}

	@GET
	@Path("/json/loans/{loanAmount}")
	@Produces("application/json")
	public Loan getLoanJSON(@PathParam("loanAmount") double loanAmount) {
		return loans.get(loanAmount);
	}

	@GET
	@Path("/loansxmlfromdb")
	@Produces("application/xml")
	public ArrayList<Loan> getLoansFromDB() {
		LoanDAO lDAO = new LoanDAO();
		return (ArrayList<Loan>) lDAO.getAllLoans();
	}

	@GET
	@Path("/loansjsonfromdb")
	@Produces("application/json")
	public ArrayList<Loan> getJSONLoansFromDB() {
		LoanDAO lDAO = new LoanDAO();
		return (ArrayList<Loan>) lDAO.getAllLoans();
	}

	@GET
	@Path("/jsonDB/loan/{loanAmount}")
	@Produces("application/json")
	public Loan getLoanByAmountFromDBJSON(@PathParam("loanAmount") double loanAmount) {
		LoanDAO lDAO = new LoanDAO();
		return lDAO.getLoanByAmount(loanAmount);
	}

	@GET
	@Path("/loanfromDBXML/{loanAmount}")
	@Produces("application/xml")
	public Loan getLoanByAmountFromDBXML(@PathParam("loanAmount") double loanAmount) {
		LoanDAO lDAO = new LoanDAO();
		return lDAO.getLoanByAmount(loanAmount);
	}

	@POST
	@Path("/newLoan")
	@Consumes("application/json")
	public String addLoanToDBJSON(Loan loan) {
		LoanDAO lDAO = new LoanDAO();
		lDAO.persist(loan);
		return "Loan added to DB from JSON Param " + loan.getLoanAmount();
	}

	@PUT
	@Path("/updateLoan/")
	@Produces("application/json")
	public Loan updateLoan(Loan loan) {
		LoanDAO lDAO = new LoanDAO();
		return lDAO.merge(loan);
	}

	@DELETE
	@Path("/deleteLoan/{loanAmount}")
	@Produces("text/plain")
	public String deleteLoan(@PathParam("loanAmount") double loanAmount) {
		LoanDAO lDAO = new LoanDAO();
		Loan emp = lDAO.getLoanByAmount(loanAmount);
		lDAO.remove(emp);
		return "Loan " + emp + " deleted";
	}
}
