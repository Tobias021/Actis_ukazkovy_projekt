package cz.actis.ukazkovy_projekt.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {
    private final TicketService service;
    private final TicketRepository repository;

    /**
     * V konstruktoru se pomocí injekce závislostí inicializují TicketRepository a pomocná třída TicketService
     *
     * @param service    - Injected
     * @param repository - Injected
     */
    @Autowired
    public TicketController(TicketService service, TicketRepository repository) {
        this.service = service;
        this.repository = repository;
        // pokud je tabulka prázdná, naplň ji 5 testovacími záznamy
        if (repository.count() == 0) {
            service.createTestTickets();
        }
    }

    /**
     * Vypíše všechny záznamy z tabulky tickety
     *
     * @return JSON záznamů
     */
    @GetMapping("/tickety")
    public List<TicketModel> readAll() {
        return repository.findAll();
    }

    /**
     * Vypíše nevyřízené tickety
     *
     * @return List ticketů
     */
    @GetMapping("/tickety/nevyrizene")
    public List<TicketModel> readTodo() {
        return repository.findByJeVyrizen(false);
    }

    /**
     * Vypíše dokončené tickety
     *
     * @return List ticketů
     */
    @GetMapping("/tickety/vyrizene")
    public List<TicketModel> readDone() {
        return repository.findByJeVyrizen(true);
    }

    /**
     * Vypíše záznam podle zadaného ID
     *
     * @param id - PK záznamu
     * @return JSON záznamu
     */
    @GetMapping("/tickety/{id}")
    public Optional<TicketModel> readById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    /**
     * Vytvoří nový záznam ticketu do databáze
     *
     * @return id nového ticketu
     */
    @PostMapping("/tickety/novy")
    public TicketModel create(@RequestBody TicketModel model) {
        repository.save(model);
        return model;
    }

    /**
     * Smaže záznam ticketu z databáze
     *
     * @param id ticketu
     */
    @DeleteMapping("/tickety/smazat/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    /**
     * Pokud již záznam se stejným ID existuje, upraví ho podle poskytnutých dat
     *
     * @param model s novými daty
     * @return model při úspěchu, null při neexistujícím id
     */
    @PutMapping("/tickety/update")
    public TicketModel update(@RequestBody TicketModel model) {
        if (service.idExists(model.getId())) {
            repository.save(model);
            return model;
        } else {
            return null;
        }
    }
}
