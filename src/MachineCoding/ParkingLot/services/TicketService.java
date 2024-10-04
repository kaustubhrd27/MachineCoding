package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.exceptions.GateNotFoundException;
import MachineCoding.ParkingLot.factories.ParkingSpotAssignmentStratergyFactory;
import MachineCoding.ParkingLot.models.*;
import MachineCoding.ParkingLot.repositories.GateRepository;
import MachineCoding.ParkingLot.repositories.ParkingLotRepository;
import MachineCoding.ParkingLot.repositories.TicketRepository;
import MachineCoding.ParkingLot.repositories.VehicleRepository;
import MachineCoding.ParkingLot.stratergies.ParkingSpotAssignementStratergy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository,
                         ParkingLotRepository parkingLotRepository,
                         VehicleRepository vehicleRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository  = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId,
                              String vehicleNumber,
                              String vehicleOwnerName,
                              VehicleType vehicleType) throws GateNotFoundException {

        /*
        1. get the gate object from gateId
        2. check if the vehicle with the given number is already present in the datbase
        3. if yes ,proceed. I not, save the vehicle in the DB
        4. Assign the parking Spot
        5. Create the Ticket object;
        */

        Optional<Gate> optionalGate = gateRepository.findGateByID(gateId);
        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate with id : "+gateId+" doesn't exist");
        }

        Gate gate = optionalGate.get();

        Operator operator = optionalGate.get().getOperator();      //NPE

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        //Get the vehicle
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle = null;
        if (optionalVehicle.isEmpty()) {
            //now as vehicle is not available in database we should create the vehicle and should save it to the database
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(vehicleOwnerName);
            savedVehicle = vehicleRepository.save(vehicle);

        } else {
            savedVehicle = optionalVehicle.get();
        }


        Optional<ParkingLot> parkingLot = parkingLotRepository.findParkingLotById(gateId);

        if (parkingLot.isEmpty()) {
            throw new RuntimeException("Invalid parking lot");
        }

        ParkingLot parkingLot1 = parkingLot.get();

        ParkingSpotAssignmentStratergyType stratergyType = parkingLot1.getParkingSpotAssignmentStratergyType();

        ParkingSpotAssignementStratergy assignementStratergy =
                ParkingSpotAssignmentStratergyFactory.getParkingSpotAssignementStratergy(stratergyType);


        ParkingSpot parkingSpot = assignementStratergy.assignParkingSpot(gate, savedVehicle);
        ticket.setVehicle(savedVehicle);
        ticket.setPaekinhSpot(parkingSpot);



        return ticketRepository.save(ticket);



    }
}
