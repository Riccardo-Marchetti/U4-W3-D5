package Riccardo.dao;

import Riccardo.entities.Riviste;
import Riccardo.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaUtente(Utente utente){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(utente);

        transaction.commit();
        System.out.println("Utente: " + utente + " salvato correttamente");
    }
}
