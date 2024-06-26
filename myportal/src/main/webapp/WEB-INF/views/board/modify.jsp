<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sashin92's Page</title>
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/board.css" />' />
</head>
<body>
  <div id="container">
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="wrapper">
      <div id="board" class="board-form">
        <form method="post" action="">
          <table border="1" width="640">
            <tr>
              <td colspan="2"><h3>게시판</h3></td>
            </tr>
            <tr>
              <th colspan="2">글수정</th>
            </tr>
            <tr>
              <td>제목</td>
              <td><input type="text" name="title" value=""></td>
            </tr>
            <tr>
              <td>내용</td>
              <td><textarea id="content" name="content">수정해야 할 글 내용</textarea>
              </td>
            </tr>
            <tr>
              <td colspan="2"><a href="">취소</a> <input
                type="submit" value="수정"></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>
</body>
</html>
