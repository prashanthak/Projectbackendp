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

  <c:url value='/admin/saveorupdateproduct' var="url"></c:url>
  <form:form method="post" modelAttribute="product" action="${url}?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
  <table>
  <tr>
  <td><form:label path="id">Enter Product ID</form:label>
  </td>
  <td><form:input path="id"/></td>
  </tr>
  
  <td><form:label path="name">Enter Product Name</form:label>
  </td>
  <td><form:input path="name"/>
  <form:errors path="name" cssStyle="color:red"></form:errors>
  </td>
  <tr>
  <tr>
  <td><form:label path="description">Enter Product Description</form:label>
  </td>
  
  <td><form:textarea path="description"/>
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
				<form:errors path="quantity" cssStyle="color:red"></form:errors></td>
			</tr>
			
			<tr>
	<td><form:label path="supplier.suppliername" >Supplier</form:label></td>
	<td><form:select path="supplier.suppliername" cssClass="form-control" items="${suppliers}" itemLabel="suppliername" itemValue="suppliername"></form:select></td>
	</tr>
	<tr>
	<td><form:label path="category.categoryname">Category</form:label></td>
	<td><form:select path="category.categoryname" cssClass="form-control" items="${categories}" itemLabel="categoryname" itemValue="categoryname"></form:select></td>
      </tr>
			
			<tr>
			<td>
Select File:</td>
<td><form:input type="file" path="pimage"/><br/> </td>
</tr> 

			<%-- <tr>
			<td><form:label path="pimage">Upload Product Image</form:label></td>
			<td><form:input type="file"  path="pimage" required="true"/> </td>
			</tr>
			<tr> --%>
				<td><input type="submit" value="Add Product"/></td>
			</tr>
		</table>
	
	</form:form>
</body>
</html>