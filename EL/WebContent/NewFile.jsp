<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="util" uri="https://cc.openhome/util"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>自訂EL函式</title>
    </head>
    <body>
        ${ util:length(requestScope.someList) }
    </body>
</html>