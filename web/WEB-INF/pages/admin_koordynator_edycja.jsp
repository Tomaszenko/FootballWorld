<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>
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
    <form:form modelAttribute="koordynator" method="POST" action="/admin/koordynatorzy/zmiana">
        <%--<input type="number" path="idKoordynatora" name = "id"/>--%>
        <form:input path="idKoordynatora"/>
        <%--<input type="text" path="imie" name = "imie"/>--%>
        <form:input path="imie"/>
        <%--<input type="text" path="nazwisko" name = "nazwisko"/>--%>
        <form:input path="nazwisko"/>
        <form:input path="data_urodzenia"/>
        <%--<form:input path="data_szkolenia"/>--%>
        <%--<fmt:formatDate value="${koordynator.data_urodzenia}" pattern="yyyy-MM-dd" var="${koordynator.data_urodzenia}"/>--%>
        <%--<form:input path="data_urodzenia">--%>
        <%--<form:input path="data_urodzenia" value = "<fmt:formatDate value=\"${koordynator.data_szkolenia}\" pattern=\"yyyy-MM-dd\" />" var="${koordynator.data_urodzenia}"/>--%>
        <%--<input type="text" path="data_urodzenia" class= "date" name = "dataUrodzenia" value = "<fmt:formatDate value="${koordynator.data_urodzenia}" pattern="yyyy-MM-dd" />"/>--%>
        <%--<fmt:formatDate value="${koordynator.data_urodzenia}" pattern="yyyy-MM-dd"/>"--%>
        <%--<fmt:formatDate value="${koordynator.data_szkolenia}" pattern="yyyy-MM-dd" var="${koordynator.data_szkolenia}"/>--%>
        <%--<form:input path="data_szkolenia" value = "<fmt:formatDate value=\"${koordynator.data_szkolenia}\" pattern=\"yyyy-MM-dd\" />"/>--%>
        <%--<input type="text" path="data_szkolenia" class= "date" name = "dataSzkolenia" value = "<fmt:formatDate value="${koordynator.data_szkolenia}" pattern="yyyy-MM-dd" />"/>--%>
        <form:input path="data_szkolenia"/>
        <%--<input type="number" path="nrTelefonu" name = "nrTelefonu"/>--%>
        <form:input path="nrTelefonu"/>
        <%--<input type="text" path="miasto" name = "miasto"/>--%>
        <form:input path="miasto"/>
        <%--<input type="text" path="ulica" name = "ulica"/>--%>
        <form:input path="ulica"/>
        <%--<input type="text" path="haslo" name = "haslo"/>--%>
        <form:input path="haslo"/>
        <input type="submit" value="Zatwierdź zmiany"/>
    </form:form>
</body>
</html>
