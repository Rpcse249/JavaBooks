package abc;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="/Addtocart",urlPatterns={"/Addtocart"})
public class Addtocart extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        
        PrintWriter out=res.getWriter();
       //String[] str= req.getParameterValues("chk");
      String[] str=req.getParameterValues("chk");
     int[] in=new int[str.length];
       //out.println(str);
       for(int i=0;i<in.length;i++)
       {
            in[i]=Integer.parseInt(str[i]);
       }
       int sum=0;
       for(int i=0;i<in.length;i++)
       {
           sum=sum+in[i];
       }
       
      ServletContext ct=getServletContext();
       RequestDispatcher disp=ct.getRequestDispatcher("/GetCookie");
       disp.include(req, res);
       res.setContentType("text/html");
       out.println("<html>");
       out.println("<body>");
       out.println("<center>"); 
       out.println("<form>");
       out.println("Your Cart Amount is <h2>"+sum+"</h2>");
       out.println("<input type='submit' value='Procede to Payment' formaction='payment.html'/>");
       out.println("</form>");
       out.println("</center>");
       out.println("</body>");
       out.println("<html>");
    }
}