package org.zackwilliams;

import java.time.LocalDate;

public class TodoItem {
    public String name;
    public String desc;
    public LocalDate startDate;
    public LocalDate dueDate;
    public boolean isCompleted;

    public TodoItem(String name, String desc, LocalDate startDate, LocalDate dueDate, boolean isCompleted) {
        this.name = name;
        this.desc = desc;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }
}

