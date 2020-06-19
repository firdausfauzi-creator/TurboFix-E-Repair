
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceDAO {
        
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
                ResultSet x = con.prepareStatement("select * from service_list where servicename = '"+s[i]+"'").executeQuery();
                if(x.next())
                {
                    price += x.getDouble("serviceprice");
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
