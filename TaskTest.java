import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task(1, "Implement Task Class", "Develop the task management system",
                LocalDateTime.now().plusDays(2));
    }

    @Test
    void testAssignTo() {
        task.assignTo("shray moza");
        assertEquals("shray moza", task.getAssignedTo());
    }

    @Test
    void testUpdateStatus_ValidStatus() {
        task.updateStatus("In Progress");
        assertEquals("In Progress", task.getStatus());
    }

    @Test
    void testUpdateStatus_InvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> task.updateStatus("Unknown Status"));
    }

    @Test
    void testIsOverdue_NotOverdue() {
        assertFalse(task.isOverdue());
    }

    @Test
    void testIsOverdue_Overdue() {
        Task overdueTask = new Task(2, "Late Task", "This task should be overdue",
                LocalDateTime.now().minusDays(1));
        assertTrue(overdueTask.isOverdue());
    }
}