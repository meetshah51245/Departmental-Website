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
 * Servlet implementation class ViewResult
 */
@WebServlet("/ViewResult")
public class ViewResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String type = request.getParameter("examType");
		
		HttpSession hs = request.getSession();
		
		hs.setAttribute("examType", type);
	
		ResultDAO dao = new ResultDAO();
		boolean bool = dao.isExist1(type);
		if(bool == false){
			request.setAttribute("errmsg", "No exams posted for selected type.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewResult.jsp");
			rd.forward(request, response);
		}else{
			ArrayList<String> list = dao.getNames(type);
			request.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewResult.jsp");
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
		HttpSession hs = request.getSession();
		String type = (String)hs.getAttribute("examType");
		
		hs.setAttribute("examName", name);
		
		ResultDAO dao = new ResultDAO();
		boolean bool = dao.isPosted(type, name);
		if(bool == true){
			ArrayList<String> list = dao.getResult(type, name);
			request.setAttribute("resultArray", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewResult.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("errmsg", "Not Posted yet.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostResult.jsp");
			rd.forward(request, response);
		}
		
	}

}
