package api.rest;
import apt.web.util.web.BaseResponse;
import dto.CreateFlightRequestDto;
import dto.CreateFlightResponseDto;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.FlightService;
import viewobject.CreateFlightRequest;
import viewobject.CreateFlightResponse;
import viewobject.PageResult;
import viewobject.SearchFlightRequest;

/**
 * {@link FlightController}
 */

@RestController
@RequestMapping(value = "/flight")
@Scope("singleton")
@Api(value = "/flight", description = "Flight Controller")
public class FlightController {

    private final FlightService flightService;

    Mapper dozerBeanMapper = new DozerBeanMapper();
    private Object MediaType;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = "MediaType.APPLICATION_JSON", produces = "application/json;encoding=utf-8")
    public ResponseEntity< BaseResponse <CreateFlightResponse> > create(@RequestBody CreateFlightRequest createFlightRequest) {
        CreateFlightRequestDto createFlightRequestDto = dozerBeanMapper.map(createFlightRequest, CreateFlightRequestDto.class);
        CreateFlightResponseDto createFlightResponseDto = flightService.createFlight(createFlightRequestDto);
        CreateFlightResponse createAirportResponse = dozerBeanMapper.map(createFlightResponseDto, CreateFlightResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createAirportResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "MediaType.APPLICATION_JSON", produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse< PageResult >> search(@RequestBody SearchFlightRequest searchFlightRequest) {
        PageResult searchResultTicketResponse = flightService.searchFlight(searchFlightRequest);
        return ResponseEntity.ok(new BaseResponse<>(searchResultTicketResponse));
    }


}