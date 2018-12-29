
package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetCookie", urlPatterns = {"/GetCookie"})
public class GetCookie extends HttpServlet {
    Connection con;
    Statement stmt;
    ResultSet rs;
        
      @Override
      protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
      {
         String s=null;
         
        
        
       Cookie[] k= req.getCookies();
         for(int i=0;i<k.length;i++)
         {
             Cookie org=k[i];
            s= org.getValue();
         }
             
         PrintWriter out=res.getWriter();
         ServletContext ct=getServletContext();
         
         //con=DriverManager.getConnection("","app","app");
         
         ct.setAttribute("sub", s);
         res.setContentType("text/html");
         //String lang=ct.getAttribute("sub").toString();
         out.println("<body style='background-color:cyan'>");
         out.println("<center>");
         
         out.println("<br/><h1>Welcome to"+s+"  Books</h1>");
         out.println("</center>");
         out.println("</body>");
         if(s.equals("C Language"))
         {
             out.println("<body>");
             out.println("<center>");
             out.println("<form>");
             out.println("<table border='1px'>");
             out.println("<tr>");
             out.println("<th>BookTitles</th>");
             out.println("<th>Authore</th>");
             out.println("<th>Price</th>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td><input type='checkbox' name='chk' value='499'/> C Programming</td>");
             out.println("<td>Ashoke N Kamthane</td>");
             out.println("<td>499</td>");
             out.println("</tr>");
             
             
             out.println("<tr>");
             out.println("<td><input type='checkbox' name='chk' value='399'/> C Programming Language</td>");
             out.println("<td>Balaguru Swamy</td>");
             out.println("<td>399</td>");
             out.println("</tr>");
             
             out.println("<tr>");
             out.println("<td><input type='checkbox' name='chk' value='600' />ANSI</td>");
             out.println("<td>John Arfin</td>");
             out.println("<td>600</td>");
             out.println("</tr>");
             
             out.println("<tr >");
                out.println("<td colspan='4'><center><input type='submit' value='Next' formaction='Addtocart'/></td></center>");
             out.println("</tr>");
             out.println("</table>");
             out.println("</form>");
             out.println("</center>");
             out.println("</body>");
         }
         
      }
}