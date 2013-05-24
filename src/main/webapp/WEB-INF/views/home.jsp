<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SwadeshiStars</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="navbar-wrapper">
	<div class="container">
	<div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->            
            <a href="<%= request.getContextPath() %>" class="brand">Swadeshi Stars</a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>                            
              </ul>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
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
				<h1>Activities</h1>
				<p>This gives the list of activities done for this month.</p>
				<p>
			</div>
			</div>
			
		
	</div>
</body>
</html>