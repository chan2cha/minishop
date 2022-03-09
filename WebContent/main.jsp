<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String mesg = (String)session.getAttribute("memberAdd");
	//저장한 session 불러오기
	if(mesg!=null){//회원가입 정보가 있음
%>		
<script type="text/javascript">
	alert("<%=mesg%>");
</script>
<%
	}
%>
</head>
<body>
<h1>메인 화면 입니다.</h1>
<jsp:include page="common/top.jsp"></jsp:include><br>
<jsp:include page="common/menu.jsp"></jsp:include>
</body>
</html>