import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + title;
    }
}

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

           if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.nextLine();
            continue;
                                }
        choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewTasks();
                case 3 -> completeTask(sc);
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 3);

        sc.close();
    }

    private static void addTask(Scanner sc) {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        tasks.add(new Task(title));
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    private static void completeTask(Scanner sc) {
    viewTasks();
    System.out.print("Enter task number to mark complete: ");
    int index = sc.nextInt() - 1;

    if (index >= 0 && index < tasks.size()) {
        tasks.get(index).markCompleted();
        System.out.println("Task marked as completed.");
    } else {
        System.out.println("Invalid task number.");
    }
}
}



