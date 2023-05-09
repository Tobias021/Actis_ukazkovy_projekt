# Actis_ukazkovy_projekt
Springboot projekt vytvořený v Javě 17, Springboot 3.0.6 a Maven. Vývojové prostředí IntelliJ IDEA.

Vytvořené API obsluhuje databázi ticketů. Ticket obsahuje ID, předmět, popis, (boolean) je_vyrizen a datum vytvoření.

Pro práci s databází a daty je použito Spring Data JPA. Knihovna zajišťuje funkci interface TicketRepository pomocí interface JpaRepository.

Endpointy vrací hodnoty v JSON.

## Konektivita databáze
Konfigurace ovladače databáze se nachází v souboru /resources/application.properties. Nachází se zde url jdbc ovladače a přihlašovací údaje databáze.   
Konfigurace dll-auto=update nastavuje chování JPA tak, že se v databázi vytváří a upravuje tabulka podle datového modelu TicketModel.


## Přehled tříd
Zde se nachází přehled tříd a jejich popis.

### TicketController
Tento RestController ovládá mapování všech endpointů:
- /tickety [get] - vypíše všechny záznamy z databáze
- /tickety/nevyrizene [get] - vypíše nevyřízené tickety
- /tickety/vyrizene [get] - vypíše vyřízené tickety
- /tickety/{id} [get] - zobrazí záznam ticketu podle "id"
- /tickety/novy [post] - vytvoří nový záznam pomocí @RequestBody
- /tickety/smazat/{id} [delete] - smaže záznam podle "id"
- /tickety/update [put] - pokud existuje "id" v databázi, updatuje ho podle @RequestBody

### TicketModel
Zde se deklarují tabulka, PK tabulky a sloupce. Je zde nastaveno chování PK pomocí @GeneratedValue. Nachází se zde dva konstruktory, jeden s parametry a druhý bez.

Dále jsou zde gettery a settery sloupců.

### TicketRepositroy
Funkčnost této repository zajišťuje JPA.  
Nachází se zde vlastní metoda findByJeVyrizen(boolean jeVyrizen), která vrací záznamy podle požadovaného stavu vyřízení.

### TicketService
Tato pomocná třída obsahuje metodu **createTestTickts**(), která zapíše předdefinované záznamy do databáze.  
metoda idExists(long id) vrací boolean podle toho, jestli záznam z daným id existuje.  
