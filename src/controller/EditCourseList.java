package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factoryClass.CourseListFactory;
import factoryInterface.CourseListInterface;

/**
 * Servlet implementation class EditCourseList
 */
@WebServlet("/EditCourseList")
public class EditCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String syllabus = request.getParameter("syllabus");
		String courseId = request.getParameter("courseId");
		int concentration = Integer.parseInt(request.getParameter("concentration"));
    	CourseListFactory clf = new CourseListFactory();
		CourseListInterface clt = clf.getCreateCourse();
		
		int condition = clt.updateSyllabus(syllabus, courseId);
		
		if(condition == 1){
		
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
//		doGet(request, response);
		String fullName = request.getParameter("instructor");
		String courseId = request.getParameter("courseId");
		int concentration = Integer.parseInt(request.getParameter("concentration"));
    	CourseListFactory clf = new CourseListFactory();
		CourseListInterface clt = clf.getCreateCourse();
		
		int condition = clt.updateInstructor(fullName, courseId);
		
		if(condition == 1){
		
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

}
