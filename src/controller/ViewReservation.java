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

import dao.ResourceDAO;

/**
 * Servlet implementation class ViewReservation
 */
@WebServlet("/ViewReservation")
public class ViewReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		ResourceDAO dao = new ResourceDAO();
		HttpSession hs = request.getSession();
		String netID = (String) hs.getAttribute("netId");
		boolean bool = dao.checkReservation(netID);
		if(bool == true){
			request.setAttribute("errmsg", "You have not registerd for any resources.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewReservation.jsp");
			rd.forward(request, response);
		}else{
			ArrayList<String> list = dao.getReservationList(netID);
			request.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewReservation.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String ID = request.getParameter("ID");
		HttpSession hs = request.getSession();
		String netID = (String) hs.getAttribute("netId");
		
		ResourceDAO dao = new ResourceDAO();
		int condition = dao.cancelReservation(ID);
		if(condition == 1){
			boolean bool = dao.checkReservation(netID);
			if(bool == true){
				request.setAttribute("errmsg", "You have not registerd for any resources.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewReservation.jsp");
				rd.forward(request, response);
			}else{
				ArrayList<String> list = dao.getReservationList(netID);
				request.setAttribute("list", list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewReservation.jsp");
				rd.forward(request, response);
			}
		}
	}

}
