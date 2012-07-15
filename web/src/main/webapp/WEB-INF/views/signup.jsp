<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="container">
	<div class="row-fluid">
		<div class="page-header">
			<h3>Sign Up</h3>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<form:form commandName="user" method="post" action="signup"
				cssClass="form-horizontal">
				<form:errors path="*" cssClass="error" element="div" />
				<form:hidden path="id" />
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username">Username : </label>
						<div class="controls">
							<form:errors path="username" cssClass="fieldError" />
							<form:input path="username" cssClass="input-medium"
								cssErrorClass="text medium error" maxlength="50" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password : </label>
						<div class="controls">
							<form:errors path="password" cssClass="fieldError" />
							<form:password path="password" cssClass="input-medium"
								cssErrorClass="text medium error" maxlength="50" />
						</div>
					</div>
					<div class="form-actions">
						<button class="btn btn-primary" type="submit">Submit</button>
						<button class="btn" type="reset">Reset</button>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>