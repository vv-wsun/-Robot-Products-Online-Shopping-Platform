package myRobot.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myRobot.dao.ProductDAO;
import myRobot.dao.impl.ProductDAOImpl;
import myRobot.vo.Product;

public class ShowServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
		ProductDAO dao = new ProductDAOImpl();
		Product pro = new Product();
		ArrayList<Product> proAL= new ArrayList<Product>();
		
		try{
			proAL = dao.showProList();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		HttpSession session=req.getSession();  
	    session.setAttribute("proAL", proAL);
	   // req.getRequestDispatcher("./index.jsp").include(req,res);
	    res.sendRedirect("./product.jsp");
	}
}
