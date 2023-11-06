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
import main.Test;

@Path("/customerserviceDBCRUD")
public class CustomerServiceDBCRUD {

	private static Map<String, Customer> customers = new HashMap<String, Customer>();

	static {

		Customer customer1 = new Customer();
		customer1.setName("Faruuq");
		customer1.setPhoneNumber("0871123456");
		customer1.setAddress("11 Elder Heath Grove");
		customer1.setSalary(54000);
		customers.put(customer1.getAddress(), customer1);

		Customer customer2 = new Customer();
		customer2.setName("Tom");
		customer2.setPhoneNumber("0861123456");
		customer2.setAddress("11 Elder Heath Crescent");
		customer2.setSalary(74000);
		customers.put(customer2.getAddress(), customer2);

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
	@Path("/customers")
	@Produces("application/xml")
	public List<Customer> listCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

	@GET
	@Path("/customer/{customerName}")
	@Produces("application/xml")
	public Customer getCustomer(@PathParam("customerName") String name) {
		return customers.get(name);
	}

	@POST
	@Path("/createxml")
	@Consumes("application/xml")
	public String addCustomer(Customer customer) {
		return "Employee added " + customer.getName();
	}

	@POST
	@Path("/createjson")
	@Consumes("application/json")
	public String addJSONEmployee(Customer customer) {
		return "Customer added " + customer.getName();
	}

	@GET
	@Path("/json/customers/")
	@Produces("application/json")
	public List<Customer> listCustomersJSON() {
		return new ArrayList<Customer>(customers.values());
	}

	@GET
	@Path("/json/customers/{customerName}")
	@Produces("application/json")
	public Customer getCustomerJSON(@PathParam("customerName") String name) {
		return customers.get(name);
	}

	@GET
	@Path("/customersxmlfromdb")
	@Produces("application/xml")
	public ArrayList<Customer> getCustomersFromDB() {
		CustomerDAO cDAO = new CustomerDAO();
		return (ArrayList<Customer>) cDAO.getAllCustomers();
	}

	@GET
	@Path("/customersjsonfromdb")
	@Produces("application/json")
	public ArrayList<Customer> getJSONCustomersFromDB() {
		CustomerDAO cDAO = new CustomerDAO();
		return (ArrayList<Customer>) cDAO.getAllCustomers();
	}

	@GET
	@Path("/jsonDB/customer/{customerName}")
	@Produces("application/json")
	public Customer getCustomerByNameFromDBJSON(@PathParam("customerName") String name) {
		CustomerDAO cDAO = new CustomerDAO();
		return cDAO.getCustomerByName(name);
	}

	@GET
	@Path("/customerfromDBXML/{customerName}")
	@Produces("application/xml")
	public Customer getCustomerByNameFromDBXML(@PathParam("customerName") String name) {
		CustomerDAO cDAO = new CustomerDAO();
		return cDAO.getCustomerByName(name);
	}

	@POST
	@Path("/newCustomer")
	@Consumes("application/json")
	public String addCustomerToDBJSON(Customer customer) {
		CustomerDAO cDAO = new CustomerDAO();
		cDAO.persist(customer);
		return "Customer added to DB from JSON Param " + customer.getName();
	}

	@PUT
	@Path("/updateCustomer/")
	@Produces("application/json")
	public Customer updateCustomer(Customer customer) {
		CustomerDAO cDAO = new CustomerDAO();
		return cDAO.merge(customer);
	}

	@DELETE
	@Path("/deleteCustomer/{customerName}")
	@Produces("text/plain")
	public String deleteEmployee(@PathParam("customerName") String name) {
		CustomerDAO cDAO = new CustomerDAO();
		Customer emp = cDAO.getCustomerByName(name);
		cDAO.remove(emp);
		return "Customer " + emp + " deleted";
	}
}
