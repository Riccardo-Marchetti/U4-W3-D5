package Riccardo.dao;

import Riccardo.entities.Catalogo;
import Riccardo.entities.Libri;
import Riccardo.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Libri> ricercaLibroISBN(long codiceISBN){
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.codiceISBN = :codiceISBN", Libri.class);
        query.setParameter("codiceISBN", codiceISBN);
        return query.getResultList();
    }
    public List<Libri> ricercaLibroAnnoPubblicazione(int annoPubblicazione){
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.annoPubblicazione = :annoPubblicazione", Libri.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }
}
