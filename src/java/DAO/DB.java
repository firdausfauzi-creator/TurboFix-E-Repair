package DAO;
import Class.Device;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DB {
    public static Connection getCon(){
	Connection con=null;
	try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","erepair","erepair");
		
	}catch(Exception e){System.out.println(e);}
        
	return con;
    }
    

}

