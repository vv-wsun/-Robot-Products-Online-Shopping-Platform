package myRobot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import myRobot.dao.CartDAO;
import myRobot.db.DBConnect;
import myRobot.vo.Product;
import myRobot.vo.User;
import myRobot.vo.Cart;

public class CartDAOImpl  implements CartDAO {

	@Override
	public int addGoodsInCart(String Username,int number,int ProductID) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql="insert into cart(Username,ProID,Num) values(?,?,?)";
		
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		try{
            dbc=new DBConnect();
            pstmt=(PreparedStatement) dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,Username);
			pstmt.setInt(2,ProductID);
			pstmt.setInt(3,number);
			pstmt.executeUpdate();
			pstmt.close();
			flag = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

	@Override
	public int removeGoodsFromCart(int CartID)throws Exception {
		// TODO Auto-generated method stub
		int flag=0;
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		dbc=new DBConnect();
		String sql="delete from cart where ID = ?";
		
		try{
			dbc=new DBConnect();
			
			dbc.getConnection().setAutoCommit(false);
			pstmt=(PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,CartID);
			pstmt.executeUpdate();
			pstmt.close();
			flag = 1;
		}catch(SQLException e){
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
	public ArrayList<Cart> showCartList(String username) throws Exception{
		ArrayList<Cart> cartAL= new ArrayList<Cart>();

			// TODO Auto-generated method stub
		String sql="select * from cart where Username = ?";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		Product pro = new Product();
		
		try{
			dbc=new DBConnect();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getString("Username").equals(username)){
					Cart cart= new Cart(rs.getInt("ID"),findProduct(rs.getInt("ProID")),rs.getInt("Num"));
					cartAL.add(cart);
				}	
				else cartAL = null;
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			//close the connection
			dbc.close();
		}
		
		return cartAL;
	}
}
