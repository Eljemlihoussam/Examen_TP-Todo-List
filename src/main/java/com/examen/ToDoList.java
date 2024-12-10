package com.examen;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    // Classe interne pour représenter une tâche
    private static class Task {
        private final int id;
        private final String message;

        public Task(int id, String message) {
            this.id = id;
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

    // Liste pour stocker les tâches
    private final List<Task> tasks;

    // Compteur pour l'auto-incrémentation des IDs
    private int taskIdCounter;

    // Constructeur
    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.taskIdCounter = 1; // Les IDs commencent à 1
    }

    // Méthode pour ajouter une tâche
    public void addTask(String taskMessage) {
        Task newTask = new Task(taskIdCounter, taskMessage);
        tasks.add(newTask);
        taskIdCounter++;
    }

    // Méthode pour récupérer toutes les tâches
    public List<String> getTasks() {
        List<String> taskList = new ArrayList<>();
        for (Task task : tasks) {
            taskList.add(task.toString());
        }
        return taskList;
    }

    // Méthode principale pour tester la classe
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Ajout de tâches
        toDoList.addTask("Acheter du lait");
        toDoList.addTask("Réviser pour l'examen");
        toDoList.addTask("Appeler le docteur");

        // Affichage des tâches
        List<String> tasks = toDoList.getTasks();
        for (String task : tasks) {
            System.out.println(task);
        }
    }
}