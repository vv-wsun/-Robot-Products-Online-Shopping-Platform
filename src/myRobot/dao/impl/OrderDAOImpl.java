package myRobot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Random;

import myRobot.dao.OrderDAO;
import myRobot.db.DBConnect;
import myRobot.vo.Product;
import myRobot.vo.Cart;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public ArrayList<Cart> query(String username) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Cart> cartAL= new ArrayList<Cart>();
		String sql="select* from orderlist where Username=?";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		try{
			dbc=new DBConnect();
			pstmt=(PreparedStatement)dbc.getConnection().prepareStatement(sql);
			//search information from Order
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString("Username").equals(username)){
					Cart cart= new Cart(rs.getInt("ID"),findProduct(rs.getInt("ProID")),rs.getInt("Num"));
					cartAL.add(cart);
				}else cartAL = null;
				}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally
		{
	    dbc.close();
		}
	    return cartAL;
	}
	
	 @Override
	  	public Product findProduct(int proID)throws Exception{
	  		Product pro = new Product();
	  		
	  		String sql="select * from list where ID = ?";
	  		PreparedStatement pstmt=null;
	  		DBConnect dbc=null;
	  		
	  		try{
	  			dbc=new DBConnect();
	  			
	  			pstmt=dbc.getConnection().prepareStatement(sql);
	  			pstmt.setInt(1, proID);
	  			ResultSet rs=pstmt.executeQuery();
	  			while(rs.next()){
	  				if(rs.getInt("ID")==proID){
	  					pro.setID(rs.getInt("ID"));
	  					pro.setName(rs.getString("name"));
	  					pro.setNumber(rs.getInt("number"));
	  					pro.setPrice(rs.getDouble("price"));
	  				}
	  			}
	  			rs.close();
	  			pstmt.close();
	  		}catch(SQLException e){
	  			System.out.println(e.getMessage());
	  		}finally{
	  			//close the connection
	  			dbc.close();
	  		}
	  		return pro;
	  	}
	
	@Override
	public int addGoodsInOrder(String username, int number, int proID,String orderNum) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql="insert into orderlist(Username,ProID,Num,OrderNum) values(?,?,?,?)";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		try{
			dbc=new DBConnect();
			
			dbc.getConnection().setAutoCommit(false);
  			//Savepoint savepoint1 = dbc.getConnection().setSavepoint("savepoint1");
  			
			pstmt=(PreparedStatement)dbc.getConnection().prepareStatement(sql);
	
			pstmt.setString(1,username);
			pstmt.setInt(2, proID);
			pstmt.setInt(3,number);
			pstmt.setString(4,orderNum);
			
			//getTwo();
			
			pstmt.executeUpdate();
			dbc.getConnection().commit();
			pstmt.close();
			flag = 1;
		}catch(SQLException e)
		{
			e.printStackTrace();
			 try {
				 dbc.getConnection().rollback();
	           } catch ( Exception e2 ) {}
		}finally{
		dbc.close();
	}
		return flag;
}


	@Override
	public void removeGoodsFromOrder(String OrderList) throws Exception {
		// TODO Auto-generated method stub
         String sql="delete from orderlist where OrderList=?";
         PreparedStatement pstmt=null;
         DBConnect dbc=null;
         dbc=new DBConnect();
         try{
        	 dbc=new DBConnect();
        	 pstmt=(PreparedStatement)dbc.getConnection().prepareStatement(sql);
        	 ResultSet rs=pstmt.executeQuery();
        	 while(rs.next()){
        		 pstmt.setString(1, OrderList);
        		 }
        	 pstmt.executeUpdate();
        	 pstmt.close();
         }catch(SQLException e){
        	 e.printStackTrace();
         }finally{
        	 dbc.close();
         }
	}
      public  String getTwo(){
    	  Random rad=new Random();
    	  String result=rad.nextInt(100)+"";
    	  if(result.length()==1){
    		  result="0"+result;
    	  }
    	  return result;
      }
	}



