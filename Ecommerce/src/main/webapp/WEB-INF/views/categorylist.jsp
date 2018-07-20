<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- List of Categories, categoriessAttr is the name of the model attribute -->
	<div class="container">
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
			<th>Category ID</th>
				<th>Category name</th>
				
			</tr>
		</thead>
		<tbody>
		<!-- JSTL tag for iterating list of categories -->
		<c:forEach items="${categoriesAttr}" var="c"><!-- p is referring to Category -->
			<tr>
				<td>${c.cid}</td><!-- p.getCategoryName() -->
				<td>${c.categoryname}</td><!-- p.getPrice() -->
			<!-- pass the value of category id to the category controller  -->
				<td><a href="<c:url value='/all/getcategory/${c.cid }'></c:url>">
				<span class="glyphicon glyphicon-info-sign"></span></a>
				<a href="<c:url value='/admin/deletecategory/${c.cid }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
			</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
  </div>

</body>
</html>