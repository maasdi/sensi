<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- sidebar -->
<div class="span2 sidebar">
	<ul>
		<li class="active" >
			<figure>
				<a href="<c:url value='/' />"> <i class="icon-home"></i>Home
				</a>
			</figure>
		</li>
		<li>
			<figure>
				<a href="<c:url value='/listdata' />"> <i class="icon-folder-close"></i>Group
				</a>
			</figure>
		</li>
		<li>
			<figure>
				<a href="<c:url value='/sensi/tweet' />"> <i class="icon-tweet"></i>Tweet
				</a>
			</figure>
		</li>
		<security:authorize ifAllGranted="ROLE_ADMIN">
			<li class="dropper">
			<figure>
				<i class="icon-circle-arrow-right"></i>Corpus &nbsp;&rsaquo;
			</figure>
			<ul class="subDrop">
				<li><a href="<c:url value='/admin/listcorpus' />"> <i
						class="icon-plus"></i>List Corpus
				</a></li>
				<li><a href="<c:url value='/admin/formcorpus' />"> <i
						class="icon-plus"></i>Add New
				</a></li>
			</ul>
		</li>
		<hr />
		</security:authorize>
		
		<li>
			<figure>
				<a href="<c:url value='/user' />"> <i class="icon-user"></i>Profile
				</a>
			</figure>
		</li>
		<li>
			<figure>
				<a href="<c:url value='/setting' />"> <i class="icon-cog"></i>Settings
				</a>
			</figure>
		</li>
		<hr />
		<li>
			<figure>
				<a href="<c:url value='/help' />"> <i class="icon-flag"></i>Help
				</a>
			</figure>
		</li>
	</ul>
</div>
<!-- end sidebar -->