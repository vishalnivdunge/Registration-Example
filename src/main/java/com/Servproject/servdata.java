package com.Servproject;

import java.io.IOException;

import java.io.PrintWriter;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;




@WebServlet("/regg")

public class servdata extends HttpServlet
{
private static final long serialVersionUID=1L;

public servdata() {
	
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
		// TODO Auto-generated method stub
	
	response.setContentType("text/html");
	PrintWriter out= response.getWriter();
	
	//out.println("Welcome !");
	out.println(" I Can Accept Registration Data");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String contact = request.getParameter("contact");
	String qual = request.getParameter("qual");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	out.println("<h1>Name is &nbsp;&nbsp;"+name+"</h1>");
	out.println("<h1>Email is &nbsp;&nbsp;"+email+"</h1>");
	out.println("<h1>Contact is &nbsp;&nbsp;"+contact+"</h1>");
	out.println("<h1>Qualification is &nbsp;&nbsp;"+qual+"</h1>");
	out.println("<h1>Username is &nbsp;&nbsp;"+username+"</h1>");
	out.println("<h1>Password is &nbsp;&nbsp;"+password+"</h1>");

	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Driver Load Succesfully");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exservlet1","root","root");
		System.out.println("Connection Created Succesfully");
		
		if(con!=null)
			
		{
			PreparedStatement ps=con.prepareStatement("insert into student_details values('0',?,?,?,?,?,?)");
			
		//ps.setString(0, id);
			ps.setString(1,name);
			ps.setString(2,email);
		ps.setString(3,contact);
		ps.setString(4,qual);
		ps.setString(5,username);
		ps.setString(6,password);
			
			
     int val=ps.executeUpdate();
     if(val>0)
     {
    	 out.println("Registration Succesfullty");
     }
     else 
     {
    	 out.println("Registration failed");
     }
		}
		
	}	
	catch (Exception ex)
	{
		out.println("Error is "+ex);	
}
}      
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    	{    		
    		doGet(request, response);
    	}
}


