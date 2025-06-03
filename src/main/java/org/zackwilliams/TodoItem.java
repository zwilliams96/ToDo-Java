package org.zackwilliams;

import java.time.LocalDate;

public class TodoItem {
    public int id;
    public String name;
    public String desc;
    public LocalDate startDate;
    public LocalDate dueDate;
    public boolean isCompleted;

    public TodoItem(int id,String name, String desc, LocalDate startDate, LocalDate dueDate, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public TodoItem(){

    }

    public int getID() {
        return id;
    }
}

