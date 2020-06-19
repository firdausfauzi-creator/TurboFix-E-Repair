
package DAO;

import Class.Status;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;


public class StatusDAO 
{
    public static void addStatus(String date, int repairID)
    {
        int statusID = 300;
        
        Connection con = null;
        try
        {
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from status order by status_id").executeQuery();
            int count =0;
            while(x.next())
            {
                statusID = x.getInt("status_id");
                count++;
            }
            if(count!=0)
            {
                statusID += 1;
            }
            
            con.prepareStatement("insert into status(status_id, servicestatus, laststatusupdate, repair_id) "
                    + "Values ('"+statusID+"', 'Pending','"+date+"','"+repairID+"')").executeQuery();
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void updateStatus(String date, int repairID, String status)
    {
        int statusID = 300;
        Connection con = null;
        try
        {
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from status order by status_id").executeQuery();
            int count =0;
            while(x.next())
            {
                statusID = x.getInt("status_id");
                count++;
            }
            if(count!=0)
            {
                statusID += 1;
            }
            
            ResultSet aa = con.prepareStatement("insert into status(status_id, servicestatus, laststatusupdate, repair_id) "
                    + "Values ('"+statusID+"', '"+status+"','"+date+"','"+repairID+"')").executeQuery();
            
            aa.next();
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static List<Status> view(int deviceID)
    {
        List<Status> a = new ArrayList();
       
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select repair_id from service_repair where  device_id ='"+deviceID+"' order by repair_id").executeQuery();
            
            while(x.next())
            {   Status b = new Status();
                ResultSet y = con.prepareStatement("select servicestatus from status where repair_id = '"+x.getInt(1)+"' order by repair_id desc").executeQuery();
                y.next();
                b.setRepair_ID(x.getInt(1));
                b.setServiceStatus(y.getString(1));
                
                a.add(b);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return a;
    }
    
    public static String getStatus(int repairID)
    {
        String st = "";
        Connection con = null;
        try
        {
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select servicestatus from status where repair_id = '"+repairID+"' order by status_id").executeQuery();
            
            while(x.next())
            {   
                st = x.getString(1);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
    
    public static List<Status> viewAll()
    {
        List<Status> a = new ArrayList();
       
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select repair_id from status group by repair_id order by repair_id").executeQuery();
            
            while(x.next())
            {   
                String status = "";
                Status b = new Status();
                ResultSet y = con.prepareStatement("select * from status where repair_id ='"+x.getString(1)+"' order by status_id").executeQuery();
                while(y.next())
                {
                    status = y.getString("servicestatus");
                }
                
                b.setRepair_ID(x.getInt("repair_id"));
                b.setServiceStatus(status);

                a.add(b);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return a;
    }
    
    public static Status checkDevice(int deviceID)
    {  
        Status b = new Status();     
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select max(repair_id) from service_repair where  device_id ='"+deviceID+"' order by repair_id").executeQuery();
            
            if(x.next())
            {   
                String status = "";
                String date = "";
                ResultSet y = con.prepareStatement("select servicestatus, laststatusupdate from status where repair_id = '"+x.getInt(1)+"' order by status_id").executeQuery();
                
                while(y.next())
                {
                    status = y.getString(1);
                    date = y.getString(2);
                }
                b.setRepair_ID(x.getInt(1));
                b.setServiceStatus(status);
                b.setLastStatusUpdate(date);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return b;
    }
}
