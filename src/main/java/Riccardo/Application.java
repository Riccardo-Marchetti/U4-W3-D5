package Riccardo;

import Riccardo.entities.Catalogo;
import Riccardo.entities.Libri;
import Riccardo.entities.Riviste;
import Riccardo.enums.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class Application {
    // ENTITY MANAGER FACTORY
//   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
    public static void main(String[] args) {
        // ENTITY MANAGER
//        EntityManager em = emf.createEntityManager();

        // CREAZIONE CATALOGO
        Catalogo catalogo = new Catalogo();

        // CREAZIONE LIBRI
        Libri libro1 = new Libri("libro1", 2020, 260, "Riccardo", "Fantasy", catalogo);
        Libri libro2 = new Libri("libro2", 2023, 300, "Antonio", "Avventura e azione", catalogo);
        Libri libro3 = new Libri("libro3", 2022, 180, "Luca", "Thriller", catalogo);
        Libri libro4 = new Libri("libro4", 2019, 320, "Fabio", "Fantascienza", catalogo);
        Libri libro5 = new Libri("libro5", 2012, 162, "Alberto", "Horror", catalogo);
        Libri libro6 = new Libri("libro6", 2015, 235, "Fabio", "Fantasy", catalogo);

        // AGGIUNTA LIBRI ALLA LISTA DEI LIBRI NEL CATALOGO
        catalogo.getLibri().add(libro1);
        catalogo.getLibri().add(libro2);
        catalogo.getLibri().add(libro3);
        catalogo.getLibri().add(libro4);
        catalogo.getLibri().add(libro5);
        catalogo.getLibri().add(libro6);

        // CREAZIONE RIVISTE
        Riviste rivista1 = new Riviste( "rivista1", 2016, 40, Periodicita.SETTIMANALE, catalogo);
        Riviste rivista2 = new Riviste( "rivista2", 2018, 75, Periodicita.MENSILE, catalogo);
        Riviste rivista3 = new Riviste( "rivista3", 2020, 90, Periodicita.SEMESTRALE, catalogo);
        Riviste rivista4 = new Riviste( "rivista4", 2022, 82, Periodicita.MENSILE, catalogo);
        Riviste rivista5 = new Riviste("rivista5", 2009, 33, Periodicita.SEMESTRALE, catalogo);
        Riviste rivista6 = new Riviste( "rivista6", 2011, 45, Periodicita.SETTIMANALE, catalogo);

        // AGGIUNTA RIVISTE ALLA LISTA DELLE RIVISTE NEL CATALOGO
        catalogo.getRiviste().add(rivista1);
        catalogo.getRiviste().add(rivista2);
        catalogo.getRiviste().add(rivista3);
        catalogo.getRiviste().add(rivista4);
        catalogo.getRiviste().add(rivista5);
        catalogo.getRiviste().add(rivista6);



    }

}
