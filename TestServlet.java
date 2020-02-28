import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/test.nsbt","/my.do","/new.nsbt"})
@WebServlet("/test.nsbt")
//@WebServlet("*.do")
//@WebServlet(urlPatterns = {"*.do","*.nsbt"})
//@WebServlet("/*")
public class TestServlet extends HttpServlet {

    int count;
    public void init(){
        System.out.println("Init called");
        count = 1;
    }
    public void destroy(){
        System.out.println("Destroy called");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count=1;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1> First Servlet</h1>");
        out.println("The count is " + count++);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("username");
        String pass = req.getParameter("pass");
        String age = req.getParameter("age");

        int ag = Integer.parseInt(age);

        String hobbies[] = req.getParameterValues("c1");


        if(name.equals("admin"))
        {

            String loginId = name.substring(0,1) + pass.substring(0,1);
            req.setAttribute("loginid", loginId); //request variable
            resp.sendRedirect("sec.do");
           /* RequestDispatcher rd = req.getRequestDispatcher("sec.do");
            rd.forward(req,resp);*/
        }
          //  resp.sendRedirect("success.html");
        else
            resp.sendRedirect("test.html");

       /* resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1> First Servlet</h1>");
        out.println(name + " " + pass);
        out.println("</body></html>");*/
    }
}
