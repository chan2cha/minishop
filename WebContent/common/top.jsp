<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.dto.MemberDTO" %>
    <!-- top -->
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");
	if(dto!=null){
%>	<a href="LogoutServlet">로그아웃</a>
	<a href="">장바구니</a>
	<a href="MyPageServlet">mypage</a>
<% 
} else { %>
<a href="loginForm.jsp">로그인</a>
<a href="memberForm.jsp">회원가입</a>
<%
} 
%>