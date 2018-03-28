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
import javax.servlet.http.HttpSession;

import factoryClass.LoginFactory;
import factoryInterface.LoginInterface;
import model.logInSetGet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		logInSetGet login = new logInSetGet();
		LoginFactory log1 = new LoginFactory();
		LoginInterface log = log1.getLogin();
		String user = request.getParameter("User");
		String netId = request.getParameter("NET ID");
		String pass = request.getParameter("Password");

		
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher matchId = p.matcher(netId);
        boolean b = matchId.find();
        Matcher matchFname = p.matcher(user);
        boolean bool = matchFname.find();
        
		if (user.isEmpty() || netId.isEmpty() || pass.isEmpty()) {
			request.setAttribute("errmsg", "Input can not be null.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);

		} else if((netId.contains(" ") || pass.contains(" ") || user.contains(" ")) 
				|| ((b == true) || (bool == true))){
			// Send error message to jsp page if it contains space
			request.setAttribute("errmsg", "Invalid input.");
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		    rd.forward(request, response);
		}
		else{
	    	login.setUser(user);
	    	login.setNetid(netId);
	    	login.setPassword(pass);
	    	
	    	boolean bl = false;
			try {
				bl = log.selectQuery(login);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	if (bl == true) {		
				String fullName = log.selectQuery1(login);
				HttpSession hs = request.getSession();
		    	hs.setAttribute("net", fullName);
		    	hs.setAttribute("netId",netId);
		    	hs.setAttribute("User", user);
		    	response.sendRedirect("HomePage.jsp");
			}else if(bl == false) {
				request.setAttribute("errmsg", "This user does not exist.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
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
