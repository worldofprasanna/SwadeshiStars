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
		
		<c:url value="" var="next">
			<c:param name="page.page" value="${page.number + 2}"></c:param>
			<c:param name="page.size" value="${page.size}"></c:param>
			<c:param name="page.sort" value="firstName"></c:param>
		</c:url>
		<c:url value="" var="prev">
			<c:param name="page.page" value="${page.number - 1}"></c:param>
			<c:param name="page.size" value="${page.size}"></c:param>
			<c:param name="page.sort" value="firstName"></c:param>
		</c:url>

		<div class="well well-small">
			Current Page : <span class="badge">${page.number + 1}</span>
			Total Pages : <span class="badge badge-inverse">${page.totalPages}</span> 
			<span class="pull-right"> <c:if test="${page.number gt 0 }">
					<a href="${prev}">Prev</a>
				</c:if> <c:if test="${(page.number+1) lt page.totalPages}">
					<a href="${next}">Next</a>
				</c:if>
			</span>
		</div>





		<%-- <c:out value="page number :${page.number}"></c:out>
		<c:out value="total :${page.totalPages}"></c:out> --%>
	</div>
</div>

</div>
</div>
</div>
</body>
</html>