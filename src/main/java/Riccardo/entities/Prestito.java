package Riccardo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn (name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn (name = "libri_id")
    private Libri libri;
    @ManyToOne
    @JoinColumn (name = "riviste_id")
    private Riviste riviste;
    LocalDate dataInizioPrestito;
    LocalDate dataRestituzionePrevista;
    LocalDate dataRestituzioneEffettiva;

    // COSTRUTTORE
    public Prestito(Utente utente, Libri libri, Riviste riviste, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.libri = libri;
        this.riviste = riviste;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
    public Prestito(){

    }

    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libri getLibri() {
        return libri;
    }

    public void setLibri(Libri libri) {
        this.libri = libri;
    }

    public Riviste getRiviste() {
        return riviste;
    }

    public void setRiviste(Riviste riviste) {
        this.riviste = riviste;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", libri=" + libri +
                ", riviste=" + riviste +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

