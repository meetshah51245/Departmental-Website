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
 * Servlet implementation class CreateResource
 */
@WebServlet("/CreateResource")
public class CreateResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ResourceDAO dao = new ResourceDAO();
		ArrayList<String> list = dao.getResourceList();
		request.setAttribute("list", list);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ReserveResource.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String info = request.getParameter("info");
		HttpSession hs = request.getSession();
		String owner = (String) hs.getAttribute("netId");
		
		ResourceDAO dao = new ResourceDAO();
		if(dao.checkResource(name)){
			int condition = dao.addResource(name, type, info, owner);
			if(condition == 1){
				request.setAttribute("errmsg", "New resource has been created.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/CreateResource.jsp");
				rd.forward(request, response);
			}
		}else{
			request.setAttribute("errmsg", "Duplicate entry.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CreateResource.jsp");
			rd.forward(request, response);
		}
		
	}

}
