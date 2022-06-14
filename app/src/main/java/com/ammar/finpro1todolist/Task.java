package com.ammar.finpro1todolist;

public class Task {
    int id;
    String task;

    public Task(){ super();}

    public Task(int i, String task){
    this.id = i;
    this.task = task;
    }

    public Task(String task){
    this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
