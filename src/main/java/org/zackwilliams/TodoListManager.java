package org.zackwilliams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class TodoListManager {
    private int nextID = 1;
    ArrayList<TodoItem> items  = new ArrayList<TodoItem>();
    Scanner scanner = new Scanner(System.in);
    ConsoleUI ui = new ConsoleUI(scanner);


    public void removeTask(TodoItem task) {

    }

    public void listTasks() {
        if (items.isEmpty()) {
            ui.printLine("No Tasks");
        } else {
            for (TodoItem item : items) {
                ui.printTask(item);
            }
        }
    }

    public void createTask() {
        String name = ui.promptString("Enter Task Name:");
        String desc = ui.promptString("Enter Task Desc:");
        LocalDate startDate = ui.promptDate("Enter Start Date:");
        LocalDate dueDate = ui.promptDate("Enter Due Date:");
        items.add(new TodoItem(nextID++,name, desc, startDate, dueDate, false));
    }

    public Optional<TodoItem> findTaskById(int id) {
        return items.stream().filter(task -> task.getID() == id).findFirst();
    }

    public void FindTask() {
        int id = ui.promptInt("Enter Task ID: ");
        Optional<TodoItem> task = findTaskById(id);
        task.ifPresent(todoItem -> ui.printTask(todoItem));
    }
}
