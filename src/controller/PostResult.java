package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ResultDAO;

/**
 * Servlet implementation class PostResult
 */
@WebServlet("/PostResult")
public class PostResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String type = request.getParameter("examType");
		
		HttpSession hs = request.getSession();
		
		hs.setAttribute("examType", type);
		
		String owner = (String) hs.getAttribute("netId");
		
		ResultDAO dao = new ResultDAO();
		boolean bool = dao.isExist(type, owner);
		if(bool == false){
			request.setAttribute("errmsg", "No exams posted by you.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
			rd.forward(request, response);
		}else{
			ArrayList<String> list = dao.getList(type, owner);
			request.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String name = request.getParameter("name");
		String post = request.getParameter("post");
		
		HttpSession hs = request.getSession();
		String type = (String)hs.getAttribute("examType");
		String Owner = (String) hs.getAttribute("netId");
		
		if(post.isEmpty()){
			request.setAttribute("errmsg", "Please enter something in the result field.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
			rd.forward(request, response);
		}else{
			
			ResultDAO dao = new ResultDAO();
			boolean b = dao.isPosted(type, name);
			if(b == false){
				int condition = dao.postResult(type, Owner, name, post);
				if(condition == 1){
					request.setAttribute("errmsg", "Posted.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
					rd.forward(request, response);
				}
			}else{
				request.setAttribute("errmsg", "Alrady Posted.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
				rd.forward(request, response);
			}
		}
	}

}
