package ba.edu.ibu.midterm.inheritance.g2;

/*
You are tasked with designing a Java program to calculate bonuses for employees based on their roles.
The program includes a base class Employee and two subclasses Assistant and Professor.
Your objective is to implement a system that accurately computes bonuses for each type of employee.

Employee Class:
The Employee class represents a generic employee and has the following attributes:

- name (String): The name of the employee.
- salary (double): The base salary of the employee.

It also has the following methods:

- constructor with all arguments - Employee(String name, double salary)
- get and set methods for both attributes
- calculateBonus(): double: A method that calculates and returns the bonus for the employee.
The default implementation returns 0.0.

Assistant Class:
The Assistant class extends the Employee class and includes an additional attribute:

- yearsOfExperience (int): The number of years of experience as an assistant.

It also has the constructor for all fields - Assistant(String name, double salary, int yearsOfExperience)
It overrides the calculateBonus method to calculate the bonus for assistants,
which is 110% (1.1) of their salary multiplied by their years of experience.

Professor Class:
The Professor class also extends the Employee class and includes an additional attribute:

- title (String): The title of the professor.

It also has the constructor for all fields - Professor(String name, double salary, String title)
It overrides the calculateBonus method to calculate the bonus for professors, which is 180% (1.8) of their base salary.

Your Task:
Implement the Employee, Assistant, and Professor classes as described.
* */

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return 0.0;
    }
}

class Assistant extends Employee {
    private int yearsOfExperience;

    public Assistant(String name, double salary, int yearsOfExperience) {
        super(name, salary);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * this.yearsOfExperience * 1.1;
    }
}

class Professor extends Employee {
    private String title;

    public Professor(String name, double salary, String title) {
        super(name, salary);
        this.title = title;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * 1.8;
    }
}

class Q2Tests {
    public static void main(String[] args) {
        Professor professor = new Professor("Becir", 1000, "My title");
        Assistant assistant = new Assistant("Amila", 999, 1);

        Assistant aassistant = new Assistant("Adnann", 1892, 9);

        // 0.2
        System.out.println(professor.getName());

        // 0.2
        System.out.println(assistant.getSalary());

        // 0.3
        System.out.println(professor.calculateBonus());

        // 0.1
        System.out.println(assistant.calculateBonus());

        // 0.2
        System.out.println(aassistant.calculateBonus());
    }
}
