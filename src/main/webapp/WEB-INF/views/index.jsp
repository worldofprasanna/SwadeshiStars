
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Swadesi</title>
 	<script src="<%= request.getContextPath()%>/themes/javascript/index.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://twitter.github.com/bootstrap/assets/js/bootstrap-transition.js"></script>
    <script type="text/javascript" src="http://twitter.github.com/bootstrap/assets/js/bootstrap-carousel.js"></script>   
</head>

<body>  

	
	<div class="container marketing">
	<c:if test="${fn:length(error) > 0}">
		<div class="alert alert-block">${error}</div>
	</c:if>
	<%-- <div class="featurette">	    
        <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%" class="featurette-image pull-right">
        
        <div id="myCarousel" class="carousel slide featurette-image pull-right">
        	<ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
		 	</ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%" >
                </div>
                <div class="item">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%">
                </div>
                <div class="item">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%">
                </div>
            </div>
            <!-- Carousel nav -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
  </div>
        
       <!--  <img src="<%= request.getContextPath()%>/themes/img/browser-icon-chrome.png" width="50%" height="50%" class="featurette-image pull-right"> -->
    	<div class="featurette-heading">Everything is for a cause. <span class="muted">It'll blow your mind.</span></div>
        <p class="lead">This is the place to help out the needy either by conducting activity for the children or by aiding financial support. Named the Group as Swadeshi Stars.</p>
        <a href="#signin" role="button" class="btn" data-toggle="modal">Want to Join ?</a>
      </div> --%>   
      
      
      <div id="myCarousel" class="carousel slide">
  		<ol class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		 </ol>
 
		  <div class="carousel-inner">
		    	<div class="item active">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%" />
                </div>
		   		<div class="item">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%" />
                </div>
                <div class="item">
                    <img src="<%= request.getContextPath()%>/themes/img/test_img.jpg" width="50%" height="50%" />
                </div>
		  </div>
		  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  		  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	<div class="featurette-heading">Everything is for a cause. <span class="muted">It'll blow your mind.</span></div>
        <p class="lead">This is the place to help out the needy either by conducting activity for the children or by aiding financial support. Named the Group as Swadeshi Stars.</p>
        <a href="#signin" role="button" class="btn" data-toggle="modal">Want to Join ?</a>
      </div>
      
      
     </div>
      

    <!-- Sign In -->
</body>

</html>

