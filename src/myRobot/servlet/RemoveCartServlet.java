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
import myRobot.dao.impl.CartDAOImpl;
import myRobot.vo.Cart;

public class RemoveCartServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public RemoveCartServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		ArrayList<Cart> cartAL= new ArrayList<Cart>();	
		CartDAO dao = new CartDAOImpl();
		int flag = 0;
		
		int cartID = Integer.parseInt(request.getParameter("cartID"));
		String username = request.getParameter("username");
		
		try{
			flag = dao.removeGoodsFromCart(cartID);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag == 1){
			try{
				cartAL = dao.showCartList(username);
			}catch(Exception e){
				e.printStackTrace();
			}
			HttpSession session=request.getSession();  
		    session.setAttribute("cartAL", cartAL);
			response.sendRedirect("../cart.jsp");
		}
		else response.sendRedirect("../error.jsp");
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
