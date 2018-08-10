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
<!-- category=new Category()assigned in CategoryController
category.getCategoryname()=null

 -->
 <!-- url is a variable
 url=/admin/savecategory
 url="http://localhost:8086/Projectfrontendp/admin/savecategory
  -->
  <c:url value='/admin/saveorupdatecategory' var="url"></c:url>
  <form:form method="post" modelAttribute="category" action="${url}">
  <table>
  <tr>
  <td><form:label path="cid">Enter Category ID</form:label>
  </td>
  <td><form:input path="cid"/></td>
  </tr>
  <td><form:label path="categoryname">Enter Category Name</form:label>
  </td>
  <td><form:input path="categoryname"/>
  <form:errors path="categoryname" cssStyle="color:red"></form:errors>
  </td>
  
  
				<td><input type="submit" value="Add Category"></td>
			</tr>
		</table>
	</form:form>

</body>
</body>
</html>