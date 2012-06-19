<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">

    <ui:composition template="template.xhtml" >
        <ui:param name="sitename" value="YuSubscribe"/>

        <ui:define name="head">
            <link rel="icon" href="#{resource['images/icon/icon.gif']}" />
            <link rel="shortcut icon" type="image/x-icon" href="#{resource['images/icon/icon.gif']}" />
        </ui:define>

        <ui:define name="topbar">
            <div class="navbar navbar-fixed-top">
                    <div class="navbar-inner">
                        <div class="container">
                            <ui:insert name="topnav-brand">
                                <a class="brand" href="#">YuSubscribe</a>
                            </ui:insert>
                            <ui:insert name="topnav"></ui:insert>
                        </div>
                    </div>
                </div>
        </ui:define>

        <ui:define name="container">
            <ui:insert name="sidebar"></ui:insert>
            <ui:insert name="page"></ui:insert>
        </ui:define>

    </ui:composition>
</html>