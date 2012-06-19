<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">

    <ui:composition template="yusubscribe.xhtml">
        <ui:define name="topnav">
            <ui:include src="topnav.xhtml" />
        </ui:define>
        <ui:define name="sidebar">
            <ui:include src="sidebar.xhtml" />
        </ui:define>
        <ui:define name="page">
            <div class="span8" background-color="#2e2e2c">
                <ui:insert name="content">
                </ui:insert>
            </div>
        </ui:define>
    </ui:composition>

</html>