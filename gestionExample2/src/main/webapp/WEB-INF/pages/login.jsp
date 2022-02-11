<%@page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" id="bootstrap-css">  
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>LOGIN</title>
    <style>
    
    
    </style>
</head>

<body>
<div class="sidenav">
	<div style="text-align: center;padding:5px 0;margin:0;">
		<a href="${pageContext.request.contextPath}/index?lang=en">Login (English)</a>
		&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/index?lang=fr">Login (French)</a>
	</div>
    <div class="login-main-text">
    	<h2><s:message code="label.hello"/></h2>
       <%= new Date() %>
    </div>
</div>
<div class="main">
   <div class="col-md-6 col-sm-12">
      <div class="login-form">
         <form:form action="home" method="post" modelAttribute="user">
         	<div class="form-group">
               <label><s:message code="label.userName"/></label>                
               <form:input class="form-control" path="login"/>
               <form:errors path="login"/>
            </div>
            <div class="form-group">
               <label><s:message code="label.password"/></label>
               <form:password class="form-control" path="password"/>
               <form:errors path="password"/>      
            </div>
            <button type="submit" class="btn btn-black">Login</button>
         </form:form>
      </div>
   </div>
</div>
</body>

</html>

