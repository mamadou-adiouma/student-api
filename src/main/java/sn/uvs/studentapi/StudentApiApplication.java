package sn.uvs.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application principale pour l'API de gestion des étudiants.
 */
@SpringBootApplication
public class StudentApiApplication {

    /**
     * Constructeur privé masqué pour empêcher l'instanciation de la classe
     * utilitaire.
     */
    private StudentApiApplication() {
        // Empêche l'instanciation directe
    }

    /**
     * Point d'entrée principal de l'application Spring Boot.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(final String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }
}