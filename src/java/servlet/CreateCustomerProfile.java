package servlet;

import Class.Customer;
import DAO.CustomerDAO;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
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
public class CreateCustomerProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        out.print("<! DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title> Add Library </title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        
        String IC = request.getParameter("CustomerIC");
        Long CustomerIC = Long.parseLong(IC);
        String Name = request.getParameter("CustomerName");
        String pNumber = request.getParameter("PhoneNumber");
        String Email = request.getParameter("Email");
        String Address = request.getParameter("Address");
        
        out.println(CustomerIC);
        out.println(Name);
        out.println(pNumber);
        out.println(Email);
        out.println(Address);
        
        Customer cust = new Customer(CustomerIC, Name, pNumber, Email, Address);
        //out.println(cust.getCustomer_ic());
        
        int status = CustomerDAO.createCustomer(cust); 
        out.print(status);
        request.setAttribute("cust", cust);
        long ic = Long.parseLong(request.getParameter("CustomerIC"));
        request.setAttribute("ic", ic);
        request.getRequestDispatcher("DisplayCustomerProfile.jsp").forward(request, response);
        
        
        
    }



}
