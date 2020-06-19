/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Class.*;
import DAO.DeviceDAO;
import DAO.RepairDAO;
import DAO.SparepartDAO;
import DAO.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class UpdateStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int repairID = Integer.parseInt(request.getParameter("repairID"));
        
        String deviceID = DeviceDAO.getDeviceID(repairID);
        
        List<ServiceRepair> sr = RepairDAO.getDetails(repairID);
        
        String spare = SparepartDAO.getSparepart(repairID);
        
        String status = StatusDAO.getStatus(repairID);
        
        request.setAttribute("deviceID", deviceID);
        request.setAttribute("repair", sr);
        request.setAttribute("sparepart", spare);
        request.setAttribute("status", status);
        request.setAttribute("repairID", repairID);
        request.getRequestDispatcher("UpdateStatus.jsp").forward(request, response);
	out.close(); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int repairID = Integer.parseInt(request.getParameter("repairID"));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date= sdf.format(cal.getTime());
        
        StatusDAO.updateStatus(date, repairID, request.getParameter("Status"));
        
        request.getRequestDispatcher("dummy.jsp").forward(request, response);
    }
}
