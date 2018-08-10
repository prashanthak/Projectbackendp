<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/registration.css'></c:url>">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<c:url value="/all/register" var="url"></c:url>

<p style="color:red;">${error}</p>

<form:form modelAttribute="customer" action="${url}" id="form" method="post">

<form:hidden path="id"/>

<form:label path="firstname">Enter Firstname</form:label>
<form:input path="firstname" id="firstname"/>


<form:label path="lastname">Enter Lastname</form:label>
<form:input path="lastname" id="lastname"/>


<form:label path="phonenumber">Enter Phonenumber</form:label>
<form:input path="phonenumber" id="phonenumber"/>

<hr>
<h2 style="background-color:tomato;"><b>Login Credentials</b></h2><br>
<form:label path="user.email">Enter Email</form:label>
<form:input path="user.email" id="user.email" type="email"/>
<br><br>
<form:label path="user.password">Enter password</form:label>
<form:input path="user.password" id="user.password" type="password"/>

<hr>
<br><br>
<h2 style="background-color:tomato;"><b>Billing Address</b></h2><br><br>

<form:label path="billingaddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="billingaddress.apartmentnumber" id="billingaddress.apartmentnumber"/>
<br>
<br>
<form:label path="billingaddress.streetname">Enter streetname</form:label>
<form:input path="billingaddress.streetname" id="billingaddress.streetname"/>
<br>
<br>
<form:label path="billingaddress.city">Enter city</form:label>
<form:input path="billingaddress.city" id="billingaddress.city"/>
<br>
<br>
<form:label path="billingaddress.state">Enter state</form:label>
<form:input path="billingaddress.state" id="billingaddress.state"/>
<br>
<br>
<form:label path="billingaddress.country">Enter country</form:label>
<form:input path="billingaddress.country" id="billingaddress.country"/>
<br>
<br>
<form:label path="billingaddress.zipcode">Enter Zipcode</form:label>
<form:input path="billingaddress.zipcode" id="billingaddress.zipcode"/>
<hr>
<br>
<br>
<h2 style="background-color:tomato;"><b>Shipping address</b></h2><br><br>

<form:label path="shippingaddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="shippingaddress.apartmentnumber" id="shippingaddress.apartmentnumber"/>
<br>
<br>
<form:label path="shippingaddress.streetname">Enter streetname</form:label>
<form:input path="shippingaddress.streetname" id="streetname"/>
<br>
<br>
<form:label path="shippingaddress.city">Enter city</form:label>
<form:input path="shippingaddress.city" id="shippingaddress.city"/>
<br>
<br>
<form:label path="shippingaddress.state">Enter state</form:label>
<form:input path="shippingaddress.state" id="shippingaddress.state"/>
<br>
<br>
<form:label path="shippingaddress.country">Enter country</form:label>
<form:input path="shippingaddress.country" id="shippingaddress.country"/>
<br>
<br>
<form:label path="shippingaddress.zipcode">Enter zipcode</form:label>
<form:input path="shippingaddress.zipcode" id="shippingaddress.zipcode"/>
<br>
<br>
<input type="submit" value="Register">

</form:form>
</div>
</body>
</html>