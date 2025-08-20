import java.util.ArrayList;
import java.util.List;
//Manages a list of tasks (business logic).
/*
* Handles operations:

Add a task (with duplicate check, default values).

Get all tasks.

Get tasks by category.

Mark a task as done.

Delete a task.
* */
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
    public void editTask(String decryption,String category,String priority,int taskIndex){
        if(taskIndex<0 || taskIndex>tasks.size()){
            System.out.println("Task is not Defined!");
            return;
        }

        if(! decryption.isEmpty() ){tasks.get(taskIndex).setDescription(decryption);}

        if(! category.isEmpty()){tasks.get(taskIndex).setCategory(category);}

        if(! priority.isEmpty()){tasks.get(taskIndex).setPriority(priority);}

        storage.save(tasks);
        System.out.println("Task Edited Successfully");
    }
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    private int priorityValue(String priority) {
        if (priority == null) return 2;
        switch (priority.trim().toUpperCase()) {
            case "HIGH": return 1;
            case "MEDIUM": return 2;
            case "LOW": return 3;
            default: return 4;
        }
    }

    public List<Task> getTasksByCategory(String category) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCategory() != null && task.getCategory().equalsIgnoreCase(category)) {
                result.add(task);
            }
        }
        return result;
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
