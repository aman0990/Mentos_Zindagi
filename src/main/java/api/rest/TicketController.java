package api.rest;
import apt.web.util.web.BaseResponse;
import dto.CreateTicketRequestDto;
import dto.CreateTicketResponseDto;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.TicketService;
import viewobject.CreateTicketRequest;
import viewobject.CreateTicketResponse;
import viewobject.SearchTicketRequest;
import viewobject.SearchTicketResponse;

/**
 * {@link TicketController}
 */

@RestController
@RequestMapping(value = "/ticket")
@Scope("singleton")
@Api(value = "/ticket", description = "Ticket Controller")
public class TicketController {

    private final TicketService ticketService;

    Mapper dozerBeanMapper = new DozerBeanMapper();

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse< CreateTicketResponse >> buy(@RequestBody CreateTicketRequest createTicketRequest) throws Exception {
        CreateTicketRequestDto createTicketRequestDto = dozerBeanMapper.map(createTicketRequest, CreateTicketRequestDto.class);
        CreateTicketResponseDto createTicketResponseDto = ticketService.buyTicket(createTicketRequestDto);
        CreateTicketResponse createRouteResponse = dozerBeanMapper.map(createTicketResponseDto, CreateTicketResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createRouteResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse< SearchTicketResponse >> search(@RequestBody SearchTicketRequest searchticketRequest) {
        SearchTicketResponse searchResultTicketResponse = ticketService.searchTicket(searchticketRequest);
        return ResponseEntity.ok(new BaseResponse <>(searchResultTicketResponse));
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<String>> cancel(@RequestBody Long ticketNumber) {
        String status = ticketService.cancel(ticketNumber);
        return ResponseEntity.ok(new BaseResponse<>(status));

    }

}