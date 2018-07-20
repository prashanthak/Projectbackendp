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
	<!-- product=new Product() assigned in ProductController
product.getProductname() =null
product.getDescription() =null, price is 0, quantity is 0, id is 0
 -->
 <!-- url is a variable
 url=/admin/saveproduct
 url="http://localhost:8080/Projectfrontendp/admin/saveproduct
  -->
 <c:url value='/admin/saveorupdateproduct' var="url"></c:url>
	<form:form method="post" modelAttribute="product"
		action="${url }">
		<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="productname">Enter Product Name</form:label>
				</td>
				<td><form:input path="productname" />
				<form:errors path="productname" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="description">Enter Product Desription</form:label>
				</td>
				<td><form:textarea path="description" />
				<form:errors path="description" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="price"> Enter price</form:label></td>
				<td><form:input path="price" />
				<form:errors path="price" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="quantity">Enter Quantity</form:label></td>
				<td><form:input path="quantity" />
				<form:errors path="quantity" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Product"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>