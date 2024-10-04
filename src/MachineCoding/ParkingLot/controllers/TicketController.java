package MachineCoding.ParkingLot.controllers;

import MachineCoding.ParkingLot.dtos.IssueTicketRequestDto;
import MachineCoding.ParkingLot.dtos.IssueTicketResponseDto;
import MachineCoding.ParkingLot.dtos.ResponseStatus;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
       try {
           Ticket ticket = ticketService.issueTicket(
                   issueTicketRequestDto.getGateId(),
                   issueTicketRequestDto.getVehicleNumber(),
                   issueTicketRequestDto.getOwnerName(),
                   issueTicketRequestDto.getVehicleType());

           issueTicketResponseDto.setTicket(ticket);
           issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
       }
       catch (Exception e) {
           issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
       }


        return null;
    }
}
