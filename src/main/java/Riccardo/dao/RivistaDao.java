package Riccardo.dao;

import Riccardo.entities.Libri;
import Riccardo.entities.Riviste;
import Riccardo.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

}
