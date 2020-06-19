/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import DAO.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class test {
    
    
    
    public static void main(String[] args)
    {
        Connection con = null;
         String result = "";
        int a = 0;
        
        try
        {
            con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("insert into CUSTOMER (CUSTOMER_IC, NAME, PHONENUMBER, EMAIL, ADDRESS) values(?,?,?,?,?)");
            ps.setInt(1, 324);
            ps.setString(2,"Firdaus Bin Fauzi");
            ps.setString(3, "109194799");
            ps.setString(4, "firdausfauzi.f11@gmail.com");
            ps.setString(5, "W1/213 JALAN PASIR PEKAN");
            
            
            a = ps.executeUpdate();
           
            if(a==1)
            {
                System.out.print("jadi");
            }
            else
                System.out.print("tak jadi");
            
            con.close();
            
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
