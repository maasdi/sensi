<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
	<title><spring:message code="label.signup.title" /></title>
</head>
<body>
	<div id="container">
		<div class="row-fluid">
			<div class="page-header">
				<h3><spring:message code="label.signup.title" /></h3>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<form:form commandName="user" method="post" action="signup" cssClass="form-horizontal">
					<%@ include file="/common/messages.jsp" %>
					<form:hidden path="id" />
					<fieldset>
						<spring:bind path="username">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="username"><b><spring:message code="label.username" /></b></label>
								<div class="controls">
									<form:input path="username" cssClass="input-large" maxlength="50" />
									<form:errors path="username" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="password">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="password"><b><spring:message code="label.password" /></b></label>
								<div class="controls">
									<form:password path="password" showPassword="true" cssClass="input-large" maxlength="50" />
									<form:errors path="password" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="confirmPassword">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="confirmPassword"><b><spring:message
											code="label.confirmPassword" /></b></label>
								<div class="controls">
									<form:password path="confirmPassword" showPassword="true" cssClass="input-large" maxlength="50" />
									<form:errors path="confirmPassword" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="firstName">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="firstName"><b><spring:message code="label.firstName" /></b></label>
								<div class="controls">
									<form:input path="firstName" cssClass="input-large" maxlength="50" />
									<form:errors path="firstName" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="lastName">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="lastName"><b><spring:message
											code="label.lastName" /></b></label>
								<div class="controls">
									<form:input path="lastName" cssClass="input-large" maxlength="50" />
									<form:errors path="lastName" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="gender">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="gender"><b><spring:message code="label.gender" /></b></label>
								<div class="controls">
									<form:select path="gender" cssClass="input-small">
										<form:option value=""><spring:message code="label.choose" /></form:option>
										<form:option value="1"><spring:message code="label.gender.male" /></form:option>
										<form:option value="0"><spring:message code="label.gender.female" /></form:option>
									</form:select>
									<form:errors path="gender" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<spring:bind path="email">
							<div
								class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
								<label class="control-label" for="email"><b><spring:message code="label.email" /></b></label>
								<div class="controls">
									<form:input path="email" cssClass="input-large" maxlength="50" />
									<form:errors path="email" cssClass="help-inline" />
								</div>
							</div>
						</spring:bind>
						<div class="control-group">
							<div class="controls">
								<button class="btn btn-primary" type="submit">
									<b><spring:message code="label.signup.button" /></b>
								</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
		<div id="extra">
			<p>
				Already have an account ? <a href="<c:url value='/signin' />"><spring:message code="label.signin" /></a>
			</p>
		</div>
	</div>
</body>
</html>