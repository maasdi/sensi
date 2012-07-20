<%@ include file="/common/taglibs.jsp" %>
<html>
	<head>
		<title><spring:message code="label.forgotPassword.title" /></title>
	</head>
	<body>
		<div class="row-fluid">
			<div class="page-header">
				<h3>
					<spring:message code="label.forgotPassword.title" />
					<small>&nbsp;( <b><spring:message code="label.or" /> <a href="<c:url value='/signin' />"><spring:message code="label.signin" /></a> </b>)</small>
				</h3>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<form:form commandName="forgotPassword" method="post" action="forgot_password" >
					<fieldset>
						<spring:bind path="email">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="username"><b><spring:message code="label.forgotPassword.email" /></b></label>
								<div class="controls">
									<form:input path="email" cssClass="input-large" maxlength="50" />
									<form:errors path="email" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<div class="control-group">
							<div class="controls">
								<button class="btn btn-primary" type="submit">
									<b><spring:message code="label.forgotPassword.button" /></b>
								</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</body>
</html>