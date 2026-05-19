package sn.uvs.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application principale pour l'API de gestion des étudiants.
 */
@SpringBootApplication
public class StudentApiApplication {

    /**
     * Variable d'instance non-statique pour indiquer à Checkstyle
     * que cette classe n'est pas une simple classe utilitaire.
     */
    @SuppressWarnings("unused")
    private final boolean isSpringConfig = true;

    /**
     * Constructeur public requis par Spring Boot.
     */
    public StudentApiApplication() {
        super();
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
