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
 * Servlet implementation class ReserveResource
 */
@WebServlet("/ReserveResource")
public class ReserveResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String type = request.getParameter("resourceType");
		String name = request.getParameter("resourceName");
		String info = request.getParameter("resourceInfo");
		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(type);
		list.add(info);
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/reservation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String type = request.getParameter("resourceType");
		String name = request.getParameter("resourceName");
		String info = request.getParameter("resourceInfo");
		String date = request.getParameter("date");
		String timeSlot = request.getParameter("TimeSlot");
		
		HttpSession hs = request.getSession();
		String fullName = (String) hs.getAttribute("net");
		String netId = (String) hs.getAttribute("netId");
		
		
		if(date.isEmpty()){
			request.setAttribute("errmsg", "date can not be null");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/reservation.jsp");
			rd.forward(request, response);
		}else{
			ResourceDAO dao = new ResourceDAO();
			boolean b = dao.isReserved(type, name, date, timeSlot, netId);
			if(b == true){
				request.setAttribute("errmsg", "You have already registered this resource.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/reservation.jsp");
				rd.forward(request, response);
			}else{
				int codition = dao.addReservation(type, name, info, date, timeSlot, netId);
				if(codition == 1){
					request.setAttribute("errmsg", "You have registered "+name+" on "+date+" at "+timeSlot+" with name "+fullName+".");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/reservation.jsp");
					rd.forward(request, response);
				}
			}
		}
	}

}
