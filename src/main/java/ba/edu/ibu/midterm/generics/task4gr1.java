package ba.edu.ibu.midterm.generics;
/*Write a Java program that uses generics and records to store information about a list of students.
The program should have two methods: getStudentsByGrade and getStudentById.
The getStudentsByGrade method should retrieve all students with a given grade from the list,
while the getStudentById method should retrieve a single student by their ID. */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

record Student(int id, String name, int grade) { }

class StudentList<T extends Student> {
    private List<T> students;

    public StudentList(List<T> students) {
        this.students = students;
    }

    public List<T> getStudentsByGrade(int grade) {
        List<T> result = new ArrayList<>();

        for (T student : students) {
            if (student.grade() == grade) {
                result.add(student);
            }
        }
        return result;
    }

    public Optional<T> getStudentById(int id) {
        for (T student : students) {
            if (student.id() == id) {
                return Optional.ofNullable(student);
            }
        }
        return null;
    }
}
class Main3{
    List<Student> students = List.of(
            new Student(1, "Alice", 10),
            new Student(2, "Bob", 11),
            new Student(3, "Charlie", 10)
    );

    StudentList<Student> studentList = new StudentList<>(students);
    List<Student> grade10Students = studentList.getStudentsByGrade(10);
    Optional<Student> student = studentList.getStudentById(2);
}