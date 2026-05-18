package sn.uvs.studentapi.controller;

import org.springframework.http.ResponseEntity;
import sn.uvs.studentapi.model.Student;
import sn.uvs.studentapi.service.StudentService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des étudiants.
 */
@RestController
@RequestMapping("/api/students")
public final class StudentController {

    /**
     * Service utilisé pour les opérations métier sur les étudiants.
     */
    private final StudentService service;

    /**
     * Constructeur pour injecter le service étudiant.
     *
     * @param studentService le service utilisé par ce contrôleur
     */
    public StudentController(final StudentService studentService) {
        this.service = studentService;
    }

    /**
     * Récupère la liste de tous les étudiants.
     *
     * @return la liste des étudiants
     */
    @GetMapping
    public List<Student> getAll() {
        return service.findAll();
    }

    /**
     * Récupère un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'étudiant
     * @return la réponse contenant l'étudiant ou un statut 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable final Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouvel étudiant.
     *
     * @param student l'étudiant à créer
     * @return l'étudiant créé
     */
    @PostMapping
    public Student create(@RequestBody final Student student) {
        return service.save(student);
    }

    /**
     * Supprime un étudiant par son identifiant.
     *
     * @param id l'identifiant de l'étudiant à supprimer
     * @return une réponse vide avec un statut 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
