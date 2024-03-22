package Riccardo.dao;

import Riccardo.entities.Libri;
import Riccardo.entities.Riviste;
import Riccardo.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RivistaDao {
    private final EntityManager em;

    public RivistaDao(EntityManager em) {
        this.em = em;
    }

    public void salvaRivista(Riviste rivista){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(rivista);

        transaction.commit();
        System.out.println("Rivista: " + rivista + " salvata correttamente");
    }

    public Riviste getRivistaByISBN(long isbn){
        Riviste rivista = em.find(Riviste.class, isbn);
        if (rivista == null) throw new NotFoundException(isbn);
        return rivista;
    }
    public void rimuoviRivista(long isbn){
        Riviste found = this.getRivistaByISBN(isbn);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);

        transaction.commit();
        System.out.println("Rivista: " + found.getCodiceISBN() + " eliminata correttamente");
    }
    public List<Riviste> ricercaRivistaISBN(long codiceISBN){
        TypedQuery<Riviste> query = em.createQuery("SELECT r FROM Riviste r WHERE r.codiceISBN = :codiceISBN", Riviste.class);
        query.setParameter("codiceISBN", codiceISBN);
        return query.getResultList();
    }
    public List<Riviste> ricercaRivistaAnnoPubblicazione(int annoPubblicazione){
        TypedQuery<Riviste> query = em.createQuery("SELECT r FROM Riviste r WHERE r.annoPubblicazione = :annoPubblicazione", Riviste.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }
    public List<Riviste> ricercaRivistaTitolo(String titolo){
        TypedQuery<Riviste> query = em.createQuery("SELECT r FROM Riviste r WHERE r.titolo = :titolo", Riviste.class);
        query.setParameter("titolo", titolo);
        return query.getResultList();
    }
    public List<Riviste> ricercaRivistaParteDiTitolo(String titolo){
        TypedQuery<Riviste> query = em.createQuery("SELECT r FROM Riviste r WHERE r.titolo LIKE :titolo", Riviste.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}
