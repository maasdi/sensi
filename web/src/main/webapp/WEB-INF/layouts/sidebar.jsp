<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets">

    <ui:composition>
        <!-- sidebar -->
        <div class="span2 sidebar">
            <ul>
                <li class="active">
                    <figure>
                        <a href="templates.html">
                            <i class="icon-home"></i>Dashboard
                        </a>
                    </figure>
                </li>
                <hr/>
                <li class="">
                    <figure>
                        <a href="application.html">
                            <i class="icon-pencil"></i>Applications
                        </a>
                    </figure>
                </li>
                <li class="">
                    <figure>
                        <a href="messages.html">
                            <i class="icon-envelope"></i>Messages
                        </a>
                    </figure>
                </li>
                <li class="dropper">
                    <figure>
                        <i class="icon-circle-arrow-right"></i>DropDown &nbsp;&rsaquo;
                    </figure>
                    <ul class="subDrop">
                        <li>
                            <a href="#">
                                <i class="icon-plus"></i>List Item
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-plus"></i>List Item
                            </a>
                        </li>
                    </ul>
                </li>
                <hr/>
                <li>
                    <figure>
                        <a href="#">
                            <i class="icon-user"></i>Profile
                        </a>
                    </figure>
                </li>
                <li>
                    <figure>
                        <a href="#">
                            <i class="icon-cog"></i>Settings
                        </a>
                    </figure>
                </li>
                <hr/>
                <li>
                    <figure>
                        <a href="#">
                            <i class="icon-flag"></i>Help
                        </a>
                    </figure>
                </li>
            </ul>
        </div>
        <!-- end sidebar -->
    </ui:composition>

</html>