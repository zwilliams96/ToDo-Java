package org.zackwilliams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class TodoListManager {
    ArrayList<TodoItem> items  = TodoStorage.loadTasks();
    private int nextID = calculateNextId();
    Scanner scanner = new Scanner(System.in);
    ConsoleUI ui = new ConsoleUI(scanner);

    private int calculateNextId() {
        return items.stream().mapToInt(items -> items.id).max().orElse(0) + 1;
    }

    public void safeState() {
        TodoStorage.saveTasks(items);
        ui.printLine("Tasks have been safed");
    }


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
        safeState();
    }

    public void completeTask() {
        int id = ui.promptInt("Enter task ID to complete: ");
        Optional<TodoItem> task = findTaskById(id);
        if(task.isPresent()) {
            TodoItem item = task.get();
            if (item.isCompleted) {
                ui.printLine("Task is already completed");
            }
            else {
                item.isCompleted = true;
                safeState();
                ui.printLine("Task marked as completed.");
            }
        } else {
            ui.printLine("Task with ID " + id + " not found.");
        }
    }

    public void removeTask() {
        int id = ui.promptInt("Enter Task ID to Remove:");
        Optional<TodoItem> task = findTaskById(id);
        task.ifPresent(todoItem -> items.remove(todoItem));
        safeState();
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
