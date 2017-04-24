<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 25.03.2017
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      <!DOCTYPE HTML>
      <html lang="pl">
      <head>
        <meta charset="utf-8" />
        <title>Drabina Jakubowa</title>
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
          <a href="${pageContext.request.contextPath}/resources/html/index.html"><div class="option">Strona główna</div></a>
          <a href="${pageContext.request.contextPath}/resources/html/o_nas.html"><div class="option">O nas</div></a>
          <a href="${pageContext.request.contextPath}/resources/html/wolontariusze.html"><div class="option">Wolontariusze</div></a>
          <a href="${pageContext.request.contextPath}/resources/html/podopieczni.html"><div class="option">Podopieczni</div></a>
          <a href="${pageContext.request.contextPath}/resources/html/kontakt.html"><div class="option">Kontakt</div></a>
          <a href="${pageContext.request.contextPath}/resources/html/logowanie.html"><div class="option">Logowanie</div></a>
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
          <a href="index.html" style="color: black; text-decoration: none"><div class="optionL">Strona główna</div></a>
          <a href="index.html" style="color: black; text-decoration: none"><div class="optionL">O nas</div></a>
          <a href="wolontariusze.html" style="color: black; text-decoration: none"><div class="optionL">Wolontariusze</div></a>
          <a href="podopieczni.html" style="color: black; text-decoration: none"><div class="optionL">Podopieczni</div></a>
          <a href="kontakt.html" style="color: black; text-decoration: none"><div class="optionL">Kontakt</div></a>
          <div class="optionL">Logowanie</div>
        </div>

        <div id="content">
          <span class="mytitle">Witamy na stronie Drabiny Jakubowej</span>
          <div style="height: 15px;"></div>


        </div>

        <div id="footer">
          Drabina Jakubowa - wolontariat z niepełnosprawnymi. Strona w sieci od 2017r. &copy; Wszelkie prawa zastrzeżone
        </div>

      </div>
      </body>
      </html>
