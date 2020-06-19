/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Class.*;
import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class AddRepair extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deviceID = Integer.parseInt(request.getParameter("deviceID"));
        
        String[] a = DeviceDAO.getDetails(deviceID).split(",");
        
        Device dv = new Device();
        dv.setDeviceBrand(a[0]);
        dv.setDeviceModel(a[1]);
        dv.setColor(a[2]);
        
        request.setAttribute("dv", dv);
        request.setAttribute("dID", deviceID);
        request.setAttribute("custID", a[3]);
        request.getRequestDispatcher("AddRepair.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
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
        
        String g[] = request.getParameter("ID").split(",");
        
        long custIC = Long.parseLong(g[1]);
        int deviceID = Integer.parseInt(g[0]);
        String custID = g[1];
       
        double price = 0.0;
        price += SparepartDAO.getPrice(spare);

        price += ServiceDAO.getPrice(serviceType);

        int repairID = RepairDAO.addRepair(serviceType, request.getParameter("Date"), 
        request.getParameter("ProblemDetails"), custID, 
        deviceID, price, serviceType);

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
        request.setAttribute("custIC", custIC);
        
        request.getRequestDispatcher("DisplayAddRepair.jsp").forward(request, response);
    }

}
