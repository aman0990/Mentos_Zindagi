package repository;

import entity.Ticket;
import base.BaseJpaRepository;

public interface TicketRepository extends BaseJpaRepository <Ticket, Long> {

    Ticket findByNumber(Long name);

}
