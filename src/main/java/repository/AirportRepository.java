package repository;
import entity.Airport;
import base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Airport Repository
 */
public interface AirportRepository extends BaseJpaRepository <Airport, Long> {

    @Query(value = "select * from AIRPORT where name like %?1%", nativeQuery = true)
    Page< Airport > findAirportByName(String name, Pageable pageable);

    Airport findByCode(String code);

}
