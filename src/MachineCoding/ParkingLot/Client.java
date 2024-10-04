package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.controllers.TicketController;
import MachineCoding.ParkingLot.dtos.IssueTicketRequestDto;
import MachineCoding.ParkingLot.dtos.IssueTicketResponseDto;
import MachineCoding.ParkingLot.models.VehicleType;
import MachineCoding.ParkingLot.repositories.GateRepository;
import MachineCoding.ParkingLot.repositories.ParkingLotRepository;
import MachineCoding.ParkingLot.repositories.TicketRepository;
import MachineCoding.ParkingLot.repositories.VehicleRepository;
import MachineCoding.ParkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) {

        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                parkingLotRepository,
                vehicleRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123);
        requestDto.setOwnerName("Gayatri");
        requestDto.setVehicleNumber("MH44P3299");
        requestDto.setVehicleType(VehicleType.SUV);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
    }
}
