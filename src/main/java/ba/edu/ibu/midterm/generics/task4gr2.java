package ba.edu.ibu.midterm.generics;

/*Write a Java program that uses generics and records to store information about a list of tasks.
The program should have two methods: getTasksByPriority and getTaskById.
The getTasksByPriority method iterates over the list of tasks and adds each task with the desired priority to a new list.
The getTaskById method iterates over the list of tasks and returns an optional task with the specified ID.
If no task is found, it should return an empty optional.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

record Task(int id, String name, int priority) {}

class TaskList<T extends Task> {
    private List<T> tasks;

    public TaskList(List<T> tasks) {
        this.tasks = tasks;
    }

    public List<T> getTasksByPriority(int priority) {
        List<T> result = new ArrayList<>();

        for (T task : tasks) {
            if (task.priority() == priority) {
                result.add(task);
            }
        }

        return result;
    }

    public Optional<T> getTaskById(int id) {
        for (T task : tasks) {
            if (task.id() == id) {
                return Optional.ofNullable(task);
            }
        }

        return null;
    }
}
class Main4{
    List<Task> tasks = List.of(
            new Task(1, "Task 1", 1),
            new Task(2, "Task 2", 2),
            new Task(3, "Task 3", 1),
            new Task(4, "Task 4", 3)
    );

    TaskList<Task> taskList = new TaskList<>(tasks);
    List<Task> priority1Tasks = taskList.getTasksByPriority(1);
    Optional<Task> task = taskList.getTaskById(2);
}