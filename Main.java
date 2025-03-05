import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a sample task
        Task task = new Task(1, "task manager project", "hello world",
                LocalDateTime.now().plusDays(3));


        System.out.println("Status: " + task.getStatus());

        // Assign task
        System.out.print("\nEnter team member to assign the task: ");
        String teamMember = scanner.nextLine();
        task.assignTo(teamMember);
        System.out.println("Task assigned to: " + task.getAssignedTo());

        // Update status
        System.out.print("\nEnter new status (To Do, In Progress, Completed): ");
        String status = scanner.nextLine();
        try {
            task.updateStatus(status);
            System.out.println("Updated Status: " + task.getStatus());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Check if overdue
        System.out.println("\nTask Overdue: " + task.isOverdue());

        scanner.close();
    }
}