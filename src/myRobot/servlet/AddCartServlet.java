package myRobot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myRobot.dao.CartDAO;
import myRobot.dao.ProductDAO;
import myRobot.dao.impl.CartDAOImpl;
import myRobot.dao.impl.ProductDAOImpl;
import myRobot.vo.Product;
import myRobot.vo.User;
import myRobot.vo.Cart;

public class AddCartServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddCartServlet() {
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
		CartDAO dao = new CartDAOImpl();
		ArrayList<Cart> cartAL= new ArrayList<Cart>();
		int flag = 0;
		
		int proID = Integer.parseInt(request.getParameter("id"));
		int number = Integer.parseInt(request.getParameter("number"));
		HttpSession session=request.getSession();  
		String username = (String)session.getAttribute("username");	
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		int remain= number - amount;
		
		if(remain>=0){
			try{
				flag = dao.addGoodsInCart(username,amount,proID);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(flag == 1){ 
			    session.setAttribute("amount", amount);
				response.sendRedirect("../add.jsp");
			}else{
				response.sendRedirect("../error.jsp");
			}
		}else response.sendRedirect("../error.jsp");	
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
