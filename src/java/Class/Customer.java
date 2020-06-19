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
public class Customer {
    private String Name, Email, Address, PhoneNumber;
    private long Customer_ic;

    public Customer(long Customer_ic, String Name, String PhoneNumber, String Email, String Address) {
        this.Customer_ic = Customer_ic;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Address = Address;
    }

    public Customer() {
        
    }

    public long getCustomer_ic() {
        return Customer_ic;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setCustomer_ic(long Customer_ic) {
        this.Customer_ic = Customer_ic;
    }

    
    
   
}
