
package servlet;

import Class.Customer;
import DAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ViewCustomerProfile extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Customer> list=CustomerDAO.view();
                request.setAttribute("cust", list);
                request.getRequestDispatcher("ViewCustomerList.jsp").forward(request, response);
		out.close();
    }
    

}
