<%--
  Created by IntelliJ IDEA.
  User: xzh
  Date: 2021/6/28
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/upload1" enctype="multipart/form-data" method="post">
      <input type="file" name="file"/>
      <input type="submit" value="upload"/>
    </form>
  </body>
</html>
