package webloader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class valitation
 */
@WebServlet("/valitation")
public class valitation extends HttpServlet {
	

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter object=response.getWriter()){
		String users=request.getParameter("username");
		String pass=request.getParameter("password");
		
			
		 if(users.equals("sudha") && pass.equals("9952"))
		 {
			 object.println("Wellcome sudha");
			 RequestDispatcher rd= request.getRequestDispatcher("adim.html");
			 rd.forward(request, response);
		 }
		 else {
			 	Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/hitech";
				String user="root";
				String password1="Karthivickey__9952";
				Connection con;
				con = DriverManager.getConnection(url,user,password1);
				Statement  st=con.createStatement(); 
				ResultSet rs=st.executeQuery("Select * from user1");
				int flag=0;
				while(rs.next())
				{
					String users1=rs.getString("uname");
					String cpassword1=rs.getString("cpassword");
					if(users1.equals(users1) && pass.equals(cpassword1))
						
					{
						flag=1;
						object.println("welcome users");
						 RequestDispatcher rd= request.getRequestDispatcher("user.html");
						 rd.forward(request, response);
						break;
					}
				
				}
				if(flag==0)
				{
					object.println("Sorry for the misstake");
					 RequestDispatcher rd= request.getRequestDispatcher("index.html");
					 rd.include(request, response);
				}
		 }
		
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		
}
}
