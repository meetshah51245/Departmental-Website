package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factoryClass.PostExamFactory;
import factoryInterface.PostExamInterface;
import model.examSetGet;

/**
 * Servlet implementation class postExam
 */
@WebServlet("/postExam")
public class postExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postExam() {
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
//		doGet(request, response);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String examType = request.getParameter("examType");
		String dateOfExam = request.getParameter("dateOfExam");
		String ExamName = request.getParameter("ExamName");
		
		java.util.Date date = null;
     	try {
     	    date = new SimpleDateFormat("yyyy-mm-dd").parse(dateOfExam);
     	}catch (Exception e) {
     	    e.printStackTrace();
     	}
		
		String content = request.getParameter("post");
		
		if(dateOfExam.isEmpty() || dateOfExam.contains(" ") || ExamName.isEmpty()){
			request.setAttribute("errmsg", "Input can not be null or contain space.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/postExam.jsp");
			rd.forward(request, response);
		}else{
			PostExamFactory p = new PostExamFactory();
			PostExamInterface dao = p.getExam();
			examSetGet ex = new examSetGet();
			HttpSession hs = request.getSession();
			ex.setContent(content);
			ex.setDate(date);
			ex.setType(examType);
			ex.setName(ExamName);
			ex.setOwner((String) hs.getAttribute("netId"));
			
			boolean list = dao.checkExams(ex);
			   if(list == false){
				   dao.insertExam(ex);
				   RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewExams");
					rd.forward(request, response);
			   }else{  
					request.setAttribute("errmsg", "This exam is already created.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/postExam.jsp");
					rd.forward(request, response);
				}
		}
	}	
}
