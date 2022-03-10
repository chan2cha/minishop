package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 userid, passwd로 파싱
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
//	정보를 map에 저장
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
//		map에 있는 정보에 해당하는 데이터들을 dao 가 리턴
		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);
		
		String nextpage = null;
//	dto에 정보가 있다면 login이라는 값으로 session에 저장, 정보 유무에 따라 이동페이지를 다르게 설정
		if(dto!=null) {
			nextpage="main.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			session.setMaxInactiveInterval(3600);
		}
		else {
			nextpage="loginForm.jsp";
		}
		
		response.sendRedirect(nextpage);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
