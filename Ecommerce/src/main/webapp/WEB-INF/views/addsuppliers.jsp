<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- spring form tag -->
<!-- supplier=new Supplier()assigned in SupplierController
supplier.getSuppliername()=null
supplier.getDescription()=null,price is 0,quantity is 0,id is 0
 -->
 <!-- url is a variable
 url=/admin/saveproduct
 url="http://localhost:8080/Projectfrontendp/admin/saveproduct
  -->
  <c:url value='/admin/saveorupdatesupplier' var="url"></c:url>
  <form:form method="post" modelAttribute="supplier" action="${url}"> 
  <table>
  <tr>
  <td><form:label path="sid">Enter Supplier ID</form:label>
  </td>
  <td><form:input path="sid"/></td>
  </tr>
  <td><form:label path="suppliername">Enter Supplier Name</form:label>
  </td>
  <td><form:input path="suppliername"/>
  <form:errors path="suppliername" cssStyle="color:red"></form:errors>
  </td>
  <tr>
  <tr>
  
  
		
				<td><input type="submit" value="Add Supplier"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>