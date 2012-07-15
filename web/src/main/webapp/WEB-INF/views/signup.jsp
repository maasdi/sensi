<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="title" value="Create an Account" />
<div id="container">
	<div class="row-fluid">
		<div class="page-header">
			<h3>Create an Account</h3>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form:form commandName="user" method="post" action="signup" cssClass="form-horizontal">
				<form:hidden path="id" />
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username"><b>Username</b></label>
						<div class="controls">
							<form:input path="username" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="username" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password"><b>Password</b></label>
						<div class="controls">
							<form:password path="password" showPassword="true" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="password" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="confirmPassword"><b>Confirm Password</b></label>
						<div class="controls">
							<form:password path="confirmPassword" showPassword="true" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="confirmPassword" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="firstName"><b>First Name</b></label>
						<div class="controls">
							<form:input path="firstName" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="firstName" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="firstName"><b>Last Name</b></label>
						<div class="controls">
							<form:input path="lastName" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="lastName" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="gender"><b>Gender</b></label>
						<div class="controls">
							<form:select path="gender" cssClass="input-small" >
								<form:option value="1" >Male</form:option>
								<form:option value="0">Female</form:option>
							</form:select>
							<form:errors path="gender" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="firstName"><b>Email</b></label>
						<div class="controls">
							<form:input path="email" cssClass="input-large" cssErrorClass="text medium error" maxlength="50" />
							<form:errors path="email" cssClass="fieldError" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button class="btn btn-primary" type="submit"><b>Create Account</b></button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>