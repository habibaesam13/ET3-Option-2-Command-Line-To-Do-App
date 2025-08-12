import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private FileStorage storage;

    public TaskManager(FileStorage storage) {
        this.storage = storage;
        this.tasks = storage.load(); // Load tasks from file when manager is created

        // Fix any null category/priority from old data
        for (Task t : tasks) {
            if (t.getCategory() == null || t.getCategory().trim().isEmpty()) {
                t.setCategory("General");
            }
            if (t.getPriority() == null || t.getPriority().trim().isEmpty()) {
                t.setPriority("MEDIUM");
            }
        }
    }

    public void addTask(String description, String category, String priority) {
        if (category == null || category.trim().isEmpty()) {
            category = "General";
        }
        if (priority == null || priority.trim().isEmpty()) {
            priority = "MEDIUM";
        }

        // Prevent duplicate in same category
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description) &&
                    t.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Error: Task already exists in this category.");
                return;
            }
        }
        tasks.add(new Task(description, category, priority));
        storage.save(tasks);
        System.out.println("Task added.");
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    private int priorityValue(String priority) {
        if (priority == null) return 2; // Default MEDIUM if null
        switch (priority.trim().toUpperCase()) {
            case "HIGH": return 1;
            case "MEDIUM": return 2;
            case "LOW": return 3;
            default: return 4;
        }
    }

    public void listByCategory(String category) {
        boolean found = false;
        List<Task> sorted = getTasks();
        for (int i = 0; i < sorted.size(); i++) {
            Task t = sorted.get(i);
            if (t.getCategory().equalsIgnoreCase(category)) {
                System.out.println((i + 1) + ". " + t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found in category: " + category);
        }
    }

    public boolean markDone(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.get(index).markDone();
        storage.save(tasks);
        return true;
    }

    public boolean deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            return false;
        }
        tasks.remove(index);
        storage.save(tasks);
        return true;
    }
}
