package collegemanagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=request.getParameter("username");
		String q=request.getParameter("password");
		
		System.out.println("Username is "+u);
		System.out.println("password is "+q);
		PrintWriter p=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
			
			String sql = "SELECT * FROM details WHERE username='"+u+"' AND password='"+q+"'";
            PreparedStatement stmt=con.prepareStatement(sql);
			
            ResultSet rs=stmt.executeQuery();
//    		while(rs.next()) {
//    			System.out.println(rs.getString("id"));
//    			System.out.println(rs.getString("firstname"));
//    			System.out.println(rs.getString("lastname"));
//    			System.out.println(rs.getString("email"));
//    			System.out.println(rs.getString("phone"));
//    			System.out.println(rs.getString("branch"));
//    			System.out.println(rs.getString("empid"));
//    		}
    		while(rs.next()) {
        	
    		HttpSession session=request.getSession();
    		session.setAttribute("sid",rs.getString("id"));
    		response.sendRedirect("teacherdashboard");
    		}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
