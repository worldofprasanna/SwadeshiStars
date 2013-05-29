<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<!--Sidebar content-->
				<div class="row">
					<div class="span3 bs-docs-sidebar">
						<ul class="nav nav-list bs-docs-sidenav affix">
							<li class="active"><a href="#appreciation" id="appreciations"><i
									class="icon-chevron-right"></i> Appreciations</a></li>
							<li><a href="#account" id="accounts"><i class="icon-chevron-right"></i>
									Accounts</a></li>
							<li><a href="#activities" id="activities"><i class="icon-chevron-right"></i>
									Activities</a></li>
							<li><a href="#sendmail" id="sendmail"><i class="icon-chevron-right"></i>
									Send Mail</a></li>		
						</ul>
					</div>
				</div>
			</div>
			<div class="span10">
			
				<!--Body content-->
				<p class="text-success">${message}</p>
				<div class="span10 actioncomponent" id="appreciationform">
				<legend>Create an Appreciation</legend>
				<form:form name="appreciation" action="createappreciation" modelAttribute="Appreciation">		
					<fieldset>						
						<label>Appreciation Text</label>	
						<textarea name="appreciationText" rows="5" class="span12"></textarea>
						<label>Date</label>
						<input type="date" placeholder="DD/MON/YYYY" name="createdDate">
						<span class="help-block"></span>
						<button type="submit" class="btn">Create</button>
					</fieldset>
				</form:form>
				</div>
				
				
				<!-- Accounts -->
				<div class="span10 hide actioncomponent" id="accountsform">
				<legend>Create Account Details for current month</legend>
				<form:form name="account" action="createaccount">		
					<fieldset>
							<table class="table table-striped">
								<caption>Members List</caption>
								<thead>
									<tr>
										<th>FirstName</th>
										<th>LastName</th>
										<th>Is Contributing ?</th>
										<th>Amount</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="user">
									<tr>																			
										<td><input type="hidden" name="userName" value="${user.userName}" />
											<span class="input uneditable-input">${user.firstName}</span>
										</td>
										<td><span class="input uneditable-input">${user.lastName}</span></td>
										<td>
											<label class="checkbox">
												<input type="checkbox" name="isContributing">
											</label>
										</td>
										<td><input type="text" name="amount"></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="form-actions">
    							<button type="submit" class="btn btn-primary">Update</button>
    							<button type="button" class="btn">Cancel</button>
    						</div>							
					</fieldset>
				</form:form>
				</div>
				
				
				<!-- Accounts -->
				<div class="span10 hide actioncomponent" id="activitiesform">
				<legend>Create an Activity</legend>
				<form:form name="appreciation" action="createappreciation" modelAttribute="Appreciation">		
					<fieldset>						
						<label>Appreciation Text</label>	
						<textarea name="appreciationText" rows="5" class="span12"></textarea>
						<label>Date</label>
						<input type="text" placeholder="DD/MON/YYYY" name="createdDate">
						<span class="help-block"></span>
						<button type="submit" class="btn">Create</button>
					</fieldset>
				</form:form>
				</div>
				
				<!-- Send Mail -->
				<div class="span10 hide actioncomponent" id="sendmailform">
				<legend>Send Mail to Group</legend>
				<form:form name="sendmail" action="sendmail">		
					<fieldset>						
						<label>Body Content</label>	
						<textarea name="bodyContent" rows="5" class="span12"></textarea>
						<label>Subject</label>
						<input type="text" placeholder="Subject for the Mail" name="subject">
						<span class="help-block"></span>
						<button type="submit" class="btn">Send Mail</button>
					</fieldset>
				</form:form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>