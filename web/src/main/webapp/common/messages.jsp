<%-- Error Messages --%>
<c:if test="${not empty errors}">
    <div class="alert alert-error" id="errors">
    	<button class="close" data-dismiss="alert" type="button" >×</button>
        <c:forEach var="error" items="${errors}">
            <c:out value="${error}"/><br />
        </c:forEach>
    </div>
    <c:remove var="errors" scope="session" />
</c:if>

<%-- Success Messages --%>
<c:if test="${not empty messages}">
    <div class="alert alert-success" id="messages">
    	<button class="close" data-dismiss="alert" type="button" >×</button>
        <c:forEach var="msg" items="${messages}">
            <c:out value="${msg}"/><br />
        </c:forEach>
    </div>
    <c:remove var="messages" scope="session"/>
</c:if>