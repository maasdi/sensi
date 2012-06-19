<f:view xmlns:f="http://java.sun.com/jsf/core"
        xmlns:h="http://java.sun.com/jsf/html"
        xmlns:ui="http://java.sun.com/jsf/facelets">

    <h:outputText value='&lt;!DOCTYPE html&gt;' escape="false" />

    <html lang="en" xmlns="http://www.w3.org/1999/xhtml">

        <h:head>
            <title>${sitename}&#160;&#187;&#160;${title}</title>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta http-equiv="Cache-Control" content="no-cache" />
            <meta http-equiv="Cache-Control" content="must-revalidate" />
            <meta http-equiv="Pragma" content="no-cache" />
            <meta http-equiv="Expires" content="Mon, 1 Aug 1999 10:00:00 GMT" />

            <!-- Theme -->
            <link type="text/css" rel="stylesheet" href="#{request.contextPath}/resources/themes/theme.css" />
            
            <script type="text/javascript" src="#{request.contextPath}/resources/script/jquery.min.js"></script>
            <script type="text/javascript" src="#{request.contextPath}/resources/script/bootstrap.min.js"></script>
            <!-- Customization -->
            <script type="text/javascript" src="#{request.contextPath}/resources/script/application.js"></script>

            <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

            <ui:insert name="head"></ui:insert>
        </h:head>
        <h:body>
            <ui:insert name="topbar">
            </ui:insert>
            <div class="container">
                <ui:insert name="container">
                </ui:insert>
            </div>
        </h:body>
    </html>

</f:view>