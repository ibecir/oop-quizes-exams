package ba.edu.ibu.exams.midterms.midterm1.generics;
/*
Create two records, Professor and Student.
Professor record includes fields id that has type int, name and department both of type String.
Student record also has id, name and grade which is String.

Create a class OOPList<T> with a generic type T, that takes a list of objects of type T as attribute called elements.
Implement a constructor that accepts a List of type T as a parameter and initializes the class attribute.
Include a method filterByGrade(int grade) that returns a List of type T, filtering elements based on the specified grade.
Inside this method, iterate through elements and add those with a grade matching the given value.
Implement the second method called getById(int id) that returns an object of type T based on the provided ID,
where T can be either a Student or a Professor.
*/

import java.util.ArrayList;
import java.util.List;

record Student(int id, String name, int grade) { }

record Professor(int id, String name, String department) { }

class OOPList<T> {
    private List<T> elements;

    public OOPList(List<T> elements) {
        this.elements = elements;
    }

    public List<T> filterByGrade(int grade) {
        List<T> result = new ArrayList<>();

        for (T element : elements) {
            if (element instanceof Student && ((Student) element).grade() == grade) {
                result.add(element);
            }
        }
        return result;
    }

    public T getById(int id) {
        for (T element : elements) {
            if (element instanceof Student && ((Student) element).id() == id) {
                return element;
            } else if (element instanceof Professor && ((Professor) element).id() == id) {
                return element;
            }
        }
        return null;
    }
}

class Main3 {
    public static void main(String[] args) {
        List<Object> records = List.of(
                new Student(1, "Alma", 10),
                new Student(2, "Haris", 11),
                new Student(3, "Lejla", 10),
                new Professor(101, "Becir", "IT")
        );

        OOPList<Object> oopList = new OOPList<>(records);
        List<Object> grade10Elements = oopList.filterByGrade(10);
        Object element = oopList.getById(2);
    }
}
