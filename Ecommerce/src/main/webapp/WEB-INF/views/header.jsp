<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online shopping</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="<c:url value='/resources/css/navbar.css'></c:url>">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse" id="nav_bar">
	<div class="container-fluid">
	<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
		<div class="navbar-header">
			<a class="navbar-brand" href="">
              <img src="<c:url value='/resources/images/welcomenew.jpg'></c:url>" alt="Ewalk" height="30px" width="60px">
            </a>
		</div>
		
		<div  class="collapse navbar-collapse" id="collapse-example">
		<ul class="nav navbar-nav" id="links">
		<li><a href="<c:url value='/home'></c:url>">Home</a></li>
		<li><a href="<c:url value='/aboutus'></c:url>">About Us</a>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="<c:url value='/admin/getproductform'></c:url>">Add Product</a></li><!-- productform -->
		</security:authorize>
		
		<li><a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a><li>
		<li class="dropdown"> 
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Select by category<span class="caret"></span></a>
			<ul class="dropdown-menu">
			<li><a href="">Mobiles</a></li>
			<li><a href="">Laptop</a></li>
			<li><a href="">Books</a></li>
			</ul>
			</li>
			
		<c:if test="${pageContext.request.userPrincipal.name ==null}"><!-- check if principal object is null -->
		<li><a href="<c:url value='/all/registrationform'></c:url>">SignUp</a></li>
		<li><a href="<c:url value='/login'></c:url>">Sign In</a></li>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name!=null }">
		<li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li>
		<li><a href="<c:url value='/cart/purchasedetails'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span>(${sessionScope.cartSize })</a></li>
		<li><a href="<c:url value='/j_spring_security_logout'></c:url>">Sign out</a></li>
		</c:if>
		</ul>
		</div>
	</div>
	</nav>

		
		
	
</body>
</html>