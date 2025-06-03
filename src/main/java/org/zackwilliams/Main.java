package org.zackwilliams;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        runApp();

    }

    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);
        TodoListManager lm = new TodoListManager();

        boolean running = true;

        while (running) {
            int option = ConsoleMenus.showMainMenu(ui);

            switch (option) {
                case 1 -> lm.listTasks();
                case 2 -> lm.createTask();
                case 3 -> ConsoleMenus.findTaskMenu(ui, lm);
                case 4 -> lm.removeTask();
                case 5 -> lm.completeTask();
                case 6 -> running = false;
                default -> ui.printLine("Invalid option.");
            }
        }

        lm.safeState();
    }
}