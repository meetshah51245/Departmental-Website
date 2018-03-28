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
import model.DiscussionBoardGetSet;

/**
 * Servlet implementation class DiscussionBoard
 */
@WebServlet("/DiscussionBoard")
public class DiscussionBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussionBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DiscussionFactory df = new DiscussionFactory();
		DiscussionBoardInterface dao = df.geDiscussion();
		DiscussionBoardGetSet dbgs = new DiscussionBoardGetSet();
		String MainPost = request.getParameter("MainPost");
		String topic = request.getParameter("Topic");
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		
		if(!MainPost.isEmpty() && !topic.isEmpty()){
			dbgs.setMainPost(MainPost);
			dbgs.setTopic(topic);
			dbgs.setPID(parentId);
			try {
				dao.postQuestion(dbgs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(MainPost.isEmpty() || topic.isEmpty()){
			request.setAttribute("errmsg", "Input could not be empty.");
		    RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/DiscussionBoardPost.jsp");
		    rd1.forward(request, response);
		} 
		
		HashMap<String, ArrayList<String>> map = null;
		try {
			map = dao.selectPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list = map.get("list");
		for(int i = 0; i < list.size(); i++){ 
		 System.out.println(list.get(i)); 
		}  
		request.setAttribute("map", map);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/DiscussionBoard.jsp");
		rd.forward(request, response);   
	}
}