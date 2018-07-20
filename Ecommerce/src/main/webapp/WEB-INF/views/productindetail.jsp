 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- productAttr - Product object -->
	<!-- model attribute which holds the data is "productAttr" -->
	<div class="container">
		<div class="panel panel-info">
			<div class="panel panel-heading">Product Details</div>
			<div class="panel panel-body">
			<b>Product Name:</b> ${productAttr.name }  <br>
			<b>Product Description</b> ${productAttr.description } <br>
			<b>Price </b> ${productAttr.price }  <br>
			<b>Quantity </b>${productAttr.quantity }  <br>
			</div>
		</div>
	</div>
	<a href="<c:url value='/all/getallproducts'></c:url>">Back to previous page</a>
</body>
</html> 