<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言板</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#E3E3E3">
  <center>
  	<form action="add1Servlet" method="post">
  	<table border="1">
  	<caption>注册</caption>
  		<tr>
  			<td>用户名</td>
  			<td><input type="text" name="username"/></td>
  		</tr>
  		
  		<tr>
  			<td>密码</td>
  			<td><input type="text" name="pwd"/></td>
  		
  		</tr>
  		
  		</table>
  		
  		<input type="submit" value="提交"/>
  		<a href="login.jsp" style=" margin-left:190px;">Back</a>
  	</table>
  	
  	
  	</form>
  </center>
  
  </body>
</html>
