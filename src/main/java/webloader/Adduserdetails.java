package webloader;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Adduserdetails")
public class Adduserdetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter object=response.getWriter();){
		String n=request.getParameter("name1");
		String un=request.getParameter("username1");
		String pa=request.getParameter("password1");
		String cp=request.getParameter("confirm1");
//		PrintWriter object=response.getWriter();
//		object.println("name1"+" "+n);
//		object.println("username1"+" "+un);
//		object.println("password1"+" "+pa);
//		object.println("confirm1"+" "+cp);
////		
//		
//		
//		System.out.println("name1"+" "+name);
//		System.out.println("username1"+" "+username);
//		System.out.println("password1"+" "+password);
//		System.out.println("confirm1"+" "+cpassword);
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/hitech";
//			String user="root";
//			String password1="Karthivickey__9952";
//			Connection con;
//			
//		} 
		Class.forName("com.mysql.jdbc.Driver");
		String user="root";
		String password1="Karthivickey__9952";
		Connection con = DriverManager.getConnection(url,user,password1);
		Statement  st=con.createStatement();
		int result=st.executeUpdate("insert into user1(name,uname,password,cpassword) values ('"+n+"','"+un+"', '"+pa+"','"+cp+"')");
		if(result==1)
		{
			object.println("sdfgh");
		}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
