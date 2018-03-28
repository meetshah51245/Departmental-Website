package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factoryClass.UserProfileFactory;
import factoryInterface.userProfileInterface;
import model.editUserSetGet;

/**
 * Servlet implementation class EditUserInfo
 */
@WebServlet("/EditUserInfo")
public class EditUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String user = request.getParameter("User");
		String fname = request.getParameter("First Name");
		String lname = request.getParameter("Last Name");
		String netId = request.getParameter("Net ID");
		String program = request.getParameter("Program");
		String pass = request.getParameter("Password");
		String major = request.getParameter("Major");
		Long contact = null;
		if(!request.getParameter("Contact Number").equals(null))
			contact = Long.parseLong(request.getParameter("Contact Number"));
		String email = request.getParameter("E-mail");
		String status = request.getParameter("Status");
		String advisor = request.getParameter("Advisor");

		Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher matchFname = p.matcher(fname);
        boolean bool = matchFname.find();
        Matcher matchLname = p.matcher(lname);
        boolean boolLname = matchLname.find();
        
        Pattern p1 = Pattern.compile("[^0-9]");
        Matcher matchContact = p1.matcher(contact.toString());
        boolean boolContact = matchContact.find();
        
        if (user.isEmpty() || netId.isEmpty() || pass.isEmpty() || fname.isEmpty() 
        		|| lname.isEmpty()) {
        	if(!user.equals("Student")){
        		if(program.isEmpty() || major.isEmpty() || program.contains(" ") || major.contains(" ")){
					request.setAttribute("errmsg", "Input cannot be null or cannot contain space.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditUser.jsp");
					rd.forward(request, response);
        		}
        	}else{
        		request.setAttribute("errmsg", "Input can not be null.");
        		RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditUser.jsp");
        		rd.forward(request, response);
        	}	

		}else if((fname.contains(" ") || lname.contains(" ") || email.contains(" ")
				|| netId.contains(" ") || pass.contains(" ") || contact.toString().contains(" ")) 
				&& ((bool == true) || (boolLname == true)|| boolContact == true)){			
			request.setAttribute("errmsg", "Invalid input.");
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditUser.jsp");
		    rd.forward(request, response);
		}else{
			editUserSetGet eu = new editUserSetGet();
			eu.setContact(contact);
			eu.setEmail(email);
			eu.setNetid(netId);
			eu.setMajor(major);
			eu.setFname(fname);
			eu.setLname(lname);
			eu.setProgram(program);
			eu.setPassword(pass);
			eu.setUser(user);
			eu.setStatus(status);
			eu.setAdvisor(advisor);
	
			UserProfileFactory upf = new UserProfileFactory();
			userProfileInterface upi = upf.getInfo(eu.getUser());
			
			boolean check = upi.checkTable(eu);
			if(check == true){
				upi.updateInfo(eu);
 			}else{
 				upi.insertInfo(eu);
 			}
			HashMap<String, ArrayList<String>> map = upi.getInfo(netId);
			
			HttpSession hs1 = request.getSession();
			hs1.removeAttribute("map");
			hs1.setAttribute("map", map);
			response.sendRedirect("userProfile.jsp");
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