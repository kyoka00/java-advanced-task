<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="./css/commons.css" rel="stylesheet">
</head>
<body class="login_body">
  <div class="header">
    <h1 class="site_logo">商品管理システム</h1>
  </div>

  <div class="login_form">
    <img src="./images/logo.png" class="login_logo">
    <c:if test = "${not empty msg }">
    <p class="error">${msg}</p>
    </c:if>

    <form action="TaskLoginServlet" method="post">
      <fieldset>
        <div class="cp_iptxt">
          <input class="base_input" type="text" name="loginId" placeholder="ID">
          <i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i>
          	<c:if test = "${not empty msgId}">
   	 			<p class="error">${msgId}</p>
    		</c:if>
        </div>

        <div>
          <input class="base_input" type="password" name="pass" placeholder="PASS">
          <c:if test = "${not empty msgPass}">
   	 			<p class="error">${msgPass}</p>
    		</c:if>
        </div>
      </fieldset>
      <button class="logout_btn" type="submit">ログイン</button>
    </form>
  </div>
</body>
</html>
