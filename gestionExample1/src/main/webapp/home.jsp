<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleHome.css" rel="stylesheet" id="bootstrap-css">
    <title>Home</title>
    <style>
    
    </style>
</head>

<body>
	<nav>
	  <ul>
	    <li>
	      <a href="home">Home</a>
	    </li>
	    <li class="menu-deroulant">
	      <a>Employees</a>
	      <ul class="sous-menu">
	        <li><a href="list">List employees</a></li>
	        <li><a class="popup" href="add">Add employee</a></li>
	      </ul>
	    </li>
	    <li>
	     	<a href="login" >
          		<img alt="Log Out" src="img/logout.png">
           	</a>
	    </li>
	  </ul>
	</nav>

	<c:if test="${employees!=null}">
		<center>
			<table>
		        <tr>
		        	<th>EMP_ID</th>
		        	<th>FIRST_NAME</th>
		        	<th>LAST_NAME</th>
		        	<th>START_DATE</th>
		            <th colspan="2">EDIT / DELETE</th>
		        </tr>
			    <c:forEach items="${employees }" var="emp">
			    	<tr>
			    		<td>${emp.empId}</td>
			            <td>${emp.firstName}</td>
			            <td>${emp.lastName}</td>
			            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${emp.startDate }" type="date"/></td>	
			            <td><a href="edit?id=${emp.empId}"><img alt="Edit" src="img/edit.png" class="image"></a></td>
			            <td><a href="delete?id=${emp.empId}" onclick="return confirm('Are you sure you want to delete?')"><img alt="Delete" src="img/delete.png" class="image"></a></td>
			        </tr>
				</c:forEach>
		    </table>
		</center>
	</c:if>
</body>

</html>