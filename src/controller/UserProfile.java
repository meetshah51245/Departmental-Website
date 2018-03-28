package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factoryClass.UserProfileFactory;
import factoryInterface.userProfileInterface;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession hs = request.getSession();
		String netId = (String) hs.getAttribute("netId");
		String user = (String) hs.getAttribute("User");
		
		UserProfileFactory upf = new UserProfileFactory();
		userProfileInterface upi = upf.getInfo(user);
		HashMap<String, ArrayList<String>> map = upi.getInfo(netId);
		System.out.println(hs.getAttribute("net"));
		
		HttpSession hs1 = request.getSession();
		hs1.setAttribute("map", map);
		response.sendRedirect("userProfile.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
