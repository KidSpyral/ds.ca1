<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
</head>
<body>
    <form action= "http://localhost:8080/CA1.DS23/restful-services/customerserviceDBCRUD/hello" method="GET">               
        <input type="submit" value="Hello World Test">
    </form>
	
	  <form action= "http://localhost:8080/CA1.DS23/restful-services/customerserviceDBCRUD/echo/message" method="GET">       
        <input type="submit" value="Print Message ">
    </form>

	<form action= "http://localhost:8080/CA1.DS23/restful-services/customerserviceDBCRUD/customers" method="GET">  
        <input type="submit" value="View All Customers">
    </form>
		
	<form action= "http://localhost:8080/CA1.DS23/restful-services/customerserviceDBCRUD/json/customers" method="GET">  
        <input type="submit" value="View JSON All Customers ">
    </form>
	
	<form action= "http://localhost:8080/CA1.DS23/restful-services/customerserviceDBCRUD/json/employee/11elderheathcrescent" method="GET">  
        <input type="submit" value="View JSON Customer Address">
    </form>
	
	
    <form action= "http://localhost:8080/CA1.DS23/restful-services/loanserviceDBCRUD/hello" method="GET">
        <input type="submit" value="Hello World Test">
    </form>
	
		  <form action= "http://localhost:8080/CA1.DS23/restful-services/loanserviceDBCRUD/echo/message" method="GET">      
        <input type="submit" value="Print Message ">
    </form>
	
		<form action= "http://localhost:8080/CA1.DS23/restful-services/loanserviceDBCRUD/loans" method="GET">  
        <input type="submit" value="View All Loans">
    </form>
	
		<form action= "http://localhost:8080/CA1.DS23/restful-services/loanserviceDBCRUD/json/loans" method="GET">  
        <input type="submit" value="View JSON All Loans ">
    </form>
	
	
	    <form action= "http://localhost:8080/CA1.DS23/restful-services/depositserviceDBCRUD/hello" method="GET">
        <input type="submit" value="Hello World Test">
    </form>
	
		  <form action= "http://localhost:8080/CA1.DS23/restful-services/depositserviceDBCRUD/echo/message" method="GET">      
        <input type="submit" value="Print Message ">
    </form>
	
		<form action= "http://localhost:8080/CA1.DS23/restful-services/depositserviceDBCRUD/deposits" method="GET">  
        <input type="submit" value="View All Deposits">
    </form>
	
		<form action= "http://localhost:8080/CA1.DS23/restful-services/depositserviceDBCRUD/json/deposits" method="GET">  
        <input type="submit" value="View JSON All Deposits ">
    </form>
	
</body>
</html>