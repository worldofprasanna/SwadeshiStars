<%@ include file="basehomepage.jsp"%>

<div class="span9 actioncomponent" id="userslist">
	<h2 class="">Members</h2>
	<hr />
	<div class="row-fluid">
	<c:set var="first" value="${page.size * page.number}"></c:set>
		

		<table class="table table-striped">
			<thead>
				<tr>
					<th>S No</th>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.content}" var="user"
				varStatus="status">
					<tr>
						<td>${first + status.count}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		Current Page : ${page.number + 1}
		<c:url value="" var="next">
			<c:param name="page.page" value="${page.number + 2}"></c:param>
			<c:param name="page.size" value="${page.size}"></c:param>
			<c:param name="page.sort" value="firstName"></c:param>
		</c:url>
		<a href="${next}">Next</a>
	</div>
</div>

</div>
</div>
</div>
</body>
</html>