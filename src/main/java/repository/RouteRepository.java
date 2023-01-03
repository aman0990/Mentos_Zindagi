package repository;
import entity.Route;
import base.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Route Repository
 */
public interface RouteRepository extends BaseJpaRepository <Route, Long> {

    Page< Route > findByRouteCode(String code, Pageable pageable);
    Route findByRouteCode(String code);

}