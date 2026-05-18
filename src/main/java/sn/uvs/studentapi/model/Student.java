package sn.uvs.studentapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Représente l'entité Étudiant.
 */
@Entity
@Table(name = "students")
public class Student {

    /** L'identifiant unique de l'étudiant. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Le nom de l'étudiant. */
    private String nom;

    /** Le prénom de l'étudiant. */
    private String prenom;

    /** L'adresse email de l'étudiant. */
    private String email;

    /** La moyenne académique de l'étudiant. */
    private Double moyenne;

    /**
     * Constructeur par défaut.
     */
    public Student() {
    }

    /**
     * Constructeur complet.
     *
     * @param finalNom     le nom de l'étudiant
     * @param finalPrenom  le prénom de l'étudiant
     * @param finalEmail   l'email de l'étudiant
     * @param finalMoyenne la moyenne de l'étudiant
     */
    public Student(final String finalNom, final String finalPrenom,
            final String finalEmail, final Double finalMoyenne) {
        this.nom = finalNom;
        this.prenom = finalPrenom;
        this.email = finalEmail;
        this.moyenne = finalMoyenne;
    }

    /**
     * Récupère l'identifiant.
     *
     * @return l'id
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit l'identifiant.
     *
     * @param finalId le nouvel id
     */
    public void setId(final Long finalId) {
        this.id = finalId;
    }

    /**
     * Récupère le nom.
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom.
     *
     * @param finalNom le nouveau nom
     */
    public void setNom(final String finalNom) {
        this.nom = finalNom;
    }

    /**
     * Récupère le prénom.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom.
     *
     * @param finalPrenom le nouveau prénom
     */
    public void setPrenom(final String finalPrenom) {
        this.prenom = finalPrenom;
    }

    /**
     * Récupère l'email.
     *
     * @return l'email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'email.
     *
     * @param finalEmail le nouvel email
     */
    public void setEmail(final String finalEmail) {
        this.email = finalEmail;
    }

    /**
     * Récupère la moyenne.
     *
     * @return la moyenne
     */
    public Double getMoyenne() {
        return moyenne;
    }

    /**
     * Définit la moyenne.
     *
     * @param finalMoyenne la nouvelle moyenne
     */
    public void setMoyenne(final Double finalMoyenne) {
        this.moyenne = finalMoyenne;
    }
}
