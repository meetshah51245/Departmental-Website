package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PhdDAO;

/**
 * Servlet implementation class phdStudents
 */
@WebServlet("/PhdStudents")
public class PhdStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhdStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("phdStudents");
		HttpSession hs2 = request.getSession();
		hs2.setAttribute("phdId", id);
	//	System.out.println("ID:"+id);
		PhdDAO phd = new PhdDAO();
		HashMap<String, ArrayList<String>> map1 = phd.getPhD(id, "phd");
		
		request.setAttribute("map1", map1);
		//request.setAttribute("errmsg", "This user does not exist.");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/phd.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession hs2 = request.getSession();
		String netId = (String) hs2.getAttribute("phdId");
		String status = request.getParameter("status");
		PhdDAO phd = new PhdDAO();
		int condition = phd.updateStatus(netId, status);
		if(condition == 1){
			request.setAttribute("errmsg", "Status Updated");
			//request.setAttribute("errmsg", "This user does not exist.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/phd.jsp");
			rd.forward(request, response);
		}
		
	}
}
