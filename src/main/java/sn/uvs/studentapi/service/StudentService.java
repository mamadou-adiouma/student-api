package sn.uvs.studentapi.service;

import org.springframework.stereotype.Service;
import sn.uvs.studentapi.model.Student;
import sn.uvs.studentapi.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service gérant la logique métier liée aux étudiants.
 */
@Service
public final class StudentService {

    /** Le dépôt de données (repository) pour la gestion des étudiants. */
    private final StudentRepository repository;

    /**
     * Constructeur pour l'injection de dépendance du dépôt.
     *
     * @param studentRepository le dépôt à associer à ce service
     */
    public StudentService(final StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    /**
     * Récupère la liste complète de tous les étudiants.
     *
     * @return la liste des étudiants
     */
    public List<Student> findAll() {
        return repository.findAll();
    }

    /**
     * Recherche un étudiant spécifique par son identifiant unique.
     *
     * @param id l'identifiant de l'étudiant recherché
     * @return un Optional contenant l'étudiant s'il est trouvé
     */
    public Optional<Student> findById(final Long id) {
        return repository.findById(id);
    }

    /**
     * Enregistre un nouvel étudiant ou met à jour un étudiant existant.
     *
     * @param student l'entité étudiant à sauvegarder
     * @return l'étudiant enregistré avec son identifiant généré
     */
    public Student save(final Student student) {
        return repository.save(student);
    }

    /**
     * Supprime définitivement un étudiant de la base de données.
     *
     * @param id l'identifiant de l'étudiant à supprimer
     */
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}