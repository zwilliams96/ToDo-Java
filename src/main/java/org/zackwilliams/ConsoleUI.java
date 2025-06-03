package org.zackwilliams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner input;

    public ConsoleUI(Scanner input) {
        this.input = input;
    }

    public int promptMenu(String title, String... options) {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s%n", i + 1, options[i]);
        }
        System.out.print("> ");
        return input.nextInt();
    }

    public void printLine(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printTask(TodoItem item) {
        System.out.println("----------------------------");
        System.out.println("ID: " + item.id);
        System.out.println("Name: " + item.name);
        System.out.println("Desc: " + item.desc);
        System.out.println("Start Date: " + item.startDate.toString());
        System.out.println("Due Date: " + item.dueDate.toString());
        System.out.println("----------------------------");
    }

    public String promptString(String message) {
        System.out.println(message);
        System.out.print("> ");
        return input.nextLine();
    }

    public int promptInt(String message) {
        while (true) {
            try {
                String line = promptString(message);
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public LocalDate promptDate(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            try {
                String line = promptString(message + " (yyyy-MM-dd)");
                return LocalDate.parse(line, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Try again.");
            }
        }

    }
}
