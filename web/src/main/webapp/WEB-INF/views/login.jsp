<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:common="http://java.sun.com/jsf/composite/common" >
    
    <ui:composition template="/WEB-INF/view/templates/public.xhtml">
        <ui:define name="page">
            <div id="login-container">
                <div id="login-header">
                    <h3>Sign In</h3>
                </div>
                <div id="login-content" class="clearfix" >
                    <h:form id="login" >
                        <common:messages />
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label" for="username">#{message['label.username']}</label>
                                <div class="controls">
                                    <h:inputText id="username" value="#{login.username}" required="true" requiredMessage="#{message['required.username']}" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="password">#{message['label.password']}</label>
                                <div class="controls">
                                    <h:inputSecret id="password" value="#{login.password}" required="true" requiredMessage="#{message['required.password']}" />
                                </div>
                            </div>
                        </fieldset>
                        <div id="remember-me" class="pull-left" >
                            <input id="remember" type="checkbox" name="remember" />
                                <label id="remember-id" for="remember">Remember Me</label>
                        </div>
                        <div class="pull-right">
                        	<h:commandButton styleClass="btn" style="height: 35px; width: 70px;" value="Sign In" action="#{login.login}" />
                        </div>
                    </h:form>
                </div>
                <div id="login-extra">
                    <p>
                        Don't have an account ? <a href="javascript:void()">Sign Up</a>
                    </p>
                    <p>
                        Forgot password ? <a href="#">Retrieve</a>
                    </p>
                </div>
            </div> <!-- /container -->
        </ui:define>
    </ui:composition>

</html>