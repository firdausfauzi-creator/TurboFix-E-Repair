
package servlet;

import Class.Customer;
import DAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class EditCustomerProfile extends HttpServlet
{   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String cIC = request.getParameter("custIC");
        long CustomerIC = Long.parseLong(cIC);
    
       Customer cust = CustomerDAO.viewByIC(CustomerIC);
       out.print(CustomerIC);
       request.setAttribute("cust", cust);
       request.getRequestDispatcher("EditCustomerProfile.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String cIC = request.getParameter("CustomerIC");
        long CustomerIC = Long.parseLong(cIC);
        String Name = request.getParameter("CustomerName");
        String PhoneNumber = request.getParameter("PhoneNumber");
        String Email = request.getParameter("Email");
        String Address = request.getParameter("Address");
        
        CustomerDAO.updateData(CustomerIC, Name, PhoneNumber, Email, Address);
        out.print(CustomerIC);
        
        Customer cust = new Customer(CustomerIC, Name, PhoneNumber, Email, Address);
        request.setAttribute("cust",cust);
        request.getRequestDispatcher("EditCustomerSuccess.jsp").forward(request, response);
    }
}
