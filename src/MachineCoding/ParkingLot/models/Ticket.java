package MachineCoding.ParkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel {
    private Gate gate;
    private ParkingSpot paekingSpot;
    private Vehicle vehicle;
    private Date entryTime;

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public ParkingSpot getPaekinhSpot() {
        return paekingSpot;
    }

    public void setPaekinhSpot(ParkingSpot paekinhSpot) {
        this.paekingSpot = paekinhSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
}
