package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import entity.*;
public class mainServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException,IOException
	{	
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String username=req.getParameter("username");
		
		String pwd=req.getParameter("pwd");
		
		UserDao db=new UserDao();
		
		HttpSession session=req.getSession();
		
		User user=(User) session.getAttribute("user");
	
			
			user=db.checkUser(username,pwd);
		
	
		
		
		System.out.print(user!=null);
		if(user!=null){
			
			
			res.sendRedirect("success.jsp");

		}
		else 
		{
			res.sendRedirect("error.jsp");
		}
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws UnsupportedEncodingException,IOException
	{
		doGet(req,res);
	}
}
