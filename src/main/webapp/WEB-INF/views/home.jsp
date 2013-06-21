<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SwadeshiStars</title>
<script src="<%= request.getContextPath()%>/themes/javascript/home.js" type="text/javascript"></script>
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
						<li class="active"><a href="#appreciation" id="appreciation">Appreciation</a></li>
						<li><a href="#account" id="account">Accounts</a></li>
						<li><a href="#members" id="user">Members</a></li>
					</ul>
				</div>
			</div>		
		<div class="span9">
				<!--Body content-->
				<!-- Appreciation -->
				<div class="span9 actioncomponent" id="appreciationlist">
					<h2 class="">Appreciations</h2>
					<hr />
					<div class="row-fluid">
						<c:forEach items="${appreciations}" var="appreciation"
							varStatus="status">
							<div class="well ">
								<h3>
									<fmt:formatDate pattern="MMM, yyyy"
										value="${appreciation.created}" />
								</h3>
								<p>
									<c:out
										value="${fn:substring(appreciation.appreciationText, 0, 100)}"></c:out>
								</p>
								<p>
									<a class="btn" href="#">more ...</a>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="span10 hide actioncomponent" id="memberlist">
					<h2 class="">Members</h2>
					<hr />
					<!-- Members -->
					<div class="row-fluid">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>S No</th>
									<th>First Name</th>
									<th>Last Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user" varStatus="sno">
									<tr>
										<td>${sno.count}</td>
										<td>${user.firstName}</td>
										<td>${user.lastName}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
						
</body>
</html>