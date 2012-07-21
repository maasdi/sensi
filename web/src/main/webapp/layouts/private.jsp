<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>

    <html>
        <head>
            <title>Sensi&#160;&#187;&#160;<decorator:title/></title>

            <%@ include file="/common/meta.jsp" %>

            <!-- Theme -->
            <link type="text/css" rel="stylesheet" href="<c:url value='/resources/styles/theme.css' />" />
            
            <script type="text/javascript" src="<c:url value='/resources/scripts/jquery.min.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/scripts/jquery.common.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/scripts/bootstrap.min.js' />"></script>
            <!-- Customization -->
            <script type="text/javascript" src="<c:url value='/resources/scripts/application.js' />"></script>

            <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

			<link rel="icon" href="<c:url value='/resources/images/icon/icon.gif' />" />
            <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/images/icon/icon.gif' />" />
            
            <decorator:head/>
        </head>
        <body>
        	<div class="navbar navbar-fixed-top">
     			<div class="navbar-inner">
                    <div class="container">
                        <a class="brand" href="<c:url value='/' />">Sensi</a>
                        <%@ include  file="/common/topnav.jsp" %>
                    </div>
				</div>
			</div>
            <div class="container">
            	<%@ include file="/common/sidebar.jsp" %>
            	<div class="span8" background-color="#2e2e2c">
            		<%@ include file="/common/messages.jsp" %>
            		<decorator:body/>
            	</div>
            </div>
        </body>
    </html>