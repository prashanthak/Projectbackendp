<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
<div>
<a href="<c:url value="/cart/clearcart"></c:url>" class="btn btn-danger" pull-left  >
<span class="glyphicon glypicon-remove-sign"></span>
Clear Cart
</a>
<table class="table table-striped">
<thead id="thead">
<tr><th>ProductName</th><th>Quantity</th><th>Total Price</th><th>Remove</th>
</tr>
</thead>
<c:set var="totalPrice" value="0"></c:set>
<tbody id="tbody"><!-- cartItems is List<CartItem>, cartItem is CartItem obj -->
<c:forEach items="${cartItems}" var="cartItem">
<tr>
<td>${cartItem.product.name }</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.totalPrice }</td>
<c:set var="totalPrice" value="${totalPrice + cartItem.totalPrice }"></c:set>

<td><a href="<c:url value='/cart/deletecartitem/${cartItem.itemId }'></c:url>" class="label label-danger" pull-left>

<span class="glyphicon glyphicon-remove" ></span>Remove
</a></td>

</tr>
<hr>
</c:forEach>
</tbody>
</table>
Total Price : ${totalPrice }
</div>

<a href="<c:url value='/cart/shippingaddress'/>" class="btn btn-success pull-right">
<span class="glyphicon glyphicon-shopping-cart"></span> Place Order  </a>


</div>
</body>
</html>