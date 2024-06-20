<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>Hello World!!!!!!</h1>
  <h2>This is My PORTAL</h2>
  <c:if test="${ not empty param.name }">
    <p>이름은 ${ param.name } 이시군요.</p>
  </c:if>
  

</body>
</html>