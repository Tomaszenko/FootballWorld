<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 15.04.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="koordynator">
        <form:input path="imie" value="${koordynator.imie}"/>
        <form:input path="nazwisko" value="${koordynator.nazwisko}"/>
        <form:input path="data_urodzenia" value="${koordynator.data_urodzenia}"/>
        <form:input path="data_szkolenia" value="${koordynator.data_szkolenia}"/>
        <form:input path="telefon" value="${koordynator.nrTelefonu}"/>
        <form:input path="miasto" value="${koordynator.miasto}"/>
        <form:input path="ulica" value="${koordynator.ulica}"/>
        <form:input path="haslo" value="${koordynator.haslo}"/>
    </form:form>
</body>
</html>
