<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

<p>${loginerror}</p>
<p>${logoutmsg}</p>
<form action="<c:url value='/j_spring_security_check'></c:url>" method="post">
<table>
<tr>
    <td>Enter Email</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
         <td>Enter Password</td>
         <td><input type="password" name="password"></td>
         </tr>
         <tr>
         <td><input type="submit" value="submit"></td>
         </tr>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

</form>
</body>
</html> --%>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign in</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<%@ include file="header.jsp" %>
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 col-sm-4 col-xs-12">
			
				<form class= "form-container" action="j_spring_security_check" method="post">
					<h2>Sign In</h2>
					<a href="signup">New to this site? Sign Up</a><br>
					
						
				
						<div class="form-group">
							<label for="exampleInputEmail1"><b>Username / Email id</b></label> 
							<input style="color:black" class="form-control" id="exampleInputEmail1" type="text" placeholder="Enter Email" name="j_username" required><br>
				
							<label for="exampleInputPassword1"><b>Password</b></label> 
							<input style="color:black" class="form-control" id="exampleInputPassword1" type="password" placeholder="Enter Password" name="j_password" required><br><br>
						
							<div class="clearfix">
								<button type="submit" class="block1 btn">Sign In</button><br>
								<button type="reset" class="block2 btn">Cancel</button>		
							</div>	
						
						</div>
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				</form>
			
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>





