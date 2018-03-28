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
 * Servlet implementation class PhD
 */
@WebServlet("/PhD")
public class PhD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PhdDAO phd = new PhdDAO(); 
		boolean flag = phd.selectQuery("phd");
		if(flag == false){
			request.setAttribute("errmsg", "No phd students");
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/phd.jsp");
            requestDispatcher.forward(request, response);
		}
		else{
			HashMap<String, ArrayList<String>> map = phd.Name("phd");
			HttpSession hs2 = request.getSession();
			hs2.setAttribute("map", map);
			response.sendRedirect("phd.jsp");
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
