<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
			<th>Supplier ID</th>
				<th>Supplier name</th>
				
			</tr>
		</thead>
		<tbody>
		<!-- JSTL tag for iterating list of products -->
		<c:forEach items="${suppliersAttr}" var="p"><!-- p is referring to Product -->
			<tr>
				<td>${suppliersAttr.sid}</td><!-- p.getProductName() -->
				<td>${suppliersAttr.suppliername }</td><!-- p.getPrice() -->
			<!-- pass the value of product id to the product controller  -->
				<td>
				<a href="<c:url value='/admin/deletesupplier/${suppliersAttr.sid }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
			</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</div>


</body>
</html>