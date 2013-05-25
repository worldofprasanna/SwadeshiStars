<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SwadeshiStars</title>

</head>

<body>
	<div class="alert alert-success">Welcome ${username}</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<!--Sidebar content-->
				<div class="row">
				<div class="span3 bs-docs-sidebar">
					<ul class="nav nav-list bs-docs-sidenav affix">
						<li class="active"><a href="#appreciation"><i
								class="icon-chevron-right" id="appreciation"></i>Appreciation</a></li>
						<li><a href="#account" id="account"><i class="icon-chevron-right"></i>Accounts</a></li>
						<li><a href="#members" id="user"><i class="icon-chevron-right"></i>Members</a></li>
					</ul>
				</div>				
			</div>
			</div>
			<div class="span10">
				<!--Body content-->
				<!-- Appreciation -->
				
				<div class="hero-unit actioncomponent" id="appreciationlist">
					<h3>Appreciations</h3>
					<c:forEach items="${appreciations}" var="appreciation">
						<p>
							<c:out value="${appreciation.appreciationText}"></c:out>
						</p>
						<p>
							<c:out value="${appreciation.created}"></c:out>
						</p>
					</c:forEach>
				</div>
				
				<!-- Members -->
				<div class="hero-unit hide actioncomponent" id="memberlist">
					<h3>Members</h3>
					<c:forEach items="${users}" var="user">
						<p>
							<c:out value="${user}"></c:out>
						</p>
					</c:forEach>
				</div>
				
			</div>
		</div>
	</div>
						
</body>
</html>