package Riccardo.dao;

import Riccardo.entities.Catalogo;
import Riccardo.entities.Libri;
import Riccardo.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibroDao {
    private final EntityManager em;

    public LibroDao(EntityManager em) {
        this.em = em;
    }

    public void salvaLibro(Libri libri){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(libri);

        transaction.commit();
        System.out.println("Libro: " + libri + " salvato correttamente");
    }
    public Libri getLibroByISBN(long isbn){
        Libri libro = em.find(Libri.class, isbn);
        if (libro == null) throw new NotFoundException(isbn);
        return libro;
    }
    public void rimuoviLibro(long isbn){
        Libri found = this.getLibroByISBN(isbn);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);

        transaction.commit();
        System.out.println("Libro: " + found.getCodiceISBN() + " eliminato correttamente");
    }
}
