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

import dao.AnnouncementDAO;

/**
 * Servlet implementation class PostAnnouncement
 */
@WebServlet("/PostAnnouncement")
public class PostAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnnouncement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String type = request.getParameter("type");
		String MainPost = request.getParameter("MainPost");
		String link = request.getParameter("link");
		
		HttpSession hs = request.getSession();
		String owner = (String) hs.getAttribute("netId");
		
		if(MainPost.isEmpty()){
			request.setAttribute("errmsg", "Can't be null.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostAnnouncement.jsp");
			rd.forward(request, response);
		}else{
			AnnouncementDAO dao = new AnnouncementDAO();
			dao.insertIntoAnnounce(type,MainPost,link, owner);
			request.setAttribute("errmsg", "Posted");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/PostAnnouncement.jsp");
			rd.forward(request, response);
		}
	}

}
