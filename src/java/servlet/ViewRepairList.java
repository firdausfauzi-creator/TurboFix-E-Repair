
package servlet;

import Class.*;
import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ViewRepairList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        int deviceID = Integer.parseInt(request.getParameter("deviceID"));
        
        List<ServiceRepair> sr = RepairDAO.view(deviceID);
       
        List<Status> st = StatusDAO.view(deviceID);
        
        List<Sparepart> sp = SparepartDAO.view(deviceID);
        
        request.setAttribute("deviceID", deviceID);
        request.setAttribute("serviceRepair", sr);
        request.setAttribute("status", st);
        request.setAttribute("sparepart", sp);
        
        request.getRequestDispatcher("DeviceRepairList.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
