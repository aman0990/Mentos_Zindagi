package repository;
import entity.AirlineCompany;
import entity.Flight;
import base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Flight Repository
 */
public interface FlightRepository extends BaseJpaRepository <Flight, Long> {

    Page< Flight > findAllByAirlineCompany(AirlineCompany airlineCompany, Pageable pageable);

    Flight findByFlightCode(String code);

}
