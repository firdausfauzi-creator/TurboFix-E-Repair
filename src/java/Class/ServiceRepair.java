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
public class ServiceRepair 
{
    private String Repair_ID, ServiceType, DateSubmit, ProblemDetails, SparePart;
    private int CustomerIC, DeviceID;
    private double ServiceRepairPrice;
    
    public ServiceRepair(String Repair_ID, String ServiceType, String DateSubmit, String ProblemDetails, double ServiceRepairPrice, String SparePart, int CustomerIC, int DeviceID) {
        this.Repair_ID = Repair_ID;
        this.ServiceType = ServiceType;
        this.DateSubmit = DateSubmit;
        this.ProblemDetails = ProblemDetails;
        this.ServiceRepairPrice = ServiceRepairPrice;
        this.SparePart = SparePart;
        this.CustomerIC = CustomerIC;
        this.DeviceID = DeviceID;
    }
    
    public ServiceRepair()
    {
        
    }
    
    public String getRepair_ID() {
        return Repair_ID;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public String getDateSubmit() {
        return DateSubmit;
    }

    public String getProblemDetails() {
        return ProblemDetails;
    }

    public double getServiceRepairPrice() {
        return ServiceRepairPrice;
    }

    public String getSparePart() {
        return SparePart;
    }

    public int getCustomerIC() {
        return CustomerIC;
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setRepair_ID(String Repair_ID) {
        this.Repair_ID = Repair_ID;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public void setDateSubmit(String DateSubmit) {
        this.DateSubmit = DateSubmit;
    }

    public void setProblemDetails(String ProblemDetails) {
        this.ProblemDetails = ProblemDetails;
    }

    public void setServiceRepairPrice(double ServiceRepairPrice) {
        this.ServiceRepairPrice = ServiceRepairPrice;
    }

    public void setSparePart(String SparePart) {
        this.SparePart = SparePart;
    }

    public void setCustomerIC(int CustomerIC) {
        this.CustomerIC = CustomerIC;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    
}
