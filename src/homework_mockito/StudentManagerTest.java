package src.homework_mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentManagerTest {

    private StudentManager studentManager;

    @Mock
    private List<Course> courses;

    @Mock
    private Course mockedCourse;

    @Mock
    private ExerciseGroup mockedGroup1;

    @Mock
    private ExerciseGroup mockedGroup2;

    @Mock
    private Student mockedStudent1;

    @Mock
    private Student mockedStudent2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        studentManager = new StudentManager(null, courses); // Students directly unused in this scenario
    }

    @Test
    public void testGenerateStudentDistribution_Success() {
        // Arrange
        when(mockedStudent1.getName()).thenReturn("Alice");
        when(mockedStudent1.getId()).thenReturn("A123");
        when(mockedStudent2.getName()).thenReturn("Bob");
        when(mockedStudent2.getId()).thenReturn("B456");

        when(mockedGroup1.getName()).thenReturn("Group 1");
        when(mockedGroup1.getStudents()).thenReturn(List.of(mockedStudent1));

        when(mockedGroup2.getName()).thenReturn("Group 2");
        when(mockedGroup2.getStudents()).thenReturn(List.of(mockedStudent2));

        when(mockedCourse.getName()).thenReturn("Software Engineering");
        when(mockedCourse.getExerciseGroups()).thenReturn(List.of(mockedGroup1, mockedGroup2));

        when(courses.stream()).thenReturn(List.of(mockedCourse).stream());

        // Act
        Map<String, List<String>> distribution = studentManager.generateStudentDistribution("Software Engineering");

        // Assert
        assertEquals(2, distribution.size());
        assertTrue(distribution.containsKey("Group 1"));
        assertTrue(distribution.containsKey("Group 2"));
        assertEquals(List.of("Alice (A123)"), distribution.get("Group 1"));
        assertEquals(List.of("Bob (B456)"), distribution.get("Group 2"));
    }

    @Test
    public void testGenerateStudentDistribution_CourseNotFound() {
        // Arrange
        when(mockedCourse.getName()).thenReturn("Object-Oriented Software Engineering");
        when(courses.stream()).thenReturn(List.of(mockedCourse).stream());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> studentManager.generateStudentDistribution("Software Engineering"));
    }

}
