package MachineCoding.ParkingLot.factories;

import MachineCoding.ParkingLot.models.ParkingSpotAssignmentStratergyType;
import MachineCoding.ParkingLot.stratergies.NearestParkingSpotAssignment;
import MachineCoding.ParkingLot.stratergies.ParkingSpotAssignementStratergy;
import MachineCoding.ParkingLot.stratergies.RandomSpotAssignmentStratergy;

public class ParkingSpotAssignmentStratergyFactory {
    public static ParkingSpotAssignementStratergy getParkingSpotAssignementStratergy(ParkingSpotAssignmentStratergyType stratergyType) {
        if (stratergyType.equals(ParkingSpotAssignmentStratergyType.NEAREST)) {
            return new NearestParkingSpotAssignment();
        }
        return new RandomSpotAssignmentStratergy();
    }
}
