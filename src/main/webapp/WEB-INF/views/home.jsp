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
	<div class="container">
	    <div class="alert alert-success">Welcome ${username}</div>		
			<div class="row">
				<div class="span3 bs-docs-sidebar">
					<ul class="nav nav-list bs-docs-sidenav affix">
						<li class="active"><a href="#activities"><i
								class="icon-chevron-right"></i> Activities</a></li>
						<li><a href="#account"><i class="icon-chevron-right"></i>
								Accounts</a></li>
						<li><a href="#members"><i class="icon-chevron-right"></i>
								Members</a></li>
					</ul>
				</div>
				
			</div>
			<div class="hero-unit">
				<h1>Appreciations</h1>
				<c:forEach items="${appreciations }" var="appreciation">
					<p><c:out value="${appreciation}"></c:out></p>			
				</c:forEach>
			</div>
			</div>						
</body>
</html>