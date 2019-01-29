<%@ page import="main.Excercises_web_app.JEE.User" %><%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 12.01.19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <p>Hey, Hi, hello</p>
    <fmt:formatNumber value="${kwota}" type="currency" minFractionDigits="2" maxFractionDigits="2"  />
    <fmt:formatDate value="${data}" type="both" dateStyle="short" timeStyle="long" />
  </body>
</html>