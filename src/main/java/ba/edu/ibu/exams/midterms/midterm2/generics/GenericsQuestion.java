package ba.edu.ibu.exams.midterms.midterm2.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum Gender {
    MALE,
    FEMALE
}

class Person {
    private String firstName;
    private int age;
    private Gender gender;

    public Person(String firstName, int age, Gender gender) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}

class Assistant extends Person {
    public Assistant(String firstName, int age, Gender gender) {
        super(firstName, age, gender);
    }
}

class Professor extends Person {
    public Professor(String firstName, int age, Gender gender) {
        super(firstName, age, gender);
    }
}

class Company<T extends Person> {
    private List<T> employees;

    public Company(List<T> employees) {
        this.employees = employees;
    }

    public List<T> getEmployees() {
        return employees;
    }

    public void setEmployees(List<T> employees) {
        this.employees = employees;
    }

    public Optional<List<T>> filterByGender(Gender gender) {
        List<T> result = new ArrayList<>();

        for (T employee : employees) {
            if (employee.getGender().equals(gender))
                result.add(employee);
        }
        return Optional.ofNullable(result);
    }

    public Optional<T> getByFirstName(String firstName) {
        for (T employee : employees) {
            if (employee.getFirstName().equals(firstName))
                return Optional.ofNullable(employee);
        }
        return Optional.ofNullable(null);
    }
}

class MainTask {
    public static void main(String[] args) {

        Company<Person> employees = new Company<>(Arrays.asList(
                new Professor("Becir Isakovic", 29, Gender.MALE),
                new Assistant("Adnan Miljkovic", 35, Gender.MALE),
                new Assistant("Amila Causevic", 24, Gender.FEMALE)
        ));

        Optional<Person> person = employees.getByFirstName("Becir Isakovic");
        System.out.println(person.get().getFirstName());

        Optional<Person> secondPerson = employees.getByFirstName("Adnan Miljkovic");
        System.out.println(secondPerson.get().getFirstName());

        Optional<List<Person>> persons = employees.filterByGender(Gender.MALE);
        for (Person p : persons.get())
            System.out.println(p.getFirstName());

        Optional<List<Person>> secondPersons = employees.filterByGender(Gender.FEMALE);
        for (Person p : secondPersons.get())
            System.out.println(p.getFirstName());
    }
}
