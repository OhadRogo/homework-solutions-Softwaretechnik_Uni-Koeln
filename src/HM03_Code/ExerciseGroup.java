package src.HM03_Code;

public class ExerciseGroup {
    private String groupId;
    private int maxCapacity;
    private String timeSlot;
    public ExerciseGroup(String groupId, int maxCapacity, String timeSlot) {
        this.groupId = groupId;
        this.maxCapacity = maxCapacity;
        this.timeSlot = timeSlot;
    }

    //getters

    public String getGroupId() {
        return groupId;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
}
