package com.examen;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private static class Task {
        private final int id;
        private String message;

        public Task(int id, String message) {
            this.id = id;
            this.message = message;
        }

        public int getId() {
            return id;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    private final List<Task> tasks;

    private int taskIdCounter;


    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.taskIdCounter = 1; // Les IDs commencent à 1
    }

    public void addTask(String taskMessage) {
        Task newTask = new Task(taskIdCounter, taskMessage);
        tasks.add(newTask);
        taskIdCounter++;
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean updateTask(int id, String newTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setMessage(newTask);
                return true;
            }
        }
        return false;
    }

    public List<String> getTasks() {
        List<String> taskList = new ArrayList<>();
        for (Task task : tasks) {
            taskList.add(task.toString());
        }
        return taskList;
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.addTask("Acheter du lait");
        toDoList.addTask("Réviser pour l'examen");
        toDoList.addTask("Appeler le docteur");

        System.out.println("Modification de la tâche avec ID 2 :");
        toDoList.updateTask(2, "Réviser pour l'examen final");

        System.out.println("Suppression de la tâche avec ID 3 :");
        toDoList.removeTask(3);

        List<String> tasks = toDoList.getTasks();
        for (String task : tasks) {
            System.out.println(task);
 }
}
}