
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Swadesi</title>
    
    <!-- Le styles -->
    <link rel="stylesheet" href="<%= request.getContextPath()%>/themes/css/bootstrap.css" />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/themes/css/bootstrap-responsive.css"  />
    <link rel="stylesheet" href="<%= request.getContextPath()%>/themes/css/bootstrap-customized.css"  />
</head>
<body>  
<div class="navbar-wrapper">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a href="#" class="brand">Swadeshi Stars</a>
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
	<form action="signin/google" method="post">
		<input type="hidden" name="scope" value="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/drive" />
		<input type="hidden" name="redirect_uri" value="/home" />
		<button class="btn">Count Me In</button>
	</form>
	<div class="container marketing">
	<div class="featurette">
        <img src="<%= request.getContextPath()%>/themes/images/browser-icon-chrome.png" class="featurette-image pull-right">
        <h2 class="featurette-heading">Everything is for a cause. <span class="muted">It'll blow your mind.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
      </div>

      </div> <!-- /.container -->
    </div>
</body>
</html>