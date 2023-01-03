package dto;

import lombok.Data;
import lombok.ToString;
import viewobject.PassengerDto;

@Data
@ToString
public class CreateTicketRequestDto {
    private String flightCode;
    private String country;
    private PassengerDto passengerDto;
}