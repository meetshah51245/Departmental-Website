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

import factoryClass.DiscussionFactory;
import factoryInterface.DiscussionBoardInterface;

/**
 * Servlet implementation class discussion
 */
@WebServlet("/discussion")
public class discussion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public discussion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	  DiscussionFactory df = new DiscussionFactory();	
	  DiscussionBoardInterface dao = df.geDiscussion();
		
	   boolean list = dao.selectEverything();
	   if(list == true){
			HashMap<String, ArrayList<String>> map = null;
			try {
				map = dao.selectPost();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("map", map);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/DiscussionBoard.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("errmsg", "No More Post to show.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/discussion.jsp");
			rd.forward(request, response);
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
