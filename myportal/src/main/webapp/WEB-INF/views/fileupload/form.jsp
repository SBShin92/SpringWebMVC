<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link type="text/css" rel="stylesheet"
  href='<c:url value="/css/home.css" />' />
<title>sashin92's Page</title>
</head>
<body>
  <div id="container">
    <c:import url="/WEB-INF/views/includes/header.jsp">
      <c:param name="param1" value="value1" />
      <c:param name="param2" value="value2" />
    </c:import>

    <jsp:include page="/WEB-INF/views/includes/navigation.jsp" />

    <div id="content">

      <h1>업로드 양식</h1>


      <form action="<c:url value='/fileupload/upload' />"
        method="post"
        enctype="multipart/form-data">
        <label for="file">File</label>
        <input type="file" name="file1" /><br/><br/>
        <input type="text" name="text1" id="" /><br/><br/>
        <input type="submit" value="제출" />
      </form>
    </div>
  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
  </div>
</body>
</html>
