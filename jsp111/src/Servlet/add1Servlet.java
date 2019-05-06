package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.User;

import Dao.UserDao;


import sun.awt.RepaintArea;

public class add1Servlet extends HttpServlet  {
	static int Usernum=0;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		System.out.println("��ִ�е�1");
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		System.out.println("��ִ�е�2");
			
	
			
			User user=(User)req.getSession().getAttribute("user");
			
			String username=req.getParameter("username");
			
			System.out.println("�û��˺���"+username);
		
			String pwd=req.getParameter("pwd");
			System.out.println("�û�������"+pwd);
			User us=new User();
			
			us.setId(Usernum++);
			
			us.setUsername(username);
			us.setPassword(pwd);
			
			System.out.println(username+"--"+us.getUsername());
			System.out.println(pwd+"--"+us.getPassword());
			System.out.println("��ִ�е�3");
			if(new UserDao().addInfo1(us))
			{
				res.sendRedirect("login.jsp");
			}
			
			System.out.println("��ִ�е�4");	
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req, res);
	
	}
}
