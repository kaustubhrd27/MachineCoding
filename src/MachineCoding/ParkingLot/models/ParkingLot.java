package MachineCoding.ParkingLot.models;

import MachineCoding.ParkingLot.stratergies.ParkingSpotAssignementStratergy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingSpotAssignementStratergy parkingSpotAssignementStratergy;
    private ParkingSpotAssignmentStratergyType parkingSpotAssignmentStratergyType;
    public ParkingSpotAssignementStratergy getParkingSpotAssignementStratergy() {
        return parkingSpotAssignementStratergy;
    }

    public void setParkingSpotAssignementStratergy(ParkingSpotAssignementStratergy parkingSpotAssignementStratergy) {
        this.parkingSpotAssignementStratergy = parkingSpotAssignementStratergy;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingSpotAssignmentStratergyType getParkingSpotAssignmentStratergyType() {
        return parkingSpotAssignmentStratergyType;
    }

    public void setParkingSpotAssignmentStratergyType(ParkingSpotAssignmentStratergyType parkingSpotAssignmentStratergyType) {
        this.parkingSpotAssignmentStratergyType = parkingSpotAssignmentStratergyType;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
