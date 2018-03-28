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

import dao.AlumniDAO;

/**
 * Servlet implementation class DeleteAlumni
 */
@WebServlet("/DeleteAlumni")
public class DeleteAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAlumni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		String id = (String) hs.getAttribute("AlumniID");
		
		AlumniDAO dao = new AlumniDAO();
		int condition = dao.deleteAlumni(id);
		if(condition == 1){
			if(dao.checkAlumni()){
				ArrayList<String> list = dao.getAlumni();
				request.setAttribute("list", list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAlumni.jsp");
				rd.forward(request, response);
				
			}else{
				request.setAttribute("errmsg", "No Alumni.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAlumni.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
