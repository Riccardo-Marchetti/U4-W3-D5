package Riccardo.dao;

import Riccardo.entities.Prestito;
import Riccardo.entities.Riviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaPrestito(Prestito prestito){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(prestito);

        transaction.commit();
        System.out.println("Prestito: " + prestito + " salvato correttamente");
    }
    public List<Prestito> prestitiScadutiNonRestituiti(){
        TypedQuery<Prestito> query =  em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL OR p.dataRestituzionePrevista < p.dataRestituzioneEffettiva", Prestito.class);
        return query.getResultList();
    }
}
