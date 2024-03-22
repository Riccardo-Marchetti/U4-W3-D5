package Riccardo.entities;

import Riccardo.enums.Periodicita;
import jakarta.persistence.*;

@Entity
public class Riviste {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
    @ManyToOne
    @JoinColumn (name = "catalogo_id")
    private Catalogo catalogo;

    // COSTRUTTORE
    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita, Catalogo catalogo) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
        this.catalogo = catalogo;
    }
    public Riviste(){

    }

    // GETTER E SETTER
    public String getCodiceISBN() {
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

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Riviste{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita=" + periodicita +
                ", catalogo=" + catalogo +
                '}';
    }
}
