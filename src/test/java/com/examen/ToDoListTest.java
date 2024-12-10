package com.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {




        @Test
        void testAddAndRetrieveTasks() {
            ToDoList toDoList = new ToDoList();
            toDoList.addTask("First task");
            toDoList.addTask("Second task");

            assertEquals(2, toDoList.getTasks().size());
        }

        @Test
        void testRemoveTask() {
            ToDoList toDoList = new ToDoList();
            toDoList.addTask("Task to remove");

            assertTrue(toDoList.removeTask(1));
            assertEquals(0, toDoList.getTasks().size());
        }

        @Test
        void testUpdateTask() {
            ToDoList toDoList = new ToDoList();
            toDoList.addTask("Original task");

            assertTrue(toDoList.updateTask(1, "Updated task"));
            assertEquals("Task{id=1, message='Updated task'}", toDoList.getTasks().get(0));
        }

        @Test
        void testRemoveNonExistentTask() {
            ToDoList toDoList = new ToDoList();

            assertFalse(toDoList.removeTask(999));
        }

        @Test
        void testUpdateNonExistentTask() {
            ToDoList toDoList = new ToDoList();

            assertFalse(toDoList.updateTask(999, "New task"));
        }
    }

