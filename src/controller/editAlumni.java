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
 * Servlet implementation class editAlumni
 */
@WebServlet("/editAlumni")
public class editAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAlumni() {
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
		ArrayList<String> list = dao.getPerticularAlumni(id);
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/editAlumni.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String Name = request.getParameter("Name");
		String date = request.getParameter("date");
		String info = request.getParameter("info");
		String link = request.getParameter("home");
		HttpSession hs = request.getSession();
		String Id = (String) hs.getAttribute("AlumniID");
		
		if(Name.isEmpty() || date.isEmpty() || info.isEmpty() || link.isEmpty()){
			request.setAttribute("errmsg", "Input can't be null.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostAllumni.jsp");
			rd.forward(request, response);
		}else{
			AlumniDAO dao = new AlumniDAO();
			int condition = dao.updateAlumni(Id ,Name, date, link, info);
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
	}

}
