package Riccardo.dao;

import Riccardo.entities.Prestito;
import Riccardo.entities.Riviste;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
