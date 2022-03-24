package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LoginServlet 에서 저장한 session 값을 이용
		
		HttpSession session = request.getSession();
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		
		String nextpage = null;
				if(dto!=null) {
					nextpage = "mypage.jsp";
			
					// dto 에서 userid 를 가져와서 회원정보를 불러오는 mypage함수 호출 후
					//새로운  dto 변수 에 저장하여 session 에 저장
					
					String userid = dto.getUserid();
					MemberService service = new MemberService();
					MemberDTO x = service.mypage(userid);
					
					
					session.setAttribute("login", x);
					
					
					
				} else {
					
					nextpage="loginForm.jsp";
					session.setAttribute("mesg", "로그인이 필요한 작업입니다.");				
				}
				
				RequestDispatcher dis = request.getRequestDispatcher(nextpage);
				dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
