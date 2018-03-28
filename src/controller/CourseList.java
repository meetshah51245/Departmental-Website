package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factoryClass.CourseListFactory;
import factoryInterface.CourseListInterface;
import model.courseListSetGet;

/**
 * Servlet implementation class CourseList
 */
@WebServlet("/CourseList")
public class CourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String courseId = request.getParameter("id");
		System.out.println(courseId);
		String courseName = request.getParameter("name");
		System.out.println(courseName);
		int concentration = Integer.parseInt(request.getParameter("concentration"));
		
		if(concentration == -1){
			request.setAttribute("errmsg", "Please select a proper concentration.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCourse.jsp");
			rd.forward(request, response);
		}
		
		else{
			Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
	        Matcher matchId = p.matcher(courseId);
	        boolean b = matchId.find();
	        Matcher matchName = p.matcher(courseName);
	        boolean b1 = matchName.find();
	
			if(courseId.isEmpty() || courseName.isEmpty() || b == true || b1 == true){
				request.setAttribute("errmsg", "Input can not be null or cannot contain special characters.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCourse.jsp");
				rd.forward(request, response);
			}else{
				courseListSetGet cl = new courseListSetGet();
		    	CourseListFactory clf = new CourseListFactory();
				CourseListInterface clt = clf.getCreateCourse();
		        
		        if(clt.checkCourse(courseId) == true){
		        	request.setAttribute("errmsg", "This course is allready exist.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCourse.jsp");
					rd.forward(request, response);
		        }else{
					
					cl.setId(courseId);
					cl.setName(courseName);
					cl.setConcentration(concentration);

					int condition = clt.createCourse(cl);
					if(condition == 1){
				//		request.setAttribute("errmsg", "posted.");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewCourseList");
						rd.forward(request, response);
					}
				}
			}
		}
	}
}
