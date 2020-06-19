
package DAO;

import Class.Customer;
import Class.Device;
import Class.ServiceRepair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class RepairDAO 
{
    public static int addRepair(String serviceType,String date,String problemdetails,String custID,int deviceID,double price, String spare)
    {
        int repairID = 200; 
        Connection con = null;
        try
        {
            
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from service_repair order by repair_id").executeQuery();
            int count =0;
            while(x.next())
            {
                repairID = x.getInt("repair_id");
                count++;
            }
            if(count!=0)
            {
                repairID += 1;
            }
            ResultSet k = con.prepareStatement("insert into service_repair(repair_id, servicetype, datesubmit, problemdetails, customer_ic, device_id, repair_price, frontdesk_id, tech_id) "
                                                  + "values ('"+repairID+"','"+serviceType+"','"+date+"','"+problemdetails+"','"+Long.parseLong(custID)+"','"+deviceID+"','"+price+"', 5001, 6001)").executeQuery();
            k.next();
            String [] s = spare.split(",");
            for(int i = 0; i<s.length; i++)
            {
                ResultSet t = con.prepareStatement("select service_id from service_list where servicename = '"+s[i]+"'").executeQuery();
                if(t.next())
                {
                    con.prepareStatement("insert into service (service_id, repair_id) values ('"+t.getInt(1)+"','"+repairID+"')").executeQuery();
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return repairID;
    }
    
    public static List <ServiceRepair> view(int deviceID)
    {
        
        List lst = new ArrayList();
        Connection con = null;
        try
        { 
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from service_repair  where device_id = '"+deviceID+"' order by repair_id").executeQuery();
        
            while(x.next())
            {
                ServiceRepair sr = new ServiceRepair();
                sr.setRepair_ID(x.getString("repair_id"));
                sr.setProblemDetails(x.getString("problemdetails"));
                sr.setDateSubmit(x.getString("datesubmit"));
                sr.setServiceType(x.getString("servicetype"));
                sr.setServiceRepairPrice(x.getDouble("repair_price"));
                
                lst.add(sr);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return lst;
    }
    
    public static List <ServiceRepair> viewAll()
    {
        
        List lst = new ArrayList();
        Connection con = null;
        try
        { 
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from service_repair order by repair_id").executeQuery();
        
            while(x.next())
            {
                ServiceRepair sr = new ServiceRepair();
                sr.setRepair_ID(x.getString("repair_id"));
                sr.setProblemDetails(x.getString("problemdetails"));
                sr.setDateSubmit(x.getString("datesubmit"));
                sr.setServiceType(x.getString("servicetype"));
                sr.setServiceRepairPrice(x.getDouble("repair_price"));
                sr.setDeviceID(x.getInt("device_id"));
                
                lst.add(sr);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        return lst;
    }
    
    public static List <ServiceRepair> getDetails(int repairID)
    {
        
        List lst = new ArrayList();
        Connection con = null;
        try
        { 
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from service_repair where repair_id = '"+repairID+"'").executeQuery();
        
            if(x.next())
            {
                ServiceRepair sr = new ServiceRepair();
                sr.setRepair_ID(x.getString("repair_id"));
                sr.setProblemDetails(x.getString("problemdetails"));
                sr.setDateSubmit(x.getString("datesubmit"));
                sr.setServiceType(x.getString("servicetype"));
                sr.setServiceRepairPrice(x.getDouble("repair_price"));
                sr.setDeviceID(x.getInt("device_id"));
                
                lst.add(sr);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        return lst;
    }
    
    public static ServiceRepair checkDevice(int deviceID)
    {
        ServiceRepair sr = new ServiceRepair();
        Connection con = null;
        try
        { 
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select max(repair_id) from service_repair  where device_id = '"+deviceID+"'").executeQuery();
        
            if(x.next())
            {
                ResultSet y = con.prepareStatement("select repair_id, repair_price from service_repair  where repair_id = '"+x.getString(1)+"'").executeQuery();
                y.next();
                
                sr.setRepair_ID(y.getString("repair_id"));
                sr.setServiceRepairPrice(y.getDouble("repair_price"));
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return sr;
    }
}
