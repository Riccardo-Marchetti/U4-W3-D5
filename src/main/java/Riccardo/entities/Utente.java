package Riccardo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {
    // ATTRIBUTI
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @OneToMany (mappedBy = "prestito")
    private int numeroDiTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    // COSTRUTTORE
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

    // TOSTRING
    @Override
    public String toString() {
        return "Utente{" +
                "numeroDiTessera=" + numeroDiTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
