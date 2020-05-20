package myRobot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myRobot.dao.UserDAO;
import myRobot.dao.impl.UserDAOImpl;
import myRobot.vo.User;

public class IdentifyEmailServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public IdentifyEmailServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserDAO dao = new UserDAOImpl();
		
		 User user=new User();
		// HttpSession session=request.getSession();  
		// String username = (String)session.getAttribute("username");	
		 user.setUsername(request.getParameter("username"));
		 user.setEmailaddress(request.getParameter("email"));
		 
		 System.out.println(user.getEmailaddress());
		 
		 int flag = 1;
		 int flag2 = 0;
		 try {
				flag = dao.queryUnique(user);
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// System.out.println("flag="+ flag);
		 
		 
		 if(flag == 0){   
			try {
				flag2 = dao.identifyEmailAddress(user);
			//	System.out.println(flag);
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(flag2 == 1){
				HttpSession session=request.getSession(); 
				session.setAttribute("username", user.getUsername());  
				response.sendRedirect("../modifyPassword.jsp");
			}
			else  
				response.sendRedirect("../error.jsp");
		} else {   
				response.sendRedirect("../error.jsp");
		}
		 
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
