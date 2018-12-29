package abc;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name="/Payment",urlPatterns={"/Payment"})
public class Payment extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
        //out.println("hii");
        HttpSession session=req.getSession(false);
       String s= session.getAttribute("lang").toString();
      String s1= session.getId();
      out.println("Id"+s1);
      out.println(session.getMaxInactiveInterval());
      
        if(session.getAttribute("lang")!=null)
        {
            out.println("payment done");
        }
        else if(session.getAttribute("lang")==null)
        {
            out.println("session expired");
        }
        out.println(s);
    }
}