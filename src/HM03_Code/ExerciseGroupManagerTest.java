package src.HM03_Code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ExerciseGroupManagerTest {
    private final ExerciseGroupManager manager = new ExerciseGroupManager();

    @Test
    void testTotalStudentsLessThanOrEqualToZero() {
        // Case: totalStudents <= 0
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
        // Case: More students than capacity, expect excess
        assertEquals(5, manager.checkGroupCapacities(15, 5, 2));
    }

    @Test
    void testExactCapacity() {
        // Case: Total students exactly match capacity, expect 0 excess
        assertEquals(0, manager.checkGroupCapacities(10, 5, 2));
    }

    @Test
    void testInvalidGroupSizeOrAvailableGroups() {
        // Case: groupSize or availableGroups is zero or negative
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 0, 2));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, -5, 2));
        assertThrows(IllegalArgumentException.class, () -> manager.checkGroupCapacities(10, 5, -2));
    }
}
