<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="page-header">
		<h4>Result</h4>
	</div>
</div>
<c:forEach items="${list}" var="result" >
	<p>${result.text} -> ${result.category} (${result.score})</p>
</c:forEach>