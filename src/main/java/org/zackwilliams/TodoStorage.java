package org.zackwilliams;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TodoStorage {
    private static final String FILE_NAME = "tasks.txt";

    public static void saveTasks(ArrayList<TodoItem> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (TodoItem item : tasks) {
                writer.printf("%d|%s|%s|%s|%s|%b\n",
                        item.id,
                        escape(item.name),
                        escape(item.desc),
                        item.startDate.toString(),
                        item.dueDate.toString(),
                        item.isCompleted);
            }
        } catch (IOException e) {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }

    public static ArrayList<TodoItem> loadTasks() {
        ArrayList<TodoItem> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    TodoItem item = new TodoItem();
                    item.id = Integer.parseInt(parts[0]);
                    item.name = unescape(parts[1]);
                    item.desc = unescape(parts[2]);
                    item.startDate = LocalDate.parse(parts[3]);
                    item.dueDate = LocalDate.parse(parts[4]);
                    item.isCompleted = Boolean.parseBoolean(parts[5]);
                    tasks.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
        }

        return tasks;
    }

    // Escape helper (to safely handle delimiter characters in text)
    private static String escape(String input) {
        return input.replace("|", "\\|");
    }

    private static String unescape(String input) {
        return input.replace("\\|", "|");
    }
}
