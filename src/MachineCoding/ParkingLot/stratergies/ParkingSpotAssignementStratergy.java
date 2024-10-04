package MachineCoding.ParkingLot.stratergies;

import MachineCoding.ParkingLot.models.Gate;
import MachineCoding.ParkingLot.models.ParkingSpot;
import MachineCoding.ParkingLot.models.Vehicle;
import MachineCoding.ParkingLot.models.VehicleType;

public interface ParkingSpotAssignementStratergy {
    ParkingSpot assignParkingSpot(Gate gate, Vehicle vehicle);

}
