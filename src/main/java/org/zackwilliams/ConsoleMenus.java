package org.zackwilliams;

public class ConsoleMenus {
    public static int showMainMenu(ConsoleUI ui) {
        return ui.promptMenu("Main Menu",
                "View Tasks",
                "Add Task",
                "Find Task",
                "Remove Task",
                "Complete Task",
                "Exit");
    }

    public static void findTaskMenu(ConsoleUI ui, TodoListManager lm) {
        boolean searching = true;
        while (searching) {
            int option = ui.promptMenu("Find Task Menu",
                    "Search by Id",
                    "Search by Due Date",
                    "Search by Completion Status",
                    "Back to Main Menu");

            switch (option) {
                case 1 -> lm.FindTask();
                //case 2 -> lm.findTasksByDueDate(ui.promptDate("Enter due date (YYYY-MM-DD):"));
                //case 3 -> lm.findTasksByCompletionStatus(ui.promptBoolean("Completed? (true/false):"));
                case 4 -> searching = false;
                default -> ui.printLine("Invalid option.");
            }
        }
    }
}
