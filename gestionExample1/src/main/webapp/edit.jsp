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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/styleForm.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Edit</title>
    <style>
    
    </style>
</head>

<body>
	<div class="bandeau">
		<a>Edit</a>
	</div>
	<div class="form">
	<form action="edit?id=${emp.empId}" method="post">
		<div class="form-group">
	       <label>First Name</label>
	       <input type="text" class="form-control" placeholder="First Name" name="firstName" value="${emp.firstName}">
	    </div>
	    <div class="form-group">
	       <label>Last Name</label>
	       <input type="text" class="form-control" placeholder="Last Name" name="lastName" value="${emp.lastName}">
	    </div>
	    <div class="form-group">
	       <label>Start Date</label>
	       <input type="date" class="form-control" placeholder="Start Date" name="startDate" 
	       value="<fmt:formatDate pattern='yyyy-MM-dd' value='${emp.startDate }' type='date'/>">
	    </div>
	    <button type="submit" class="btn btn-black">
	    	Confirm
	    </button>
    </form>
    </div>
</body>

</html>