package Dao;

import java.sql.*;
import java.util.*;


import entity.User;


public class UserDao {
	Connection ct;
	PreparedStatement pstmt;
	
	public UserDao()
	{
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JSP","sa","123456");//链接对象
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


public User checkUser(String username,String password)
{
	try {
		pstmt=ct.prepareStatement("select*from[userTable]where username=? and password=?");
		pstmt.setString(1,username);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		User user=new User();
		while(rs.next())
		{
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			return user;
		}
		return null;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
}



public String getUserName(int id){
	String username=null;
	
	try{
		pstmt=ct.prepareStatement("select username from [userTable] where id=?");
		
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			username=rs.getString(1);
		}
		return username;
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	
	
}



public boolean addInfo1(User us)
{
	try{
		pstmt=ct.prepareStatement("insert into [userTable] values(?,?,?)");
		pstmt.setInt(1, us.getId());
		pstmt.setString(2, us.getUsername());
		pstmt.setString(3, us.getPassword());
		System.out.println(us.getPassword());
		pstmt.executeUpdate();
		return true;
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}

}


private String getTitle() {
	// TODO Auto-generated method stub
	return null;
}

}