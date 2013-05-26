
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Swadesi</title>
    
</head>

<body>  

	<form action="signin/google" method="post">
		<input type="hidden" name="scope" value="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/drive" />
		<input type="hidden" name="redirect_uri" value="/home" />
		<button class="btn pull-right">Sign In</button>
	</form>
	<div class="container marketing">
	<div class="featurette">
        <img src="<%= request.getContextPath()%>/themes/img/browser-icon-chrome.png" class="featurette-image pull-right">
        <h2 class="featurette-heading">Everything is for a cause. <span class="muted">It'll blow your mind.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
     </div>

    
</body>
</html>