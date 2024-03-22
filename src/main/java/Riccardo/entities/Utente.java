package Riccardo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Utente {
    // ATTRIBUTI
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int numeroDiTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    // COSTRUTTORE
    public Utente(String nome, String cognome, LocalDate dataDiNascita, List<Prestito> prestiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.prestiti = prestiti;
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Utente(){

    }

    // GETTER E SETTER
    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
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
        return "Utente{" +
                "numeroDiTessera=" + numeroDiTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
//                ", prestiti=" + prestiti +
                '}';
    }
}
