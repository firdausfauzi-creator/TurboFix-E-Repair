
package servlet;

import Class.Device;
import DAO.DeviceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class ViewDeviceList extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
                
		long ic = Long.parseLong(request.getParameter("custIC"));
                request.setAttribute("ic", ic);
		List<Device> list=DeviceDAO.view(ic);
                request.setAttribute("dev", list);
                String name= DeviceDAO.name(ic);
                request.setAttribute("name", name);
                request.getRequestDispatcher("DeviceList.jsp").forward(request, response);
		out.close();
    }
}
