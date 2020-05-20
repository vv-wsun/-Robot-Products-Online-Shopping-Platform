package myRobot.dao.impl;

import myRobot.dao.UserDAO;
import myRobot.vo.User;
import myRobot.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

	@Override
	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        
        try{      
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername());   
              
            ResultSet rs = pstmt.executeQuery();
            System.out.println(user.getUsername());
            while(rs.next()){    
            	if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{    
            dbc.close() ;   
        }
        
		return flag;
	}
	
	@Override
	public int queryUnique(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 1;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        
        try{      
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;   
              
            ResultSet rs = pstmt.executeQuery();            
            while(rs.next()){    
            	if(rs.getString("username").equals(user.getUsername())){
                	flag = 0;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{    
            dbc.close() ;   
        }
        
		return flag;
	}
	
	public int identifyEmailAddress(User user) throws Exception{
		int flag = 0;
		
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        
        try{      
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){    
            	if(rs.getString("emailaddress").equals(user.getEmailaddress())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{    
            dbc.close() ;   
        }
        
		return flag;
	}
	
	@Override
	public int add(User user) throws Exception{
		 int flag = 0;
			 String sql="insert into userinfo(username,password,emailaddress) values(?,?,?)";
			 PreparedStatement pstmt=null;
			 DBConnect dbc=null;
			 
			 try{
				 dbc=new DBConnect();
				 pstmt=(PreparedStatement) dbc.getConnection().prepareStatement(sql);
				 //add information into SQL
				 pstmt.setString(1, user.getUsername());
				 pstmt.setString(2, user.getPassword());
				 pstmt.setString(3, user.getEmailaddress());
				 pstmt.executeUpdate();
				 flag = 1;
				 
		         pstmt.close() ; 
			 }catch(SQLException e){
				 System.out.println(e.getMessage());
			 }finally{
				 dbc.close();
			 }
		return flag;
	}
	
	@Override
	public int modifyPassword(String password,String username) throws Exception{
		int flag = 0;
		
		String sql="update userinfo set password = '" + password +"' where username = '"+ username+"'";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		
		try{
			dbc=new DBConnect();
			pstmt=dbc.getConnection().prepareStatement(sql);			
			pstmt.executeUpdate();
			flag = 1;
		
			pstmt.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			dbc.close();
		}
		return flag;
	}
}
