<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row-fluid">
	<div class="page-header">
		<h3>Text Mining</h3>
	</div>
</div>
<div class="row-fluid">
	<form method="post" action="savedata" >
		<fieldset>
			<div class="control-group">
				<label class="control-label" for="controlText"><b>Text to Classify : </b></label>
				<div class="controls">
					<input type="text" name="text" class="input-xlarge" maxlength="255" />
				</div>
			</div>
			<div class="form-actions">
				<button class="btn btn-primary" type="submit">Add</button>
				<a href="cleardata" class="btn">Clear</a>
			</div>
		</fieldset>
	</form>
</div>
<div class="row-fluid">
	<c:if test="${list ne null}">
		<form action="doclassify" method="post">
			<button class="btn btn-primary" type="submit">Classify Now !</button>
		</form>
	</c:if>
	<table class="table table-unbordered">
		<tbody>
			<c:forEach items="${list}" varStatus="status" var="string">
				<tr>
					<td>${status.index + 1}. ${string}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>