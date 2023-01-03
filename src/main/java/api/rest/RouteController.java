package api.rest;

import apt.web.util.web.BaseResponse;
import dto.CreateRouteRequestDto;
import dto.CreateRouteResponseDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.RouteService;
import viewobject.CreateRouteRequest;
import viewobject.CreateRouteResponse;
import viewobject.PageResult;
import viewobject.SearchRouteRequest;


 /* {@link RouteController}
 */

@RestController
@RequestMapping(value = "/route")
@Scope("singleton")
@Api(value = "/route", description = "Route Controller")
public class RouteController {

    private final RouteService routeService;

    Mapper dozerBeanMapper = new DozerBeanMapper();
    private Object MediaType;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = "MediaType.APPLICATION_JSON", produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<CreateRouteResponse>>create(@RequestBody CreateRouteRequest createRouteRequest) {
        CreateRouteRequestDto createRouteRequestDto = dozerBeanMapper.map(createRouteRequest, CreateRouteRequestDto.class);
        CreateRouteResponseDto createRouteResponseDto = routeService.createRoute(createRouteRequestDto);
        CreateRouteResponse createRouteResponse = dozerBeanMapper.map(createRouteResponseDto, CreateRouteResponse.class);
        return ResponseEntity.ok(new BaseResponse<>(createRouteResponse));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "MediaType.APPLICATION_JSON", produces = "application/json;encoding=utf-8")
    public ResponseEntity<BaseResponse<PageResult>> search(@RequestBody SearchRouteRequest searchRouteRequest) {
        PageResult searchResultTicketResponse = routeService.searchRoute(searchRouteRequest);
        return ResponseEntity.ok(new BaseResponse <>(searchResultTicketResponse));

    }

}