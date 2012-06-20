<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="page-header">
		<h4>Form</h4>
	</div>
</div>
<div class="row-fluid">
	<div class="span12">
		<form:form commandName="corpus" method="post" action="submitcorpus" cssClass="form-horizontal" >
			<form:errors path="*" cssClass="error" element="div"/>
			<form:hidden path="id"/>
			<fieldset>
				<div class="control-group">
                      <label class="control-label" for="controlText" >Text</label>
                      <div class="controls">
                      	<form:errors path="text" cssClass="fieldError"/>
                      	<form:input path="text" cssClass="input-xlarge" cssErrorClass="text medium error" maxlength="255" />
                      </div>
                </div>
                <div class="control-group" >
                	<label class="control-label" for="controlText" >Category <i>ex: Positive</i></label>
                	<div class="controls">
                      	<form:errors path="category" cssClass="fieldError"/>
                      	<form:input path="category" cssClass="input-medium" cssErrorClass="text medium error" maxlength="255" />
                      </div>
                </div>
                <div class="form-actions">
                	<button class="btn btn-primary" type="submit">Submit</button>
                    <a href="listcorpus" class="btn">Cancel</a>
                </div>
			</fieldset>
		</form:form>
	</div>
</div>