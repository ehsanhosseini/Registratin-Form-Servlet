

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		
		//RequestDispatcher rd=req.getRequestDispatcher("/Link.html");
		req.getRequestDispatcher("Link.html").include(req,res);
		
		String name=req.getParameter("Name");
		String pass=req.getParameter("Password");
		
		if(pass.equals("ehsan")) {
			pw.println("Welcom "+name);
			
			Cookie ck=new Cookie("name",name);
			res.addCookie(ck);
			
		}
		else {
			
			pw.print("Sorry User Or Password Is Wrong");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
		pw.close();
	}

}
