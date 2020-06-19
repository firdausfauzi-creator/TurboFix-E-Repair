
package DAO;

import Class.Staff;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class StaffDAO 
{
    public static String login(Long ID, String password)
    {
        String role = "";
        try
        {
            Connection con = DB.getCon();
            String testString= password;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(testString.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String newPassword = number.toString(16);
            
            PreparedStatement ps = con.prepareStatement("select * from STAFF where STAFF_ID ='"+ID+"'and PASSWORD ='"+newPassword+"' ");
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            role = rs.getString("ROLE");
            
            
        }catch(Exception e){System.out.println(e);}
        return role;
    }
}
