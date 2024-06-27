<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Home: Join Form</title>
    <link rel="stylesheet"href='<c:url value="/css/users.css" />' />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="join-form">
        <h1>Join Form</h1>
        
        <c:if test="${ not empty requestScope.errorMsg }">
          <p style="color:red; font-weight:bold;">${ requestScope.errorMsg }</p>
        </c:if>
        <form method="POST" action="<c:url value='/users/join' />">
          <label for="name">이름</label> <input type="text" name="name" /><br />
          <label for="password">암호</label>
          <input type="password" name="password" /><br />
          <label for="email">이메일</label>
          <input type="text" name="email" />
          <input type="button" id="check-email" data-target="<c:url value = '/users/checkEmail' />" value = "이메일 중복확인" />
          <input type="hidden" name="emailCheck" value="none" />
          <br />
          <label for="gender">성별</label>
          <input type="radio" name="gender" value="M" checked />남성
          <input type="radio" name="gender" value="F" />여성
          <label for="agree">약관동의</label>
          <input type="checkbox" name="agree" id="agree" value="none" />
          
          <input type="submit" value="Sign up" />
        </form>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
    <script type="text/javascript" src="<c:url value = '/javascript/users.js' />" ></script>
  </body>
</html>
