package viewobject;

import lombok.Data;

@Data
public class CreateTicketRequest {
    private String flightCode;
    private String country;
    private PassengerDto passengerDto;
}
