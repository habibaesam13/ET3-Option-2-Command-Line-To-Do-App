import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class FileStorage {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String fileName;

    public FileStorage(String fileName) {
        this.fileName = fileName;
    }

    public void save(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }



    public List<Task> load() {
        try {
            File file = new File(fileName);
            if (!file.exists()) return new java.util.ArrayList<>();
            try (FileReader reader = new FileReader(file)) {
                Type type = new TypeToken<List<Task>>() {}.getType();
                return gson.fromJson(reader, type);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
}
