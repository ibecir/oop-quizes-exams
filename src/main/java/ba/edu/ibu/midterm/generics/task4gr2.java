package ba.edu.ibu.midterm.generics;

/*Create two records, Task and Note. The Task record should have fields id of type int, name, and priority of type int.
The Note record should have fields id of type int, title, and content, both of type String.
You should also create a generic class TaskList<T> with a type parameter T,
that takes a list of objects of type T as an attribute named tasks.
Implement a constructor for TaskList that accepts a List of type T as a parameter and initializes the tasks attribute.
Within the TaskList class, implement a method getTaskByPriority(int priority) that returns a List of type T,
filtering tasks based on the specified priority.
Inside this method, iterate through the tasks and add those with a priority matching the given value.
Additionally, implement a method called getTaskById(int id) that returns an Optional<T> based on the provided ID,
where T can be either a Task or a Note.
Return Optional.ofNullable(task) if the task is found, and Optional.ofNullable(null) if not.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

record Task(int id, String name, int priority) {}
record Note(int id, String title, String content) {}

class TaskList<T> {
    private List<T> tasks;

    public TaskList(List<T> tasks) {
        this.tasks = tasks;
    }
    public List<T> getTaskByPriority(int priority) {
        List<T> result = new ArrayList<>();

        for (T task : tasks) {
            if (task instanceof Task && ((Task) task).priority() == priority) {
                result.add(task);
            }
        }
        return result;
    }

    public Optional<T> getTaskById(int id) {
        for (T task : tasks) {
            if (task instanceof Task && ((Task) task).id() == id) {
                return Optional.ofNullable(task);
            }
        }
        return Optional.ofNullable(null);
    }
}
class Main {
    public static void main(String[] args) {
        List<Object> elements = List.of(
                new Task(1, "Task 1", 1),
                new Task(2, "Task 2", 2),
                new Task(3, "Task 3", 2),
                new Task(4, "Task 4", 2),
                new Note(101, "Note 1", "Text 1"),
                new Note(102, "Note 2", "Text 2")
        );

        TaskList<Object> taskList = new TaskList<>(elements);
        List<Object> priority1Tasks = taskList.getTaskByPriority(1);
        System.out.println("Priority 1 Tasks: " + priority1Tasks);

        Optional<Object> taskById = taskList.getTaskById(2);
        System.out.println("Task by ID: " + taskById.orElse("Task not found"));

        Optional<Object> taskById2 = taskList.getTaskById(20);
        System.out.println("Task by ID: " + taskById2.orElse("Task not found"));

    }
}
