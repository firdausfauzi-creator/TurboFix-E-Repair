/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author User
 */
public class Staff {
    
    private String Staff_Name, Password;
    private long Staff_ID;

    public Staff(Long Staff_ID, String Staff_Name, String Password) {
        this.Staff_ID = Staff_ID;
        this.Staff_Name = Staff_Name;
        this.Password = Password;
    }

    public Staff() 
    {
        
    }

    public Long getStaff_ID() {
        return Staff_ID;
    }

    public String getStaff_Name() {
        return Staff_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setStaff_ID(Long Staff_ID) {
        this.Staff_ID = Staff_ID;
    }

    public void setStaff_Name(String Staff_Name) {
        this.Staff_Name = Staff_Name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
