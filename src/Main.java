public class Main {
    public static void main(String[] args) {
        FileStorage storage = new FileStorage("tasks.json");
        TaskManager manager = new TaskManager(storage);
        CommandHandler handler = new CommandHandler(manager, storage);
        handler.handle(args);
    }
}
