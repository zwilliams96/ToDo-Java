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
            int option = ui.promptMenu("Select an option:","View Tasks","Add Task","Remove Task","Exit");

            switch (option) {
                case 1 -> lm.listTasks();
                case 2 -> lm.createTask();
                case 4 -> running = false;
                default -> ui.printLine("Invalid option.");
            }
        }
    }
}