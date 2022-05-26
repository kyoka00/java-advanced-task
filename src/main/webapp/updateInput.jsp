<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<link href="css/commons.css" rel="stylesheet">
<style type= "text/ javascript">
          	window.sessionStorage.getItem(['']);
</style>
</head>
<body>
  <div class="header">
    <h1 class="site_logo"><a href="AllShowServlet">商品管理システム</a></h1>
    <div class="user">
      <p class="user_name">${userInfo.getName()}さん、こんにちは</p>
      <form class="logout_form" action="logout.jsp" method="get">
        <button class="logout_btn" type="submit">
          <img src="images/ドアアイコン.png">ログアウト</button>
      </form>
    </div>
  </div>

  <hr>

  <div class="insert">
    <div class="form_body">
     <c:if test = "${not empty msg }">
    	<p class="error">${updateMsg}</p>
    </c:if>
      
	
      <form action="UpdateServlet" method="get">
        <fieldset class="label-130">
          <div>
            <label>商品ID</label>
            <input type="text" name="productId" value="${chosenProduct.getProductId()}" class="base-text">
            
            <c:if test = "${not empty msg }">
    			<span class="error">${nullErrorId}</span>
   			 </c:if>
          </div>
          <div>
            <label>商品名</label>
            <input type="text" name="productName" value="${chosenProduct.getName()}" class="base-text">
            
            <c:if test = "${not empty msg }">
    			<p class="error">${nullErrorName}</p>
    		</c:if>
          </div>
          <div>
            <label>単価</label>
            <input type="text" name="price" value="${chosenProduct.getPrice()}" class="base-text">
            <c:if test = "${not empty msg }">
    			<span class="error">${nullErrorPrice}</span>
    		</c:if>
          </div>
          <div>
            <label>カテゴリ</label> <select name="category" class="base-text" >
            
             <c:forEach var= "c" items="${categoriesList}" varStatus = "status">
             	<option value="${c.getId()}" <c:if test="${c.getId() == chosenProduct.getCategoryId()}">selected</c:if>>${c.getName()}</option>
             </c:forEach>
             
            </select>
          </div>
          
          <div>
            <label>商品説明</label>
            <textarea name="description" class="base-text">
				${chosenProduct.getDescription()}
            </textarea>
          </div>
          <div>
            <label>画像</label>
            <input type="file" name="file">
            <span class="error"></span>
          </div>
        </fieldset>
          <div class="btns">
            <button type="button" onclick="openModal()" class="basic_btn">更新</button>
            <input type="button" onclick="location.href='./AllShowServlet'" value="メニューに戻る" class="cancel_btn">
          </div>
          <div id="modal">
            <p class="modal_message">更新しますか？</p>
            <div class="btns">
              <button type="submit" class="basic_btn">更新</button>
              <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
            </div>
          </div>
      </form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
<script src="./js/commons.js"></script>
</html>