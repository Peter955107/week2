<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="html" tagdir="/WEB-INF/tags" %>
<html:Html title="新增書籤">
    <html:Errors/>
    <form method="post" action="add">
        網址&nbsp;http:// <input name="url" value="${param.url}"><br>
        網頁名稱：<input name="title" value="${param.title}"><br>
        分　　類：<input type="text" name="category" value="${param.category}"><br>
        <input value="送出" type="submit"><br>
    </form>
</html:Html> 