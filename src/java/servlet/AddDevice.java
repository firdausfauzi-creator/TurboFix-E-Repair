/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Class.Device;
import Class.ServiceRepair;
import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AddDevice extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.setAttribute("custIC", request.getParameter("custID"));
               
        request.getRequestDispatcher("AddDevice.jsp").forward(request, response);
	out.close(); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String serviceType = "";
        if(request.getParameter("Format").equals("format"))
        {
            serviceType += request.getParameter("Format")+",";
        }
        
        if(request.getParameter("Install").equals("installsoftware"))
        {
            serviceType += request.getParameter("Install")+",";
        }
        
        if(request.getParameter("Repair").equals("repair"))
        {
            serviceType += request.getParameter("Repair")+",";
        }
        String spare = "";
        if(request.getParameter("Screen").equals("screen"))
        {
            spare += request.getParameter("Screen")+",";
        }
        
        if(request.getParameter("HomeButton").equals("homebutton"))
        {
            spare += request.getParameter("HomeButton")+",";
        }
        
        if(request.getParameter("ChargingPort").equals("chargingport"))
        {
            spare += request.getParameter("ChargingPort")+",";
        }
      
        if(request.getParameter("Battery").equals("battery"))
        {
            spare += request.getParameter("Battery")+",";
        }
        
        int deviceID = DeviceDAO.addDevice(request.getParameter("Brand"), request.getParameter("Model"), request.getParameter("Color"));

        double price = 0.0;
        price += SparepartDAO.getPrice(spare);

        price += ServiceDAO.getPrice(serviceType);

        int repairID = RepairDAO.addRepair(serviceType, request.getParameter("Date"), 
        request.getParameter("ProblemDetails"), request.getParameter("custIC"), 
        deviceID, price, spare);

        StatusDAO.addStatus(request.getParameter("Date"), repairID);

        SparepartDAO.update(spare, repairID);
        
        Device dev = new Device(deviceID, request.getParameter("Brand"),request.getParameter("Model"),request.getParameter("Color"));
        ServiceRepair SR = new ServiceRepair();
        SR.setServiceType(serviceType);
        SR.setDateSubmit(request.getParameter("Date"));
        SR.setProblemDetails(request.getParameter("ProblemDetails"));
        SR.setSparePart(spare);
        SR.setServiceRepairPrice(price);
        request.setAttribute("SR",SR);
      
        request.setAttribute("dev", dev);
        request.setAttribute("custIC", request.getParameter("custIC"));
        request.getRequestDispatcher("DisplayAddDevice.jsp").forward(request, response);
	out.close(); 
    }
}
