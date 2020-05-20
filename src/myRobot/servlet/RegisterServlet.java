package myRobot.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myRobot.dao.UserDAO;
import myRobot.dao.impl.UserDAOImpl;
import myRobot.db.DBConnect;
import myRobot.vo.User;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		      throws IOException, ServletException{
		    	  
		      }
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
		      throws IOException, ServletException{
		 int flag=1;
		 int flag2=0;
		 
		 User user=new User();
		 user.setUsername(req.getParameter("username"));
		 user.setPassword(req.getParameter("password"));
		 user.setEmailaddress(req.getParameter("emailaddress"));
		 
		 UserDAO dao=new UserDAOImpl();
		 try {
				flag = dao.queryUnique(user);
			//	System.out.println(flag);
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(flag == 1){
			 try {
					flag2 = dao.add(user);
				} catch (Exception e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		  
		if(flag2==1){
			 HttpSession session=req.getSession();
	   		 session.setAttribute("username", user.getUsername());
	   		 res.sendRedirect("./welcome.jsp");
		 }
		else res.sendRedirect("./error.jsp");
	 }
}