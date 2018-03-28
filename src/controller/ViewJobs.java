package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnnouncementDAO;

/**
 * Servlet implementation class ViewJobs
 */
@WebServlet("/ViewJobs")
public class ViewJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewJobs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AnnouncementDAO dao = new AnnouncementDAO();
		ArrayList<String> list = dao.getJobs();
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewJobs.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String id = request.getParameter("postId");
		AnnouncementDAO dao = new AnnouncementDAO();
		int condition = dao.deleteAnnouncement(id);
		if(condition == 1){
			if(dao.checkJobs()){
				ArrayList<String> list = dao.getJobs();
				request.setAttribute("list", list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewJobs.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("errmsg", "NO MORE POST");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewAnnouncement.jsp");
				rd.forward(request, response);
			}
			
		}
	}
}
