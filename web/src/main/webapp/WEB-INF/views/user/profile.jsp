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
				<li class="active">
					<a href="profile"><spring:message code="label.information"/></a>
				</li>
				<li>
					<a href="account"><spring:message code="label.account" /></a>
				</li>
			</ul>
			<form:form commandName="user" action="profile" method="post" >
				<fieldset>
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
								<label class="control-label" for="lastName"><b><spring:message code="label.lastName" /></b></label>
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
									<b><spring:message code="profile.save.button" /></b>
								</button>
							</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</body>
</html>