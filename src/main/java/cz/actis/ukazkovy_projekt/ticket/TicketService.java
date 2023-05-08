package cz.actis.ukazkovy_projekt.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TicketService {
    private final TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    /**
     * Metoda generující nedynamické záznamy v případě, že neexistuje žádný záznam.
     * Pouze pro testovací účely.
     */
    public void createTestTickets() {
        repository.save(new TicketModel("Výpadek", "Ráno v 0630 vypadl internet", false, LocalDateTime.now().minus((long) Math.pow(6, 12), ChronoUnit.MILLIS)));
        repository.save(new TicketModel("Chyba webu", "Není dostupný web, lze opravit?", true, LocalDateTime.now().minus((long) Math.pow(4, 11), ChronoUnit.MILLIS)));
        repository.save(new TicketModel("Dostupnost nové verze", "Kdy bude nová verze?", false, LocalDateTime.now().minus((long) Math.pow(7, 13), ChronoUnit.MILLIS)));
        repository.save(new TicketModel("Přehřívání serverovny", "Serverovna se přehřívá, je třeba opravit klimatizaci.", true, LocalDateTime.now().minus((long) Math.pow(4, 5), ChronoUnit.MILLIS)));
        repository.save(new TicketModel("Podpora", "Jak se prosím zapíná tiskárna?", false, LocalDateTime.now().minus((long) Math.pow(5, 9), ChronoUnit.MILLIS)));
    }

    /**
     * Ověření existence záznamu s korespondujícím id
     *
     * @param id záznamu
     * @return true = existuje / false = neexistuje
     */
    public boolean idExists(long id) {
        return repository.findById(id).isPresent();
    }

}
