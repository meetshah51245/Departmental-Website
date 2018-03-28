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
 * Servlet implementation class editResult
 */
@WebServlet("/EditResult")
public class EditResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		String owner = request.getParameter("owner");
		String result = request.getParameter("post");
		HttpSession hs = request.getSession();
		String examType = (String) hs.getAttribute("examType");
		String examName = (String) hs.getAttribute("examName");
		
		ResultDAO dao = new ResultDAO();
		int condition = dao.updateResult(owner, examType, examName, result);
		if(condition == 1){
			ArrayList<String> list = dao.getResult(examType, examName);
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
