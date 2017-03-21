/*
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpListDAO;
import entity.EmpListBean;

/**
 * Servlet implementation class BookManagementServlet
 *
 * @author emBex Education
 * @version 1.00
 */
@WebServlet("/emp_list")
public class EmpListServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// エンコーディング指定
		request.setCharacterEncoding("Windows-31J");
		response.setCharacterEncoding("Windows-31J");

		HttpSession session=request.getSession(true);

		// 移譲先を格納する変数
		String url = null;
		String dbPassword = null;
		ArrayList<EmpListBean> list = new ArrayList<EmpListBean>();
		EmpListDAO dao = new EmpListDAO();
		try {
			list = dao.select();
			request.setAttribute("empList", list);
			url = "emp_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			url = "error.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
