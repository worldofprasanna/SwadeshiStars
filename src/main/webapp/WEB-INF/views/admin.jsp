<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dLabel">
    	<li>Test</li>
    	<li>Test</li>
    </ul>
	<form class="form-horizontal">
    	<div class="control-group">
    	<label class="control-label" for="inputEmail">Email</label>
    	<div class="controls">
    		<input type="text" id="inputEmail" placeholder="Email">
    	</div>
    	</div>
    	<div data-date-format="dd-mm-yyyy" data-date="12-02-2012" id="dp3" class="input-append date">
				<input type="text" readonly="" value="12-02-2012" size="16" class="span2">
				<span class="add-on"><i class="icon-calendar"></i></span>
		</div>
    	<div class="control-group">
    		<div class="controls">
    			<label class="checkbox">
    				<input type="checkbox"> Remember me
    			</label>
    		<button type="submit" class="btn">Sign in</button>
    		</div>
    	</div>
    </form>
</body>
</html>