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
<div class="container">
<c:url value="/cart/createorder" var="url"></c:url>

<p style="color:red;">${error}</p>

<form:form modelAttribute="shippingaddress" action="${url}" id="form" method="post">

<form:hidden path="id"/>






<h2 style="background-color:tomato;"><b>Shipping address</b></h2><br><br>

<form:label path="apartmentnumber">  Enter Apartmentnumber</form:label>
<form:input path="apartmentnumber" id="apartmentnumber"/>
<br>
<br>

<form:label path="streetname">Enter streetname</form:label>
<form:input path="streetname" id="streetname"/>
<br>
<br>

<form:label path="city">Enter city</form:label>
<form:input path="city" id="city"/>
<br>
<br>

<form:label path="state">Enter state</form:label>
<form:input path="state" id="state"/>
<br>
<br>

<form:label path="country">Enter country</form:label>
<form:input path="country" id="country"/>
<br>
<br>

<form:label path="zipcode">Enter zipcode</form:label>
<form:input path="zipcode" id="zipcode"/>
<br>
<br>

<input type="submit" value="SELECT">

</form:form>
</body>
</html>