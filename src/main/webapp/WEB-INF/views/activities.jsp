<%@ include file="basehomepage.jsp"%>

<div class="span9 actioncomponent" id="activitylist">
	<h2 class="">Activities</h2>
	<hr />
	<div class="row-fluid">
		<c:set var="first" value="${page.size * page.number}"></c:set>
		<c:forEach items="${page.content}" var="appreciation"
			varStatus="status">
			<div class="well ">
				<p class="pull-right">
					<fmt:formatDate pattern="MMM, yyyy" value="${appreciation.created}" />
				</p>
				<h3>Title for Appreciation</h3>
				<p>
					<c:out
						value="${fn:substring(appreciation.appreciationText, 0, 100)}"></c:out>
				</p>
				<p>
					<a class="btn" href="#">more ...</a>
				</p>
			</div>
		</c:forEach>
		Current Page : ${page.number + 1}
		<c:url value="" var="next">
			<c:param name="page.page" value="${page.number + 2}"></c:param>
			<c:param name="page.size" value="${page.size}"></c:param>
			<c:param name="page.sort" value="created"></c:param>
		</c:url>
		<a href="${next}">Next</a>
	</div>
</div>

</div>
</div>
</div>
</body>
</html>