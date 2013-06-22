<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SwadeshiStars</title>
<%-- <script src="<%= request.getContextPath()%>/themes/javascript/home.js"
	type="text/javascript"></script> --%>
</head>

<body>
	<div class="alert alert-success">Welcome ${username} !</div>
	<c:if test="${not empty message }">
		<div class="alert alert-failure">${message}</div>
	</c:if>
	<div class="container-fluid">
		<div class="row-fluid">
			<!--Sidebar content-->
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list" id="main-tabs">
						<li class="active"><a href="activities.htm" id="activities">Activities</a></li>
						<li><a href="appreciation.htm?page.size=2"
							id="appreciation">Appreciation</a></li>
						<li><a href="accounts.htm" id="account">Accounts</a></li>
						<li><a href="users.htm?page.sort=firstName" id="user">Members</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<!--Body content-->
				<!-- Appreciation -->
				
				
				
		
