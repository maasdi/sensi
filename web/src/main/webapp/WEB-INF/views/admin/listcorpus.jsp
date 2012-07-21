<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="page-header">
		<h4>List Data</h4>
	</div>
</div>
<div class="row-fluid">
	<fieldset>
		<div class="pull-right">
			<a class="btn" href="formcorpus">Add New</a>
		</div>
	</fieldset>
</div>
<div class="row-fluid">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th width="5%" align="center" >No</th>
				<th width="65%" >Text</th>
				<th width="15%" >Category</th>
				<th width="15%" align="center">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listCorpuses}" varStatus="status" var="corpus">
				<tr>
					<td  align="center" >${status.index + 1 + no}</td>
					<td>${corpus.text}</td>
					<td>${corpus.category}</td>
					<td  align="center" >
						<a href="formcorpus?id=${corpus.id}">Update</a> 
						<a href="corpusdelete?id=${corpus.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set var="paging" value="${count / 8}" />
	<c:if test="${paging > 1 }">
		<div class="btn-toolbar">
			<div class="btn-group">
				<c:set var="start" value="0"/>
				<c:forEach begin="0" end="${paging}" varStatus="status" >
					<a href="listcorpus?start=${start}&end=${start + 8}" class="btn">${status.index + 1}</a>
					<c:set var="start" value="${start + 8}" />
				</c:forEach>
			</div>
		</div>
	</c:if>
</div>