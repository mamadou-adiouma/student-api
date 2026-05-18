package sn.uvs.studentapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sn.uvs.studentapi.model.Student;
import sn.uvs.studentapi.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests unitaires pour le service StudentService.
 */
@ExtendWith(MockitoExtension.class)
final class StudentServiceTest {

    /** Identifiant de test pour l'étudiant existant. */
    private static final Long EXISTING_ID = 1L;

    /** Identifiant de test pour un étudiant inexistant. */
    private static final Long NON_EXISTING_ID = 99L;

    /** Note de test pour l'étudiant Awa. */
    private static final Double GRADE_AWA = 14.5;

    /** Note de test pour l'étudiant Omar. */
    private static final Double GRADE_OMAR = 16.0;

    /** Le dépôt simulé (mocked) des étudiants. */
    @Mock
    private StudentRepository repository;

    /** Le service à tester, avec injections des mocks. */
    @InjectMocks
    private StudentService service;

    /**
     * Teste que la méthode findAll retourne bien tous les étudiants.
     */
    @Test
    void findAllShouldReturnAllStudents() {
        final Student s = new Student("Diop", "Awa", "awa@uvs.sn", GRADE_AWA);
        when(repository.findAll()).thenReturn(List.of(s));

        final List<Student> result = service.findAll();

        assertEquals(1, result.size());

        verify(repository).findAll();
    }

    /**
     * Teste que findById retourne l'étudiant lorsqu'il existe.
     */
    @Test
    void findByIdShouldReturnStudentWhenExists() {
        final Student s = new Student("Diop", "Awa", "awa@uvs.sn", GRADE_AWA);
        s.setId(EXISTING_ID);
        when(repository.findById(EXISTING_ID)).thenReturn(Optional.of(s));

        final Optional<Student> result = service.findById(EXISTING_ID);

        assertTrue(result.isPresent());
        assertEquals("Awa", result.get().getPrenom());
    }

    /**
     * Teste que findById retourne un Optional vide si l'étudiant n'existe pas.
     */
    @Test
    void findByIdShouldReturnEmptyWhenNotExists() {
        when(repository.findById(NON_EXISTING_ID)).thenReturn(Optional.empty());

        final Optional<Student> result = service.findById(NON_EXISTING_ID);

        assertFalse(result.isPresent());
    }

    /**
     * Teste que la méthode save persiste correctement l'étudiant.
     */
    @Test
    void saveShouldPersistStudent() {
        final Student s = new Student("Fall", "Omar", "omar@uvs.sn", GRADE_OMAR);
        when(repository.save(s)).thenReturn(s);

        final Student saved = service.save(s);

        assertNotNull(saved);
        verify(repository).save(s);
    }

    /**
     * Teste que la méthode deleteById appelle bien le repository.
     */
    @Test
    void deleteByIdShouldCallRepository() {
        service.deleteById(EXISTING_ID);
        verify(repository).deleteById(EXISTING_ID);
    }
}
