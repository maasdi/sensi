<!DOCTYPE html>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <html>

        <head>
            <title>Sensi&#160;&#187;&#160;<tiles:insertAttribute name="title" ignore="true" /></title>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta http-equiv="Cache-Control" content="no-cache" />
            <meta http-equiv="Cache-Control" content="must-revalidate" />
            <meta http-equiv="Pragma" content="no-cache" />
            <meta http-equiv="Expires" content="Mon, 1 Aug 1999 10:00:00 GMT" />

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
        </head>
        <body>
        	<div class="navbar navbar-fixed-top">
     			<div class="navbar-inner">
                    <div class="container">
                        <a class="brand" href="<c:url value='/' />">Sensi</a>
                        <tiles:insertAttribute name="topnav" />
                    </div>
				</div>
			</div>
            <div class="container">
            	<tiles:insertAttribute name="sidebar" />
            	<div class="span8" background-color="#2e2e2c">
            			<tiles:insertAttribute name="content" ignore="false" />
            	</div>
            </div>
        </body>
    </html>