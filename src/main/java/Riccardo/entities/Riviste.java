package Riccardo.entities;

import Riccardo.enums.Periodicita;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Riviste {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
    @OneToMany(mappedBy = "riviste")
    private List<Prestito> prestiti;

    // COSTRUTTORE
    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita, List<Prestito> prestiti) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
        this.prestiti = prestiti;
    }

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
    }

    public Riviste(){

    }

    // GETTER E SETTER
    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Riviste{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita=" + periodicita +
//                ", prestiti=" + prestiti +
                '}';
    }
}
