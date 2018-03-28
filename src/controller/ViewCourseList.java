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

import factoryClass.CourseListFactory;
import factoryInterface.CourseListInterface;

/**
 * Servlet implementation class ViewCourseList
 */
@WebServlet("/ViewCourseList")
public class ViewCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
    	CourseListFactory clf = new CourseListFactory();
		CourseListInterface clt = clf.getCreateCourse();
		String courseId = "courseId";
		int concentration = 1;
		
		try{
			concentration = Integer.parseInt(request.getParameter("concentration"));
		//	System.out.println(concentration);
		}catch(Exception e){
			concentration = 1;
		}
		
		HttpSession hs = request.getSession();
		hs.setAttribute("c", concentration);
		
		if(concentration == -1){
			request.setAttribute("errmsg", "Please select a proper concentration.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewCourseList.jsp");
			rd.forward(request, response);
		}
		else{
			if(clt.checkCourse(courseId) == true){
				ArrayList<String> list = clt.selectCourse(concentration);
				request.setAttribute("list", list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewCourse.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("errmsg", "No more courses");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/createCourse.jsp");
				rd.forward(request, response);
			}
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
