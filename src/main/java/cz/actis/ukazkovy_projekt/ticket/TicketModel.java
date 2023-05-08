package cz.actis.ukazkovy_projekt.ticket;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tickety")
public class TicketModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "predmet")
    private String predmet;

    @Column(name = "popis")
    private String popis;

    @Column(name = "je_vyrizen")
    private boolean jeVyrizen;

    @Column(name = "datum_vytvoreni")
    private LocalDateTime datumVytvoreni;

    public TicketModel() {
        datumVytvoreni = LocalDateTime.now();
    }

    public TicketModel(String predmet, String popis, boolean jeVyrizen, LocalDateTime datumVytvoreni) {
        this.predmet = predmet;
        this.popis = popis;
        this.jeVyrizen = jeVyrizen;
        this.datumVytvoreni = Objects.requireNonNullElseGet(datumVytvoreni, LocalDateTime::now);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean isJeVyrizen() {
        return jeVyrizen;
    }

    public void setJeVyrizen(boolean jeVyrizen) {
        this.jeVyrizen = jeVyrizen;
    }

    public LocalDateTime getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(LocalDateTime datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }
}
