package Riccardo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalogo {
    // ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany (mappedBy = "catalogo")
    private List<Libri> libri;
    @OneToMany (mappedBy = "catalogo")
    private List<Riviste> riviste;

    // COSTRUTTORE
    public Catalogo() {
        this.libri = new ArrayList<>();
        this.riviste = new ArrayList<>();
    }
//    public Catalogo(){
//
//    }

    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public List<Libri> getLibri() {
        return libri;
    }

    public void setLibri(List<Libri> libri) {
        this.libri = libri;
    }

    public List<Riviste> getRiviste() {
        return riviste;
    }

    public void setRiviste(List<Riviste> riviste) {
        this.riviste = riviste;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", libri=" + libri +
                ", riviste=" + riviste +
                '}';
    }
}
