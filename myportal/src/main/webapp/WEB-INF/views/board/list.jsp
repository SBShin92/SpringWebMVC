<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>sashin92's Page</title>
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/board.css" />' />
  <script src="<c:url value = '/javascript/board.js' />"></script>
</head>
<body>
  <div id="container">
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="content">
      <div id="board"  class="board-form">

        <table border="1" width="640" class="tbl-ex">
          <tr>
            <td colspan="6"><h3>게시판</h3></td>
          </tr>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>조회수</th>
            <th>작성일</th>
            <th>&nbsp;</th>
          </tr>
          
          <c:forEach items="${ boardList }" var="vo" varStatus="status">
            
            <tr>
              <td>${ vo.no }</td>
              <td><a href="<c:url value='/board/view' />/${ vo.no }">${ vo.title }</a></td>
              <td>${ vo.userName }</td>
              <td>${ vo.hit }</td>
              <td>${ vo.regDate }</td>
              <td><a href="<c:url value='/board/delete' />/${ vo.no }" class="del-button">삭제</a></td>
            </tr>
          
          </c:forEach>
          
          <tr>
            <td colspan="6"><a href="<c:url value='/board/write' />">글쓰기</a></td>
          </tr>
        </table>
      </div>
    </div>
    <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>
</body>
</html>
