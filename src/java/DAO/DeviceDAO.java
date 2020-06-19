/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Class.Device;
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
public class DeviceDAO 
{
    public static int addDevice(String brand, String model, String color)
    {
        int DeviceID=100;int count =0;
        Connection con = null;
        try
        {
            con = DB.getCon();
            ResultSet x = con.prepareStatement("select * from DEVICE order by device_id").executeQuery();
            
            while(x.next())
            {
                DeviceID = x.getInt("DEVICE_ID");
                count++;
            }
            if(count!=0)
            {
                DeviceID = DeviceID +1;
            }
           
            ResultSet aa = con.prepareStatement("insert into DEVICE(DEVICE_ID, DEVICEBRAND, DEVICEMODEL, COLOR) "
                    + "Values ('"+DeviceID+"','"+brand+"','"+model+"','"+color+"')").executeQuery();
            aa.next();
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return DeviceID;
    }
    
    public static List<Device> view(long ic)
    { 
        List<Device> list = new ArrayList<Device>();
        try
        {
            Connection con = DB.getCon();
            ResultSet rs =con.prepareStatement("select DEVICE_ID from service_repair where customer_ic ='"+ic+"' group by device_id").executeQuery();
            
            while(rs.next())
            {
                ResultSet r =con.prepareStatement("select devicebrand, devicemodel from device where device_id ='"+rs.getInt(1)+"'").executeQuery();
                r.next();
                Device dev = new Device();
                dev.setDevice_ID(rs.getInt("DEVICE_ID"));
                dev.setDeviceBrand(r.getString("DEVICEBRAND"));
                dev.setDeviceModel(r.getString("DEVICEMODEL"));

                list.add(dev);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
    
    public static List<Device> viewAll()
    { 
        List<Device> list = new ArrayList<Device>();
        try
        {
            Connection con = DB.getCon();
            ResultSet rs =con.prepareStatement("select * from device").executeQuery();
            
            while(rs.next())
            {
                Device dev = new Device();
                dev.setDevice_ID(rs.getInt("DEVICE_ID"));
                dev.setDeviceBrand(rs.getString("DEVICEBRAND"));
                dev.setDeviceModel(rs.getString("DEVICEMODEL"));

                list.add(dev);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
    
    public static String getDetails(int deviceID)
    {
        String ss = "";
        try
        {
            Connection con = DB.getCon();
            ResultSet rs = con.prepareStatement("select d.devicebrand, d.devicemodel, d.color, s.customer_ic "
                    + "from device d, service_repair s where d.DEVICE_ID = '"+deviceID+"' and s.DEVICE_ID = '"+deviceID+"'").executeQuery();
            
            if(rs.next())
            {
                ss = rs.getString(1)+",";
                ss += rs.getString(2)+",";
                ss += rs.getString(3)+",";
                ss += rs.getLong(4);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return ss;
    }
    
    public static String getDeviceID(int repairID)
    {
        String ss = "";
        try
        {
            Connection con = DB.getCon();
            ResultSet rs = con.prepareStatement("select device_id from service_repair where repair_id = '"+repairID+"'").executeQuery();
            
            if(rs.next())
            {
                ss = rs.getString(1);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        return ss;
    }
    
    public static String name(long ic)
    { 
        String name =null;
        try
        {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select name from CUSTOMER where CUSTOMER_IC = '"+ic+"'");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
             name= rs.getString(1);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return name;
    }
}
