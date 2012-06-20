<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="login-container">
	<div id="login-header">
		<h3>Sign In</h3>
	</div>
	<div id="login-content" class="clearfix">
		<form id="loginForm" action="<c:url value='/j_security_check' />" method="post" >
			<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message ne null}">
				<div class="error">
					Your login attempt was not successful, try again.<br /> Caused :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="j_username">Username</label>
					<div class="controls">
						<input type="text" name="j_username" autocomplete="off" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="j_password">Password</label>
					<div class="controls">
						<input type="password" name="j_password" />
					</div>
				</div>
			</fieldset>
			<div id="remember-me" class="pull-left">
				<input id="remember" type="checkbox" name="remember" /> <label
					id="remember-id" for="remember">Remember Me</label>
			</div>
			<div class="pull-right">
				<input class="btn" style="height: 32px; width: 64px;" type="submit" value="Sign In" />
			</div>
		</form>
	</div>
	<div id="login-extra">
		<p>
			Don't have an account ? <a href="javascript:void()">Sign Up</a>
		</p>
		<p>
			Forgot password ? <a href="#">Retrieve</a>
		</p>
	</div>
</div>
<!-- /container -->
