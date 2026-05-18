package sn.uvs.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uvs.studentapi.model.Student;
import java.util.Optional;

/**
 * Interface de dépôt pour l'accès aux données de l'entité Student.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Recherche un étudiant par son adresse email.
     *
     * @param email l'adresse email de l'étudiant
     * @return un Optional contenant l'étudiant trouvé, ou vide
     */
    Optional<Student> findByEmail(String email);
}
