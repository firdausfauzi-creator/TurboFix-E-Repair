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
public class Device {
    private String DeviceBrand, DeviceModel, Color;
    private int Device_ID;
    
    public Device(int Device_ID, String DeviceBrand, String DeviceModel, String Color) {
        this.Device_ID = Device_ID;
        this.DeviceBrand = DeviceBrand;
        this.DeviceModel = DeviceModel;
        this.Color = Color;
    }

    public Device() 
    {
        
    }

    public int getDevice_ID() {
        return Device_ID;
    }

    public String getDeviceBrand() {
        return DeviceBrand;
    }

    public String getDeviceModel() {
        return DeviceModel;
    }

    public String getColor() {
        return Color;
    }

    public void setDevice_ID(int Device_ID) {
        this.Device_ID = Device_ID;
    }

    public void setDeviceBrand(String DeviceBrand) {
        this.DeviceBrand = DeviceBrand;
    }

    public void setDeviceModel(String DeviceModel) {
        this.DeviceModel = DeviceModel;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

}
