<%@tag description="顯示錯誤訊息的標籤" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${requestScope.errors != null}">
    <ul style="color: rgb(255, 0, 0);">
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if> 