package myRobot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myRobot.dao.ProductDAO;
import myRobot.db.DBConnect;
import myRobot.vo.Product;


public class ProductDAOImpl implements ProductDAO {
	ArrayList<Product> proAL= new ArrayList<Product>();

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
	public ArrayList<Product> showProList() throws Exception {
		// TODO Auto-generated method stub
		
		String sql="select* from list";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		
		try{
			dbc=new DBConnect();
			pstmt=dbc.getConnection().prepareStatement(sql);

			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				Product pro = new Product();
				pro.setID(rs.getInt("ID"));
				pro.setName(rs.getString("name"));
				pro.setNumber(rs.getInt("number"));
				pro.setPrice(rs.getDouble("price"));
				pro.setDetail(rs.getString("detail"));
				proAL.add(pro);
				//System.out.println(pro);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			//close the connection
			dbc.close();
		}
	return proAL;
	}
	
	@Override
	public int reduceNum(int num,int proID,int amount) throws Exception{
		int number= num - amount;
		Product pro = findProduct(proID);
		pro.setNumber(number);
		
		System.out.println("pronumber="+number);
		String sql="update list set number ='"+number+"' where ID = '"+proID+"'";
		
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		int flag = 0;
		
		try{
			dbc=new DBConnect();
			dbc.getConnection().setAutoCommit(false);
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.executeUpdate();
			
			System.out.println("remainnumber="+number);
			flag = 1;
		
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
			try {
				 dbc.getConnection().rollback();
	           } catch ( Exception e2 ) {}
		}finally{
			dbc.close();
		}
		return flag;
	}
	
	@Override
	public int findNum(int proID)throws Exception{
		int number=0;
		String sql="select* from list where ID = ?";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		
		try{
			dbc=new DBConnect();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1,proID);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("ID")==proID){
					number=rs.getInt("number");
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
		return number;
	}
}
