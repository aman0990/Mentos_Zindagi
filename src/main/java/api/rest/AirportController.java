package api.rest;
import apt.web.util.web.BaseResponse;

import dto.CreateAirportRequestDto;
import dto.CreateAirportResponseDto;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.AirportService;
import viewobject.CreateAirportRequest;
import viewobject.CreateAirportResponse;
import viewobject.PageResult;
import viewobject.SearchAirportRequest;


/**
 * {@link AirportController}
 */

@RestController
@RequestMapping(value = "/airport")
@Scope("singleton")
@Api(value = "/airport", description = "Airport Controller")
public class AirportController {

    private final AirportService airportService;

    Mapper dozerBeanMapper;
    private Object MediaType;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
        dozerBeanMapper = new DozerBeanMapper();
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = "MediaType.APPLICATION_JSON", produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateAirportResponse>>create(@RequestBody CreateAirportRequest createAirportRequest) {
        CreateAirportRequestDto createAirportRequestDto = dozerBeanMapper.map(createAirportRequest, CreateAirportRequestDto.class);
        CreateAirportResponseDto createAirportResponseDto = airportService.createAirport(createAirportRequestDto);
        CreateAirportResponse createAirportResponse = dozerBeanMapper.map(createAirportResponseDto, CreateAirportResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createAirportResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<PageResult>> search(@RequestBody SearchAirportRequest searchAirportRequest) {
        PageResult searchResultAirportResponse = airportService.searchAirport(searchAirportRequest);
        return ResponseEntity.ok(new BaseResponse <>(searchResultAirportResponse));

    }

}