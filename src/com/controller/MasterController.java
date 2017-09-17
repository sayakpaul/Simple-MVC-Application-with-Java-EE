package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ProductBean;
import com.service.Service;

/**
 * Servlet implementation class MasterController
 */
@WebServlet("/MasterController")
public class MasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("sdjfhsdkfhsdkfhkj");
		RequestDispatcher rd = null;
		Service s = new Service();
		String action = request.getParameter("action");
		//System.out.println(action);
		if(action.equals("firstPage"))
		{
			String s1 = request.getParameter("n1");
			//System.out.println(s1);
			if(s1.equals("Invalid"))
			{
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			else if(s1.equals("Active"))
			{
				ArrayList<ProductBean> pb =  s.viewItems("Active");
				if(pb!=null){
					request.setAttribute("AcList", pb);
					request.setAttribute("booga","Active");
					rd = request.getRequestDispatcher("view.jsp");
					rd.forward(request, response);
				}
			}
			else if(s1.equals("Inactive"))
			{
				ArrayList<ProductBean> pb =  s.viewItems("Inactive");
				if(pb!=null){
					request.setAttribute("AcList", pb);
					request.setAttribute("booga","Inactive");
					rd = request.getRequestDispatcher("view.jsp");
					rd.forward(request, response);
				}
			}
			else if(s1.equals("New"))
			{
				ArrayList<ProductBean> pb =  s.viewItems("New");
				if(pb!=null){
					request.setAttribute("AcList", pb);
					rd = request.getRequestDispatcher("delete.jsp");
					rd.forward(request, response);
				}
			}
		}
		else if(action.equals("viewing"))
		{
			int s1 = Integer.parseInt(request.getParameter("id"));
			ProductBean t = s.getProduct(s1);
			request.setAttribute("id", t);
			rd = request.getRequestDispatcher("item.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("errorPage"))
		{
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("deleting"))
		{
			int s1 = Integer.parseInt(request.getParameter("id"));
			boolean t = s.delProduct(s1);
			if(t){
			rd = request.getRequestDispatcher("confirm.jsp");
			rd.forward(request, response);
			}
			else
			{
				rd = request.getRequestDispatcher("noconfirm.jsp");
				rd.forward(request, response);
			}
		}


	}

}
