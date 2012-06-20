<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="nav-collapse">
	<ul class="nav pull-left">
		<li class="active"><a href="#"> <span class="new-wrapper">
					<i class="icon-home icon-white"></i>
			</span> <b>Dashboard</b>
		</a></li>
		<li><a href="#"> <span class="new-wrapper"> <i
					class="icon-signal icon-white"></i>
			</span> <b>Stats</b>
		</a></li>
	</ul>
	<div class="pull-right">
		<form class="navbar-search">
			<input class="search-query span2" type="text" placeholder="Search" />
			<div class="icon-search icon-white"></div>
		</form>
		<ul class="nav">
			<li class="divider-vertical"></li>
			<li>
				<a class="dropdown-toggle" href="#" data-toggle="dropdown">
					<span class="new-wrapper"> 
						<img class="avatar size28" src="<c:url value='/resources/images/avatar.jpg' />" alt="" />
					</span>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li class="current-user"><a
						class="account-summary account-summary-small" href="#">
							<div class="content">
								<div class="account-group account-group-inner">
									<img class="avatar size32"
										src="<c:url value='/resources/images/avatar.jpg' />"
										alt="" /> <b class="fullname">Maaz Yagami</b> <small
										class="metadata">View my profile page</small>
								</div>
							</div>
					</a></li>
					<li class="dropdown-divider"></li>
					<li><a data-nav="settings" href="#">Settings</a></li>
					<li><a href="<c:url value="/j_spring_security_logout" />">Log Out</a></li>
				</ul></li>
		</ul>
	</div>
</div>