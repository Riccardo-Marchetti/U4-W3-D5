package Riccardo;

import Riccardo.dao.LibroDao;
import Riccardo.dao.RivistaDao;
import Riccardo.entities.*;
import Riccardo.enums.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Application {
    // ENTITY MANAGER FACTORY
   private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");
    public static void main(String[] args) {

        // ENTITY MANAGER
        EntityManager em = emf.createEntityManager();
        LibroDao ld = new LibroDao(em);
        RivistaDao rd = new RivistaDao(em);

        // CREAZIONE UTENTI
        Utente utente1 = new Utente("Fabio", "Rossi", LocalDate.of(2000, 03, 20));
        Utente utente2 = new Utente("Matteo", "Bianchi",LocalDate.of(1998, 07, 30));
        Utente utente3 = new Utente("Andrea", "Esposito", LocalDate.of(1990, 05, 12));
        Utente utente4 = new Utente("Matteo", "Romano",LocalDate.of(1993, 01, 17));

        // CREAZIONE LIBRI
        Libri libro1 = new Libri("libro1", 2020, 260, "Riccardo", "Fantasy");
        Libri libro2 = new Libri("libro2", 2023, 300, "Antonio", "Avventura e azione");
        Libri libro3 = new Libri("libro3", 2022, 180, "Luca", "Thriller" );
        Libri libro4 = new Libri("libro4", 2019, 320, "Fabio", "Fantascienza");
        Libri libro5 = new Libri("libro5", 2012, 162, "Alberto", "Horror");
        Libri libro6 = new Libri("libro6", 2015, 235, "Fabio", "Fantasy");

        // LISTA DI LIBRI
        List<Libri> listaLibri = new ArrayList<>();
        listaLibri.add(libro1);
        listaLibri.add(libro2);
        listaLibri.add(libro3);
        listaLibri.add(libro4);
        listaLibri.add(libro5);
        listaLibri.add(libro6);

        // CREAZIONE RIVISTE
        Riviste rivista1 = new Riviste( "rivista1", 2016, 40, Periodicita.SETTIMANALE);
        Riviste rivista2 = new Riviste( "rivista2", 2018, 75, Periodicita.MENSILE);
        Riviste rivista3 = new Riviste( "rivista3", 2020, 90, Periodicita.SEMESTRALE);
        Riviste rivista4 = new Riviste( "rivista4", 2022, 82, Periodicita.MENSILE);
        Riviste rivista5 = new Riviste("rivista5", 2009, 33, Periodicita.SEMESTRALE);
        Riviste rivista6 = new Riviste( "rivista6", 2011, 45, Periodicita.SETTIMANALE);

        // LISTA DI RIVISTE
        List<Riviste> listaRiviste = new ArrayList<>();
        listaRiviste.add(rivista1);
        listaRiviste.add(rivista2);
        listaRiviste.add(rivista3);
        listaRiviste.add(rivista4);
        listaRiviste.add(rivista5);
        listaRiviste.add(rivista6);

        // CREAZIONE CATALOGO CONTENENTE LIBRI E RIVISTE
        Catalogo catalogo = new Catalogo(listaLibri, listaRiviste);

        // CREAZIONE PRESTITI
        Prestito prestitoLibro1 = new Prestito(utente1, libro1, LocalDate.of(2024, 03, 21), LocalDate.of(2024, 03, 21).plusDays(30), null);
        Prestito prestitoLibro2 = new Prestito(utente3, libro3, LocalDate.of(2024, 02, 10), LocalDate.of(2024, 02, 10).plusDays(30), LocalDate.of(2024, 02, 25));
        Prestito prestitoRivista1 = new Prestito(utente2, rivista2, LocalDate.of(2024, 03, 1), LocalDate.of(2024, 03, 1).plusDays(30), null);
        Prestito prestitoRivista2 = new Prestito(utente4, rivista4, LocalDate.of(2024, 02, 17), LocalDate.of(2024, 02, 17).plusDays(30), LocalDate.of(2024, 03, 01));

        // AGGIUNTA AL CATALOGO
//        ld.salvaLibro(libro1);
//        ld.salvaLibro(libro2);
//        ld.salvaLibro(libro3);
//        ld.salvaLibro(libro4);
//        ld.salvaLibro(libro5);
//        ld.salvaLibro(libro6);
//
//        rd.salvaRivista(rivista1);
//        rd.salvaRivista(rivista2);
//        rd.salvaRivista(rivista3);
//        rd.salvaRivista(rivista4);
//        rd.salvaRivista(rivista5);
//        rd.salvaRivista(rivista6);

        // RIMUOVI DAL CATALOGO TRAMITE CODICE ISBN
//        ld.rimuoviLibro(6);
//        rd.rimuoviRivista(6);

        // RICERCA LIBRO PER CODICE ISBN
        ld.ricercaLibroISBN(1).forEach(System.out::println);

        // RICERCA RIVISTA PER ISBN
        rd.ricercaRivistaISBN(1).forEach(System.out::println);

        // RICERCA LIBRO PER ANNO DI PUBBLICAZIONE
        ld.ricercaLibroAnnoPubblicazione(2022).forEach(System.out::println);

        // RICERCA RIVISTA PER ANNO DI PUBBLICAZIONE
        rd.ricercaRivistaAnnoPubblicazione(2016).forEach(System.out::println);

        // RICERCA LIBRO PER AUTORE
        ld.ricercaLibroAutore("Riccardo").forEach(System.out::println);
    }

}
