package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// common/menu.jsp 의 gCategory 파싱
		String gCategory = request.getParameter("gCategory");
		
			if(gCategory==null) {
			gCategory = "top";
			}
		
			// gCategory로 GoodsDTO의 리스트 불러오
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.goodsList(gCategory);
		
		// goodsList 에 list 를 저장
		request.setAttribute("goodsList", list);
		
		
		// main 으로 이동 
		RequestDispatcher dis = request.getRequestDispatcher("main");
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
