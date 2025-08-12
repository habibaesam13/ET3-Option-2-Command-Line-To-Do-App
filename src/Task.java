public class Task {
    private String description;
    private String category;
    private String priority; // HIGH, MEDIUM, LOW
    private boolean done;
    private String createdAt;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Task(String description, String category, String priority) {
        this.description = description;
        this.category = category;
        this.priority = priority.toUpperCase();
        this.done = false;
        this.createdAt = java.time.LocalDateTime.now().toString();
    }

    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getPriority() { return priority; }
    public boolean isDone() { return done; }
    public void markDone() { this.done = true; }

    @Override
    public String toString() {
        return String.format("[%s] %s (Category: %s, Priority: %s, Created: %s)",
                done ? "X" : " ", description, category, priority, createdAt);
    }
}
