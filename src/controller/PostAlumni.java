package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumniDAO;

/**
 * Servlet implementation class PostAlumni
 */
@WebServlet("/PostAlumni")
public class PostAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAlumni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AlumniDAO dao = new AlumniDAO();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String Name = request.getParameter("Name");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		String link = request.getParameter("home");
		
		if(Name.isEmpty() || date.isEmpty() || info.isEmpty() || link.isEmpty()){
			request.setAttribute("errmsg", "Input can't be null.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostAllumni.jsp");
			rd.forward(request, response);
		}else{
			AlumniDAO dao = new AlumniDAO();
			int condition = dao.insertAlumni(Name, date, link, info);
			if(condition == 1){
				request.setAttribute("errmsg", "posted.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostAllumni.jsp");
				rd.forward(request, response);
			}
		}
	}

}
