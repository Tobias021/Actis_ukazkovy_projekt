package cz.actis.ukazkovy_projekt.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketModel, Long> {
    /**
     * Metoda vyhledávající záznamy podle parametru
     *
     * @param jeVyrizen podmínka
     * @return List ticketů
     */
    List<TicketModel> findByJeVyrizen(boolean jeVyrizen);
}