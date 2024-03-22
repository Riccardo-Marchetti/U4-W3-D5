package Riccardo.entities;

import jakarta.persistence.*;

@Entity
public class Libri {
    // ATTRIBUTI
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String autore;
    private String genere;
    @ManyToOne
    @JoinColumn (name = "catalogo_id")
    private Catalogo catalogo;

    // COSTRUTTORE
    public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere, Catalogo catalogo) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
        this.catalogo = catalogo;
    }
    public Libri(){

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

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
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
        return "Libri{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }
}
