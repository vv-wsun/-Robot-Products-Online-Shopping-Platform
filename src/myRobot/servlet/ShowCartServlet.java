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

public class ShowCartServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
public ShowCartServlet() {
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

		CartDAO dao = new CartDAOImpl();
		ArrayList<Cart> cartAL= new ArrayList<Cart>();	
		
		String username = request.getParameter("username");
		try{
			cartAL = dao.showCartList(username);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();  
	    session.setAttribute("cartAL", cartAL);
	    response.sendRedirect("../cart.jsp");
		
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

		doGet(request,response);
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
