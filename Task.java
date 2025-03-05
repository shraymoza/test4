import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Task {
    private int id;
    private String title;
    private String description;
    private String assignedTo;
    private String status;
    private LocalDateTime dueDate;

    private static final List<String> VALID_STATUSES = Arrays.asList("To Do", "In Progress", "Completed");

    public Task(int id, String title, String description, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = "To Do";  // Default status
    }

    public void assignTo(String teamMember) {
        this.assignedTo = teamMember;
    }

    public void updateStatus(String newStatus) {
        if (!VALID_STATUSES.contains(newStatus)) {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
        this.status = newStatus;
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(this.dueDate);
    }

    // Getters for testing
    public String getAssignedTo() { return assignedTo; }
    public String getStatus() { return status; }
}