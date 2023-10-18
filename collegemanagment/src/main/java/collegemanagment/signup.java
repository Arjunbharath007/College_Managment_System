package collegemanagment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public signup() {
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
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String branch=request.getParameter("branch");
		String employerid=request.getParameter("empid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("confirmpassword");
		
		System.out.println("first name is "+firstname);
		System.out.println("last name is "+lastname);
		System.out.println("email id is "+email);
		System.out.println("phone no is "+phone);
		System.out.println("branch is "+branch);
		System.out.println("Emp id is "+employerid);
		System.out.println("Username is "+username);
		System.out.println("password is "+password);
		System.out.println("verify password is "+cpassword);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
			
			String sql="insert into details(firstname,lastname,empid,username,email,phone,branch,password,cpassword)values('"+firstname+"','"+lastname+"','"+employerid+"','"+username+"','"+email+"','"+phone+"','"+branch+"','"+password+"','"+cpassword+"')";
		
			PreparedStatement stmt=con.prepareStatement(sql);
			
			int i=stmt.executeUpdate();
			if(i>0) {
				System.out.println("Data Added");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
