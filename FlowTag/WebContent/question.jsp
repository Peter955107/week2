<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set target="${pageContext.request}" property="characterEncoding" value="UTF-8"/>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Questionnaire</title>
    </head>
    <body>
        <form action="question.jsp" method="post">
            <c:choose>
                <c:when test="${param.page == null}">
                    問題一：<input type="text" name="p1q1"><br>
                    問題二：<input type="text" name="p1q2"><br>
                    <input type="submit" name="page" value="page2">
                </c:when>
                <c:when test="${param.page == 'page2'}">
                    <c:set var="p1q1" value="${param.p1q1}" scope="session"/>
                    <c:set var="p1q2" value="${param.p1q2}" scope="session"/>
                    問題三：<input type="text" name="p2q1"><br>
                    <input type="submit" name="page" value="finish">
                </c:when>
                <c:when test="${param.page == 'finish'}">
                    ${sessionScope.p1q1}<br>
                    ${sessionScope.p1q2}<br>
                    ${param.p2q1}<br>
                </c:when>
            </c:choose>
        </form>
    </body>
</html> 