/*
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import entity.LoginBean;

/**
 * Servlet implementation class BookManagementServlet
 *
 * @author emBex Education
 * @version 1.00
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// エンコーディング指定
		request.setCharacterEncoding("Windows-31J");
		response.setCharacterEncoding("Windows-31J");

		HttpSession session=request.getSession(true);

		// 移譲先を格納する変数
		String url = null;
		String dbPassword = null;
		String rqUserId = request.getParameter("userId");
		String rqPassword = request.getParameter("password");
		LoginDAO dao = new LoginDAO();
		try {
			LoginBean loginBean = new LoginBean();
			dbPassword = dao.select(loginBean.createLoginBean(request));
			if (rqPassword.equals(dbPassword)) {
				url = "menu.jsp";
				session.setAttribute("userID", rqUserId);
				session.setAttribute("password", rqPassword);
			} else {
				url = "error.jsp";
			}
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
