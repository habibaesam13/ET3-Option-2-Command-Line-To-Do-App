import java.util.List;

public class CommandHandler {
    private final TaskManager manager;
    private final FileStorage storage;

    public CommandHandler(TaskManager manager, FileStorage storage) {
        this.manager = manager;
        this.storage = storage;
    }

    public void handle(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        String command = args[0].toLowerCase();

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Error: Missing description.");
                    return;
                }
                String description = args[1];
                String category = null;
                String priority = null;

                // Allow category or priority in any order
                if (args.length >= 3) {
                    if (isPriority(args[2])) {
                        priority = args[2];
                    } else {
                        category = args[2];
                    }
                }
                if (args.length >= 4) {
                    if (priority == null && isPriority(args[3])) {
                        priority = args[3];
                    } else if (category == null) {
                        category = args[3];
                    }
                }
                manager.addTask(description, category, priority);
                break;

            case "list":
                List<Task> tasks = manager.getTasks();
                if (tasks.isEmpty()) {
                    System.out.println("No tasks found.");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + coloredTask(tasks.get(i)));
                    }
                }
                break;

            case "listcat":
                if (args.length < 2) {
                    System.out.println("Error: Missing category.");
                    return;
                }
                String cat = args[1];
                List<Task> catTasks = manager.getTasksByCategory(cat);
                if (catTasks.isEmpty()) {
                    System.out.println("No tasks found in category: " + cat);
                } else {
                    for (int i = 0; i < catTasks.size(); i++) {
                        System.out.println((i + 1) + ". " + coloredTask(catTasks.get(i)));
                    }
                }
                break;


            case "done":
                if (args.length < 2) {
                    System.out.println("Error: Missing task number.");
                    return;
                }
                try {
                    int doneIndex = Integer.parseInt(args[1]) - 1;
                    if (manager.markDone(doneIndex)) {
                        System.out.println("Task marked as done.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Task number must be numeric.");
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Error: Missing task number.");
                    return;
                }
                try {
                    int delIndex = Integer.parseInt(args[1]) - 1;
                    if (manager.deleteTask(delIndex)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Task number must be numeric.");
                }
                break;
            case "edit":
                if (args.length < 2) {
                    System.out.println("Usage: edit <taskNumber> [newDescription] [newCategory] [newPriority]");
                    break;
                }
                try {
                    int editIndex = Integer.parseInt(args[1]) - 1;

                    // باقي args اختيارية
                    String newDescription = args.length > 2 ? args[2] : "";
                    String newCategory    = args.length > 3 ? args[3] : "";
                    String newPriority    = args.length > 4 ? args[4] : "";

                    // لازم على الأقل واحد منهم مش فاضي
                    if (newDescription.isEmpty() && newCategory.isEmpty() && newPriority.isEmpty()) {
                        System.out.println("Error: At least one field (description/category/priority) must be provided.");
                        break;
                    }

                    manager.editTask(newDescription, newCategory, newPriority, editIndex);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Task number must be numeric.");
                }
                break;


            case "help":
                printHelp();
                break;
            default:
                System.out.println("Unknown command: " + command);
                printHelp();
        }
    }

    private boolean isPriority(String value) {
        return value.equalsIgnoreCase("HIGH") ||
                value.equalsIgnoreCase("MEDIUM") ||
                value.equalsIgnoreCase("LOW");
    }

    private String coloredTask(Task task) {
        String priority = task.getPriority() != null ? task.getPriority().toUpperCase() : "MEDIUM";
        String color;
        switch (priority) {
            case "HIGH": color = "\u001B[31m"; break;   // Red
            case "LOW": color = "\u001B[32m"; break;    // Green
            default: color = "\u001B[33m";              // Yellow
        }
        return color + task + "\u001B[0m";
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("  add \"description\" [category] [priority]  - Add a task (category/priority optional)");
        System.out.println("  list                                     - List all tasks");
        System.out.println("  listcat <category>                       - List tasks by category");
        System.out.println("  done <taskNumber>                         - Mark a task as done");
        System.out.println("  edit <taskNumber> <desc> <cat> <prio>    - Edit a task");
        System.out.println("  delete <taskNumber>                       - Delete a task");
        System.out.println("  help                                     - Show this help message");
    }
}
