package src.homeworkCodes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;


public class ExerciseGroupManagerTest {
    private final ExerciseGroupManager manager = new ExerciseGroupManager();

    @Test
    void testTotalStudentsLessThanOrEqualToZero() {
        // Case: totalStudents <=0
        assertEquals(0, manager.checkGroupCapacities(0, 5, 2));
        assertEquals(0, manager.checkGroupCapacities(-10, 5, 2));
    }

    @Test
    void testValidCapacityNoExcessStudents() {
        // Case: No excess students, capacity is enough
        assertEquals(0, manager.checkGroupCapacities(10, 5, 2));
    }

    @Test
    void testExcessStudents() {
        // Case: More studentsthan capacity,expect excess
        assertEquals(5, manager.checkGroupCapacities(15, 5, 2));
    }

    @Test
    void testExactCapacity() {
        // Case: Total students exactly match capacity, expect 0 excess
        assertEquals(0, manager.checkGroupCapacities(10,5,2));
    }

    @Test
    void testInvalidGroupSizeOrAvailableGroups() {
        // Case: groupSize or availableGroups is zero or negative
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 0, 2));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, -5, 2));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 5, -2));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(0, 5, 2, 0),
                Arguments.of(-10, 5, 2, 0),
                Arguments.of(10, 5, 2, 0),
                Arguments.of(15, 5, 2, 5),
                Arguments.of(10, 5, 2, 0),
                Arguments.of(10, 0, 2, IllegalArgumentException.class),
                Arguments.of(10, 5, 0, IllegalArgumentException.class),
                Arguments.of(10, -5, 2, IllegalArgumentException.class),
                Arguments.of(10, 5, -2, IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testCheckGroupCapacities(int totalStudents, int groupSize, int availableGroups, Object expected) {
        if (expected instanceof Class<?>) {
            assertThrows((Class<? extends Throwable>) expected, () -> manager.checkGroupCapacities(totalStudents, groupSize, availableGroups));
        } else {
            assertEquals(expected, manager.checkGroupCapacities(totalStudents, groupSize, availableGroups));
        }
    }


}
