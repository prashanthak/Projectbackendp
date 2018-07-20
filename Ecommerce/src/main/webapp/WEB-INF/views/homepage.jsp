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
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
  <h2 style="background-color:tomato;"><i>Ewayhome</h2></i>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="3" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="4" class="active"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="<c:url value='/resources/images/cell1.jpg'></c:url>" alt="welcome" style="width:50%;">
      </div>

<div class="item">
        <img src="<c:url value='/resources/images/cell2.jpg'></c:url>" alt="welcome" style="width:50%;">
      </div>
      
      <div class="item">
        <img src="<c:url value='/resources/images/cell3.jpg'></c:url>" alt="welcome" style="width:50%;">
      </div>
      
      <div class="item">
        <img src="<c:url value='/resources/images/cell4.jpg'></c:url>" alt="apple-laptop" style="width:50%;">
      </div>
    
      <div class="item">
        <img src="<c:url value='/resources/images/lap1.jpg'></c:url>" alt="mobile 1" style="width:50%;">
      </div>
      
     
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div class="container">
<h2 style="background-color:tomato;"><i>Hurry Great Grand Discount</h2></i> 
<div class="row">
<c:forEach items="${productsAttr}" var="p">
<div class="col-md-4" width="200" height="300">
<img  width="200" height="300" src="<c:url value='/resources/images/${p.id}.png'></c:url>" />
<p>Name: ${p.name}</p>
<p>Price: ${p.price}</p>
<p><input type="button" value="Add to Cart"/></p>
<p><input type="button" value="Buy Now"/></p>
</div>
</c:forEach>
</div>


</div>

</body>
</html>