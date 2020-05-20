package myRobot.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.criteria.Order;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myRobot.dao.CartDAO;
import myRobot.dao.impl.CartDAOImpl;
import myRobot.dao.ProductDAO;
import myRobot.dao.impl.ProductDAOImpl;
import myRobot.dao.OrderDAO;
import myRobot.dao.impl.OrderDAOImpl;
import myRobot.vo.Cart;
import myRobot.vo.Product;


public class AddOrderServlet extends HttpServlet {

	/**
      * constructor of the object.
      */
	public AddOrderServlet(){
		super();
	}

      public void destroy(){
    	  super.destroy();
      }
    	  
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		doPost(request,response);
  			
  		
  	}

  		  
  	  
      public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	
    	  OrderDAO dao=new OrderDAOImpl();
    	  CartDAO cartDao=new CartDAOImpl();
    	  ProductDAO proDao=new ProductDAOImpl();
    	  
    	  HttpSession session=request.getSession();  
  		  ArrayList<Cart> cartAL= (ArrayList<Cart>)session.getAttribute("cartAL");
  		  String username = (String)session.getAttribute("username");
  		  
    	  int flag3 = 1;
    	  
    	  int flag = 0;
    	  int flag1 = 0;
    	  int flag2 = 0;
    	  
    	  String orderNum =dao.getTwo();
    	  session.setAttribute("orderNum", orderNum);
    	  
    	  for(Cart tem: cartAL){
    		  Product pro = tem.getPro();
    		  int proID = pro.getID();
    		  //int num = pro.getNumber();
    		  int amount = tem.getAmount();    		  
    		  int cartID = tem.getCartID();
    		  
    	/*	  try{
    				jdbcUtils.beginTransaction();
    			
    				jdbcUtils.commitTransaction();
    			}catch(){
    				jdbcUtils.rollbackTransaction();
    			}
    			}*/
    		  try{
    			 int num = proDao.findNum(proID);
    			 System.out.println("servletnumber="+num);
    			 flag = 0;
    	    	 flag1 = 0;
    	    	 flag2 = 0;
    	    	 
        		 if((num-amount)>=0){
        			 flag=dao.addGoodsInOrder(username, amount,proID, orderNum);
             		 System.out.println("flag="+flag);
        			 flag1=proDao.reduceNum(num,proID,amount);
             		 System.out.println("flag1="+flag1);
             		 flag2=cartDao.removeGoodsFromCart(cartID);
             		 System.out.println("flag2="+flag2);
        		 }
        	  }catch(Exception e){
        		  e.printStackTrace();
        	  }
    		  
    		 if(flag==0 || flag1==0 || flag2==0)
     			 flag3 = 0;
    		 
    		 //System.out.println(flag3);
    	  }
    	  
    	  if(flag3==1){
    		  response.sendRedirect("../addorder.jsp");
    	  }else{
    		  response.sendRedirect("../error.jsp");
    	  }
    	 
    	  
      }
      public void init() throws ServletException{
    	  
      }
}
