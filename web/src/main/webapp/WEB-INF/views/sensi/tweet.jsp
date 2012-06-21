<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="page-header">
		<h3>Timeline</h3>
	</div>
</div>
<div class="row-fluid">
	<c:choose>
		<c:when test="${tweets ne null}">
			<c:forEach items="${tweets}" var="tweet" >
				<p>${tweet.text}</p>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Tweets unavailable</p>
		</c:otherwise>
	</c:choose>
</div>