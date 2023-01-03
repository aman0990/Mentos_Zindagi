package dto;

import lombok.Data;

@Data
public class CreateAirportResponseDto {
    private Long airportId;
    private String name;
    private String city;
    private String country;
}