/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Class.*;
import DAO.DeviceDAO;
import DAO.RepairDAO;
import DAO.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckDevice extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        long custIC = Long.parseLong(request.getParameter("custIC"));
        
        List<Device> dv = DeviceDAO.view(custIC);
        
        List<ServiceRepair> serv = new ArrayList();
        
        List<Status> status = new ArrayList();
        
        for(Device d: dv)
        {
            ServiceRepair sr = new ServiceRepair();
            sr = RepairDAO.checkDevice(d.getDevice_ID());
            serv.add(sr);
            
            Status st = new Status();
            st = StatusDAO.checkDevice(d.getDevice_ID());
            status.add(st);
        }
        
        request.setAttribute("device", dv);
        request.setAttribute("service", serv);
        request.setAttribute("status", status);
        request.setAttribute("set", "set");
        
        request.getRequestDispatcher("CheckDeviceStatus.jsp").forward(request, response);

    }


}
