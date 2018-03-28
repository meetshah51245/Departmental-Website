package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factoryClass.RegisterFactory;
import factoryInterface.RegistrationInterface;
import model.RegistrationSetGet;
/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
@MultipartConfig(maxFileSize = 16177215)
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		
		
		// basic information
		String user = request.getParameter("User");
		String fname = request.getParameter("first name");
		String lname = request.getParameter("last name");
		String netId = request.getParameter("NET ID");
		String program = request.getParameter("Program");
		String pass = request.getParameter("Password");
		String Cpass = request.getParameter("major");
		
        //validation
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher matchId = p.matcher(netId);
        boolean b = matchId.find();
        Matcher matchFname = p.matcher(fname);
        boolean bool = matchFname.find();
        Matcher matchLname = p.matcher(lname);
        boolean boolLname = matchLname.find();
        
        if (user.isEmpty() || netId.isEmpty() || pass.isEmpty() || fname.isEmpty() 
        		|| lname.isEmpty()){   
        	if(!user.equals("Student")){
        		if(program.isEmpty() || Cpass.isEmpty() || program.contains(" ") || Cpass.contains(" ")){
        			request.setAttribute("errmsg", "Input can not be null or contain space.");
        			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
        			rd.forward(request, response);
        		}
        	}else{
        		request.setAttribute("errmsg", "Input can not be null.");
        		RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
        		rd.forward(request, response);
        	}

		} else if((fname.contains(" ") || lname.contains(" ")  || netId.contains(" ") || pass.contains(" ")) 
				&& ((b == true) || (bool == true) || (boolLname == true))){
			
				request.setAttribute("errmsg", "Invalid input.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
		}else{
        
	        RegisterFactory register = new RegisterFactory();
			RegistrationInterface registraiondao = register.getRegister(user);
	     	RegistrationSetGet regSetGet = new RegistrationSetGet();
	     	regSetGet.setProgram(program);
	     	regSetGet.setFname(fname);
	     	regSetGet.setLname(lname);
	     	regSetGet.setPassword(pass);
	     	regSetGet.setNetid(netId);
	     	regSetGet.setUser(user);
	     	regSetGet.setMajor(Cpass);
	     	 
	     	boolean bl = false;
			try {
				bl = registraiondao.selectQuery(regSetGet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    	if (bl == true) {
		    	request.setAttribute("errmsg", "This user is allready exist.");	
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
				requestDispatcher.forward(request, response);
			}else{
		       	int condition = 0;
				try {
					condition = registraiondao.insertData(regSetGet);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      	   
		      	   if (condition == 1) {
		      		 Date td = new Date();
		     		 SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		     		 HttpSession hs = request.getSession();
		     		 hs.setAttribute("time", dt.format(td));
			            RequestDispatcher requestDispatcher = request
			                    .getRequestDispatcher("/login.jsp");
			            requestDispatcher.forward(request, response);
			      } else {
			            RequestDispatcher requestDispatcher = request
			                    .getRequestDispatcher("/registration.jsp");
			            requestDispatcher.forward(request, response);
			      }
			} 
       }
	}
}