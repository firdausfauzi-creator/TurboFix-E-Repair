
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

public class ViewAllRepairList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            List<Device> dv = DeviceDAO.viewAll();
            
            List<ServiceRepair> sr = RepairDAO.viewAll();
            
            List<Status> st = StatusDAO.viewAll();
            
            List<Sparepart> sp = SparepartDAO.viewAll();
            
            request.setAttribute("device", dv);
            request.setAttribute("service", sr);
            request.setAttribute("status", st);
            request.setAttribute("sparepart", sp);
            
            if(request.getParameter("Status").equals("tech"))
            {
                request.getRequestDispatcher("TechnicianRepairList.jsp").forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("AllRepairList.jsp").forward(request, response);
            }
            
        
    }
}
