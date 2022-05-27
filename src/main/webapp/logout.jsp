<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="2;URL=index.jsp">
<title>ログアウト</title>
<link href="css/commons.css" rel="stylesheet">
<%

	session.invalidate();
	String msg = "ログアウトしました";
%>
</head>
<body>
  <div class="header">
    <h1 class="site_logo">商品管理システム</h1>
  </div>
  <div class="center">
    <p>
     <%= msg %><br> ※２秒後にTOP画面に遷移します。
    </p>
  </div>
</body>
</html>