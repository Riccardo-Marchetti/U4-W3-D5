package Riccardo.entities;

import jakarta.persistence.*;

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
    public Catalogo(List<Libri> libri, List<Riviste> riviste) {
        this.libri = libri;
        this.riviste = riviste;
    }
    public Catalogo(){

    }

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

    // TOSTRING

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", libri=" + libri +
                ", riviste=" + riviste +
                '}';
    }
}
