<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="auth" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    
    <%@ include file="includes.jsp"%>
    <decorator:head />
</head>
<body>
<div class="navbar-wrapper">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
           
            <a href="<%= request.getContextPath()%>" class="brand">Swadeshi Stars</a>
           
            <div class="nav-collapse collapse">
              <ul class="nav" id="main-tabs">
                <li class="active"><a href="home">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>    
                <auth:authorize ifAnyGranted="ROLE_ADMIN">
                	<li><a href="admin">Admin</a></li>
                </auth:authorize>                        
              </ul>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
        
        <decorator:body />
        
  	</div> <!-- /.container -->
 </div>	
</body>
</html>