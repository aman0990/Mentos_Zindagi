package repository;
import entity.Passenger;
import base.BaseJpaRepository;

/**
 * PassengerDto Repository
 */
public interface PassengerRepository extends BaseJpaRepository <Passenger, Long> {

    Passenger findByIdentityNumber(Long identityNumber);

}
