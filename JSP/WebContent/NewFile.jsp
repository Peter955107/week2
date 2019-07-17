<%@page import="java.time.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Page 指示元素</title>
    </head>
    <body>
    <% response.setIntHeader("Refresh", 1); %>
        <h1>現在時間: <%= LocalDate.now() %>  <%= LocalTime.now().withNano(0) %> </h1>
    </body>
</html>