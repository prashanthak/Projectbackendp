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
<!-- product=new Product()assigned in ProductController
product.getProductname()=null
product.getDescription()=null,price is 0,quantity is 0,id is 0
 -->
 <!-- url is a variable
 url=/admin/saveproduct
 url="http://localhost:8080/Projectfrontendp/admin/saveproduct
  -->
  <c:url value='/admin/saveorupdatepayment' var="url"></c:url>
  <form:form method="post" modelAttribute="payment" action="${url}" >
  <table>
  <tr>
  <td><form:label path="Streetaddrs">Enter street address</form:label>
  </td>
  <td>
<form:input path="Streetaddrs" />

				<form:errors path="Streetaddrs" cssStyle="color:red"></form:errors>
				</td>
				</tr>
				<tr>
  <td><form:label path="city"/>Enter city</td>
  <td>
 <form:input path="city" />
				<form:errors path="city" cssStyle="color:red"></form:errors>
				</td>
  </tr>
  <tr>
  <td><form:label path="zip"> enter pincode</form:label>
  </td>
  <td>
  <form:input path="zip" />
				<form:errors path="zip" cssStyle="color:red"></form:errors>
				</td>
				</tr>
				<tr>
	<td><form:label path="payemail"> Enter email</form:label></td>			
  <td><form:input path="payemail"/>
  <form:errors path="payemail" cssStyle="color:red"></form:errors>
  </td>
  </tr>
  <tr>
  
  
  <td><form:label path="payfnam"> Enter Firstname</form:label></td>
				<td><form:input path="payfnam" />
				<form:errors path="payfnam" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="paylname">Enter Lastname</form:label></td>
				<td><form:input path="paylname" />
				<form:errors path="paylname" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="paycardno">Enter cardno</form:label></td>
				<td><form:input path="paycardno" />
				<form:errors path="paycardno" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="cvv">Enter cvv</form:label></td>
				<td><form:input path="cvv" />
				<form:errors path="cvv" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="cardexpirydate">expiry date</form:label></td>
				<td><form:input path="cardexpirydate" />
				<form:errors path="cardexpirydate"  cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
			<td>

				<td><input type="submit" value="Pay"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>