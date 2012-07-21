<%@ include file="/common/taglibs.jsp" %>
<html>
	<head>
		<title><spring:message code="profile.title" /></title>
	</head>
	<body>
		<div class="row-fluid">
			<div class="page-header">
				<h3><spring:message code="profile.title" /></h3>
			</div>
		</div>
		<div class="row-fluid">
			<ul class="nav nav-pills" >
				<li>
					<a href="profile"><spring:message code="label.information"/></a>
				</li>
				<li class="active">
					<a href="account"><spring:message code="label.account" /></a>
				</li>
			</ul>
			<form:form commandName="user" action="account" method="post" >
				<fieldset>
					<spring:bind path="password">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="password"><b><spring:message code="label.password" /></b></label>
								<div class="controls">
									<form:password  path="password" showPassword="true" cssClass="input-large" maxlength="50" />
									<form:errors path="password" cssClass="help-inline" />
								</div>
							</div>
					</spring:bind>
					<spring:bind path="confirmPassword">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="password"><b><spring:message code="label.confirmPassword" /></b></label>
								<div class="controls">
									<form:password path="confirmPassword" showPassword="true" cssClass="input-large" maxlength="50" />
									<form:errors path="confirmPassword" cssClass="help-inline" />
								</div>
							</div>
					</spring:bind>
					<div class="control-group">
							<div class="controls">
								<button class="btn btn-primary" type="submit">
									<b><spring:message code="account.save.button" /></b>
								</button>
							</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</body>
</html>