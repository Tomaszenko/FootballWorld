<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title>Drabina Jakubowa-logowanie</title>
    <meta name="description" content="To jest strona projektowa aplikacji na zajęcia TAB"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formStyle.css">
    <link href="https://fonts.googleapis.com/css?family=Satisfy" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
</head>

<body>
<div id="container">

    <div id="logo">
        Drabina Jakubowa
    </div>

    <div id="menu">
        <a href='<c:url value="/"/>'><div class="option">Strona główna</div></a>
        <a href='<c:url value="/o_nas"/>'><div class="option">O nas</div></a>
        <a href='<c:url value="/wolontariusze"/>'><div class="option">Wolontariusze</div></a>
        <a href='<c:url value="/podopieczni"/>'><div class="option">Podopieczni</div></a>
        <a href='<c:url value="/kontakt"/>'><div class="option">Kontakt</div></a>
        <a href='<c:url value="/logowanie"/>'><div class="option">Logowanie</div></a>
        <div style="clear:both;"></div>
    </div>

    <div id="topbar">
        <div id="topbarL">
            <img src="${pageContext.request.contextPath}/resources/img/ladder.png" />
        </div>
        <div id="topbarR">
            <span class="bigtitle">O "Drabinie" słów kilka</span>
            <div style="height: 10px;"></div>
            Drabina Jakubowa to duszpasterstwo podopiecznych niepełnosprawnych i wolontariuszy zajmujące się organizacją rekolekcji, opieki, rehabilitacji oraz pomocy charytatywnej osobom niepełnosprawnym.
        </div>

        <div style="clear:both;"></div>
    </div>

    <div id="sidebar">
        <a href='<c:url value="/"/>' style="color: black; text-decoration: none"><div class="optionL">Strona główna</div></a>
        <a href='<c:url value="/o_nas"/>' style="color: black; text-decoration: none"><div class="optionL">O nas</div></a>
        <a href='<c:url value="/wolontariusze"/>' style="color: black; text-decoration: none"><div class="optionL">Wolontariusze</div></a>
        <a href='<c:url value="/podopieczni"/>' style="color: black; text-decoration: none"><div class="optionL">Podopieczni</div></a>
        <a href='<c:url value="/kontakt"/>' style="color: black; text-decoration: none"><div class="optionL">Kontakt</div></a>
        <a href='<c:url value="/logowanie"/>' style="color: black; text-decoration: none"><div class="optionL">Logowanie</div></a>
    </div>

    <div id="content">
        <form:form method="POST" action="/koordynator/autoryzacja">
            <span class="mytitle">Koordynator</span>
            <div style="height: 30px;"></div>
            <label for="login">Login</label>
            <input type="text" id="login" name="nazwa">
            <br/><br/>
            <label for="password">Hasło</label>
            <input type="password" id="password" name="haslo">
            <input type="submit" value="Zaloguj się">
        </form:form>
        <%--<div style="height: 50px;"></div>--%>
        <%--<span class="podtitle">Koordynator</span>--%>
        <%--<div style="height: 30px;"></div>--%>
        <%--<label for="login">Login</label>--%>
        <%--<input type="text" id="login" name="nazwa">--%>
        <%--<br /><br />--%>
        <%--<label for="password">Hasło</label>--%>
        <%--<input type="password" id="password" name="haslo">--%>
        <%--<br /><br />--%>
        <%--<input type="submit" value="Zaloguj się">--%>
    </div>
        <%--<div style="height: 50px;"></div>--%>
        <%--<span class="podtitle">Pielęgniarka</span>--%>
        <%--<div style="height: 30px;"></div>--%>
        <%--<label for="login">Login</label>--%>
        <%--<input type="text" id="login" name="nazwa">--%>
        <%--<br /><br />--%>
        <%--<label for="password">Hasło</label>--%>
        <%--<input type="password" id="password" name="haslo">--%>
        <%--<br /><br />--%>
        <%--<input type="submit" value="Zaloguj się">--%>



    <div id="footer">
        Drabina Jakubowa - wolontariat z niepełnosprawnymi. Strona w sieci od 2017r. &copy; Wszelkie prawa zastrzeżone
    </div>

</div>
</body>
</html>