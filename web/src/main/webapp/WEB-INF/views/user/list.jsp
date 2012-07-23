<%@ include file="/common/taglibs.jsp" %>
<html>
	<head>
		<title><spring:message code="user.list.title" /></title>
	</head>
	<body>
		<div class="row-fluid">
			<div class="page-header">
				<h3><spring:message code="user.list.title" /></h3>
			</div>
		</div>
		<div class="row-fluid" >
			<table class="table table-bordered">
				<thead>
					<tr>
						<th width="5%" ><spring:message code="label.no" /></th>
						<th width="55%" ><spring:message code="label.username" /></th>
						<th width="25%" ><spring:message code="label.email" /></th>
						<th width="15%" align="center"><spring:message code="label.action" /></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${users ne null}">
							<c:forEach items="${users}" var="user" varStatus="status" >
								<tr>
									<td>${status.index + 1 + no}</td>
									<td>${user.username}</td>
									<td>${user.email}</td>
									<td align="center" >
										<a href="manage?id=${user.id}"><spring:message code="label.manage" /></a> | 
										<a href="delete?id=${user.id}"><spring:message code="label.delete" /></a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4"><i><spring:message code="label.nodata" /></i></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<c:set var="rowPerPage" value="10" />
			<c:set var="paging" value="${count / rowPerPage}" />
			<c:if test="${paging > 1 }">
				<div class="btn-toolbar">
					<div class="pagination">
						<ul>
						<c:set var="start" value="0"/>
						<c:forEach begin="0" end="${paging}" varStatus="status" >
							<li class="${no eq start ? 'active' : ''}" ><a href="list?start=${start}&end=${rowPerPage}">${status.index + 1}</a></li>
							<c:set var="start" value="${start + rowPerPage}" />
						</c:forEach>								
						</ul>
					</div>
				</div>
			</c:if>
		</div>
	</body>
</html>