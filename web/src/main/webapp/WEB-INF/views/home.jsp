<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row-fluid">
	<div class="page-header">
		<h3>Text Mining</h3>
	</div>
</div>
<div class="row-fluid">
	<form action="<c:url value='/classify' />" method="post" >
		<fieldset>
			<div class="control-group">
				<label class="control-label" for="text" ><b>Text to Classify : </b></label>
				<input type="text" class="input-xlarge" name="text" /> 
			</div>
			<div class="form-actions" >
				<button class="btn btn-primary" type="submit">Classify</button>
			</div>
		</fieldset>
	</form>
</div>
<c:if test="${result ne null}">
	<div class="row-fluid">
		<p>Classify Result :</p>
		<p>Text : ${result.text}</p>
		<p>Category : ${result.category} </p>
		<p>Score : ${result.score} </p>
	</div>
</c:if>
<c:if test="${corpus_error ne null}">
	<div class="row-fluid">
		<p>${corpus_error}</p>
	</div>
</c:if>