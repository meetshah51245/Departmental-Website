package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factoryClass.PostExamFactory;
import factoryInterface.PostExamInterface;

/**
 * Servlet implementation class ViewExams
 */
@WebServlet("/ViewExams")
public class ViewExams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewExams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PostExamFactory p = new PostExamFactory();
		PostExamInterface dao = p.getExam();
		
		boolean list = dao.isExams();
		   if(list == true){
				ArrayList<String> list1 = null;
				try {
					list1 = dao.selectExams();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("list", list1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewExams.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("errmsg", "Yayyyy No more Exams.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/postExam.jsp");
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
