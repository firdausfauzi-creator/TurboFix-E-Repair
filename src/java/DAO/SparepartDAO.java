
package DAO;

import Class.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class SparepartDAO 
{
    public static void update(String spare, int repairID)
    {
        Connection con = null;
        try
        {
            String [] s = spare.split(",");
            con = DB.getCon();
            for(int i = 0; i<s.length; i++)
            {
                ResultSet x = con.prepareStatement("select * from sparepart_list where repair_id is null and sparepartname = '"+s[i]+"'").executeQuery();
                if(x.next())
                {
                    int id = x.getInt("sparepart_id");
                    con.prepareStatement("update sparepart_list set repair_id = '"+repairID+"' where sparepart_id = '"+id+"'").executeQuery();
                }
                
            }
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static List<Sparepart> view(int deviceID)
    {
        List<Sparepart> a = new ArrayList();
        
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select repair_id from service_repair where  device_id ='"+deviceID+"' order by repair_id").executeQuery();
            while(x.next())
            {
                Sparepart b = new Sparepart();
                String sn = "";
                ResultSet y = con.prepareStatement("select sparepartname from sparepart_list where repair_id = '"+x.getInt(1)+"' order by repair_id").executeQuery();
                while(y.next())
                {
                    sn += y.getString(1)+", ";
                }
                b.setSparepartname(sn);
                b.setRepair_id(x.getInt(1));
                a.add(b);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return a;
    }
    
    public static String getSparepart(int repairID)
    {
        String sp = "";
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select sparepartname from sparepart_list where repair_id ='"+repairID+"'").executeQuery();
            while(x.next())
            {
                sp += x.getString(1)+", ";
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return sp;
    }
    
    public static List<Sparepart> viewAll()
    {
        List<Sparepart> a = new ArrayList();
        Connection con = null;
        try
        {
            con = DB.getCon();
            
            ResultSet x = con.prepareStatement("select repair_id from service_repair order by repair_id").executeQuery();
            while(x.next())
            {
                Sparepart b = new Sparepart();
                String sn = "";
                ResultSet y = con.prepareStatement("select sparepartname from sparepart_list where repair_id = '"+x.getInt(1)+"' order by repair_id").executeQuery();
                while(y.next())
                {
                    sn += y.getString(1)+", ";
                }
                b.setSparepartname(sn);
                b.setRepair_id(x.getInt(1));
                a.add(b);
            }       
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return a;
    }
    
    public static double getPrice(String spare)
    {
        double price = 0.0;
        Connection con = null;
        try
        {
            String [] s = spare.split(",");
            con = DB.getCon();
            for(int i = 0; i<s.length; i++)
            {
                ResultSet x = con.prepareStatement("select * from sparepart_list where repair_id is null and sparepartname = '"+s[i]+"'").executeQuery();
                if(x.next())
                {
                    price += x.getDouble("sparepartprice");
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return price;
    }
}
