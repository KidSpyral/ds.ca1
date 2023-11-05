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
import entities.Deposit;
import main.Test;

@Path("/depositserviceDBCRUD")
public class DepositServiceDBCRUD {

	private static Map<String, Deposit> deposits = new HashMap<String, Deposit>();

	static {

		Deposit deposit1 = new Deposit();
		deposit1.setDepositDate("10/7/23");
		deposit1.setDepositAmount(200);
		deposits.put(deposit1.getDepositDate(), deposit1);

		Deposit deposit2 = new Deposit();
		deposit2.setDepositDate("10/8/23");
		deposit2.setDepositAmount(200);
		deposits.put(deposit2.getDepositDate(), deposit2);
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
	@Path("/deposits")
	@Produces("application/xml")
	public List<Deposit> listDeposits() {
		return new ArrayList<Deposit>(deposits.values());
	}

	@GET
	@Path("/deposit/{depositdate}")
	@Produces("application/xml")
	public Deposit getDeposit(@PathParam("depositdate") String depositDate) {
		return deposits.get(depositDate);
	}

	@POST
	@Path("/createxml")
	@Consumes("application/xml")
	public String addDeposit(Deposit deposit) {
		return "Deposit added " + deposit.getDepositAmount();
	}

	@POST
	@Path("/createjson")
	@Consumes("application/json")
	public String addJSONDeposit(Deposit deposit) {
		return "Deposit added " + deposit.getDepositAmount();
	}

	@GET
	@Path("/json/deposits/")
	@Produces("application/json")
	public List<Deposit> listDepositsJSON() {
		return new ArrayList<Deposit>(deposits.values());
	}

	@GET
	@Path("/json/deposits/{depositdate}")
	@Produces("application/json")
	public Deposit getDepositJSON(@PathParam("depositdate") String depositDate) {
		return deposits.get(depositDate);
	}

	@GET
	@Path("/depositsxmlfromdb")
	@Produces("application/xml")
	public ArrayList<Deposit> getDepositsFromDB() {
		DepositDAO dDAO = new DepositDAO();
		return (ArrayList<Deposit>) dDAO.getAllDeposits();
	}

	@GET
	@Path("/depositsjsonfromdb")
	@Produces("application/json")
	public ArrayList<Deposit> getJSONDepositsFromDB() {
		DepositDAO dDAO = new DepositDAO();
		return (ArrayList<Deposit>) dDAO.getAllDeposits();
	}

	@GET
	@Path("/jsonDB/deposit/{depositDate}")
	@Produces("application/json")
	public Deposit getDepositByDateFromDBJSON(@PathParam("depositDate") String depositDate) {
		DepositDAO dDAO = new DepositDAO();
		return dDAO.getDepositByDate(depositDate);
	}

	@GET
	@Path("/depositfromDBXML/{depositDate}")
	@Produces("application/xml")
	public Deposit getDepositByDateFromDBXML(@PathParam("depositDate") String depositDate) {
		DepositDAO dDAO = new DepositDAO();
		return dDAO.getDepositByDate(depositDate);
	}

	@POST
	@Path("/newDeposit")
	@Consumes("application/json")
	public String addDepositToDBJSON(Deposit deposit) {
		DepositDAO dDAO = new DepositDAO();
		dDAO.persist(deposit);
		return "Deposit added to DB from JSON Param " + deposit.getDepositAmount();
	}

	@PUT
	@Path("/updateDeposit/")
	@Produces("application/json")
	public Deposit updateCustomer(Deposit deposit) {
		DepositDAO dDAO = new DepositDAO();
		return dDAO.merge(deposit);
	}

	@DELETE
	@Path("/deleteDeposit/{depositDate}")
	@Produces("text/plain")
	public String deleteEmployee(@PathParam("depositDate") String depositDate) {
		DepositDAO dDAO = new DepositDAO();
		Deposit emp = dDAO.getDepositByDate(depositDate);
		dDAO.remove(emp);
		return "Deposit " + emp + " deleted";
	}
}
