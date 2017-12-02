

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		PrintWriter pw=res.getWriter();
		req.getRequestDispatcher("Link.html").include(req,res);
		
		Cookie ck[]=req.getCookies();
		
		if(ck!=null) {
			
			String name=ck[0].getValue();
			
		if(!name.equals("")||name!=null ) {
			
			pw.print("Welcome to your Profile "+name);
		
		}	
		}
		else {
			pw.print("First Login");
			req.getRequestDispatcher("Login.html").include(req,res);
		}
		pw.close();
	}
	
}
