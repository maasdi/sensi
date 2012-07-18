<%@ include file="/common/taglibs.jsp" %>
<html>
	<head>
		<title><spring:message code="label.signin" /></title>
	</head>
	<body>
		<div id="login-container">
		<div id="login-header">
			<h3><spring:message code="label.signin" /></h3>
		</div>
		<div id="login-content" class="clearfix">
			<form id="signinForm" action="<c:url value='/signin/authenticate' />" method="post" >
				<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message ne null}">
					<div class="error">
						Your login attempt was not successful, try again.<br /> Caused :
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="j_username"><spring:message code="label.username" /></label>
						<div class="controls">
							<input type="text" name="j_username" autocomplete="off" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="j_password"><spring:message code="label.password" /></label>
						<div class="controls">
							<input type="password" name="j_password" />
						</div>
					</div>
				</fieldset>
				<div id="remember-me" class="pull-left">
					<input id="remember" type="checkbox" name="remember" /> <label
						id="remember-id" for="remember"><spring:message code="label.rememberme" /></label>
				</div>
				<div class="pull-right">
					<input class="btn" style="height: 32px; width: 64px;" type="submit" value="<spring:message code="label.signin" />" />
				</div>
			</form>
		</div>
		<div id="login-extra">
			<p>
				Don't have an account ? <a href="<c:url value='/signup' />"><spring:message code="label.signup.title" /></a>
			</p>
			<p>
				Forgot password ? <a href="#">Retrieve</a>
			</p>
		</div>
	</div>
	</body>
</html>