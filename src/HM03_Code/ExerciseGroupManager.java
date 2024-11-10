package src.HM03_Code;

public class ExerciseGroupManager {
    /**
     * This method is used to check whether the max. capacity of students for the available groups had an exception
     *
     * @param totalStudents The total number of students to assign.
     * @param groupSize The maximum number of students in every group.
     * @param availableGroups total number of groups available for assignment.
     * @return The number of students that must be assigned with the current number of
     *         registered students and available groups. Returns 0 if totalStudents <= 0.
     * @throws IllegalArgumentException if groupSize or number of groups is zero or negative.
     */
    public int checkGroupCapacities(int totalStudents, int groupSize, int availableGroups) {
        if (groupSize <= 0 || availableGroups <= 0) {
            throw new IllegalArgumentException("Group size and number of groups must be positive.");
        }
        if (totalStudents <= 0) {
            return 0;
        }

        int capacity = groupSize * availableGroups;
        return Math.max(0, totalStudents - capacity);
    }
}
