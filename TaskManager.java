import java.util.*;

// Task class
class Task {
    int id;
    String title;
    boolean isCompleted;

    Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Title: " + title +
                " | Status: " + (isCompleted ? "Completed" : "Pending"));
    }
}

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int taskIdCounter = 1;

    // Add Task
    static void addTask() {
        sc.nextLine();
        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        tasks.add(new Task(taskIdCounter++, title));
        System.out.println("✅ Task Added!");
    }

    // View Tasks
    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task t : tasks) {
            t.display();
        }
    }

    // Mark Task as Completed
    static void completeTask() {
        System.out.print("Enter Task ID to mark complete: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.id == id) {
                t.isCompleted = true;
                System.out.println("✅ Task marked as completed!");
                return;
            }
        }

        System.out.println("❌ Task not found.");
    }

    // Delete Task
    static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {
            Task t = it.next();
            if (t.id == id) {
                it.remove();
                System.out.println("🗑 Task deleted.");
                return;
            }
        }

        System.out.println("❌ Task not found.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Task Manager =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: completeTask(); break;
                case 4: deleteTask(); break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}