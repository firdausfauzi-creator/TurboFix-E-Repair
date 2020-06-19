
package Class;

public class Status {
    private String Status_ID, ServiceStatus,LastStatusUpdate;
    private int repair_ID;

    public Status(String Status_ID, String ServiceStatus, String LastStatusUpdate, int repair_ID) {
        this.Status_ID = Status_ID;
        this.ServiceStatus = ServiceStatus;
        this.LastStatusUpdate = LastStatusUpdate;
        this.repair_ID = repair_ID;
    }

    public void setRepair_ID(int repair_ID) {
        this.repair_ID = repair_ID;
    }

    public int getRepair_ID() {
        return repair_ID;
    }

   

    public Status() {
    }

    public String getStatus_ID() {
        return Status_ID;
    }

    public String getServiceStatus() {
        return ServiceStatus;
    }

    public String getLastStatusUpdate() {
        return LastStatusUpdate;
    }

    public void setStatus_ID(String Status_ID) {
        this.Status_ID = Status_ID;
    }

    public void setServiceStatus(String ServiceStatus) {
        this.ServiceStatus = ServiceStatus;
    }

    public void setLastStatusUpdate(String LastStatusUpdate) {
        this.LastStatusUpdate = LastStatusUpdate;
    }
    
    
}
