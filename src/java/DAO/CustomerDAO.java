
package DAO;

import Class.Customer;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.FileNotFoundException;
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
public class CustomerDAO 
{
    public static int createCustomer(Customer cust)
    {
        Connection con = null;
         String result = "";
        int a = 0;
        
        try
        {
            con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("insert into CUSTOMER (CUSTOMER_IC, NAME, PHONENUMBER, EMAIL, ADDRESS) values(?,?,?,?,?)");
            ps.setLong(1, cust.getCustomer_ic());
            ps.setString(2,cust.getName());
            ps.setString(3, cust.getPhoneNumber());
            ps.setString(4, cust.getEmail());
            ps.setString(5, cust.getAddress());
            
            
            a = ps.executeUpdate();
            
            if(a==1)
            {
                result = "Success";
            }
            else
                result = "unsuccess";
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return a;
    }        
    
    public static List<Customer> view()
    { 
        List<Customer> list = new ArrayList<Customer>();
        try
        {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from CUSTOMER");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Customer cust = new Customer();
                cust.setCustomer_ic(rs.getLong("CUSTOMER_IC"));
                cust.setName(rs.getString("NAME"));
                cust.setPhoneNumber(rs.getString("PHONENUMBER"));
                cust.setEmail(rs.getString("EMAIL"));
                cust.setAddress(rs.getString("ADDRESS"));
                
                list.add(cust);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
    public static void updateData(long CustomerIC, String Name, String PhoneNumber, String Email, String Address)
    {
        
    
        try
        {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("update CUSTOMER set NAME =?, PHONENUMBER=?, EMAIL=?, ADDRESS=? where CUSTOMER_IC =?");
            ps.setString(1,Name);
            ps.setString(2, PhoneNumber);
            ps.setString(3,Email);
            ps.setString(4,Address);
            ps.setLong(5, CustomerIC);
         
            ps.executeUpdate();
            con.close();
            
        }catch(Exception e){System.out.println(e.getMessage());}
		
      
    }
    
    public static Customer viewByIC(long CustomerIC)
    { 
        Customer cust = new Customer();
        try
        {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from CUSTOMER where CUSTOMER_IC ='"+CustomerIC+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {

                cust.setCustomer_ic(rs.getLong("CUSTOMER_IC"));
                cust.setName(rs.getString("NAME"));
                cust.setPhoneNumber(rs.getString("PHONENUMBER"));
                cust.setEmail(rs.getString("EMAIL"));
                cust.setAddress(rs.getString("ADDRESS"));
                
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return cust;
    }
   
}
