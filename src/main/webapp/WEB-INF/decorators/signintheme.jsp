<%@ include file="basetheme.jsp" %>
	<div id="signin" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="signinlabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="signinlabel">Sign In Options</h3>
		</div>
		<div class="modal-body">
			<form action="signin/google" method="post">
				<input type="hidden" name="scope"
					value="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/drive" />
				<input type="hidden" name="redirect_uri" value="/home" />
				<button class="btn btn-large btn-block">Sign In with Google</button>
			</form>
			<form action="signin/facebook" method="post">
				<input type="hidden" name="scope"
					value="publish_stream,user_photos,offline_access" />
				<input type="hidden" name="redirect_uri" value="/home" />
				<button class="btn btn-large btn-block">Sign In with Facebook</button>
			</form>
			<form action="signin/twitter" method="post">
				<input type="hidden" name="scope"
					value="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www.googleapis.com/auth/drive" />
				<input type="hidden" name="redirect_uri" value="/home" />
				<button class="btn btn-large btn-block">Sign In with Twitter</button>
			</form>
		</div>
		<div class="modal-footer">
			<p>Thanks for Signing In.</p>
		</div>
	</div>
