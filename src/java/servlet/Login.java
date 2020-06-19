
package servlet;

import Class.Staff;
import DAO.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Login extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String sID = request.getParameter("StaffID");
        long StaffID = Long.parseLong(sID);
        
        String Password = request.getParameter("password");
        
        String role = StaffDAO.login(StaffID,Password);
            
        if(role.equalsIgnoreCase("Staff"))
        {
            request.getRequestDispatcher("StaffHome.jsp").forward(request, response);
        }
        else if(role.equalsIgnoreCase("Technician"))
        {
            request.getRequestDispatcher("TechnicianHome.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("login", "login");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
