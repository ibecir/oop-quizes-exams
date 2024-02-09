package ba.edu.ibu.exams.midterms.midterm3.interfaces;

import java.util.HashMap;
import java.util.Optional;

/*
Problem Statement: Activity Management System with Optional Handling

You are required to design a system that models both physical and financial activities for
individuals. The system should utilize interfaces to represent distinct functionalities and
a class to implement these interfaces, allowing individuals to perform activities related to
exercising and managing expenses.

Interfaces:

Define two interfaces: PhysicalActivity and FinancialActivity.
 - The PhysicalActivity interface should declare a method exercise() that returns a String indicating
the type of exercise.
 - The FinancialActivity interface should declare a method manageExpense(String date, double amount)
 that records a financial transaction and returns void.

Individual Class:

 - Create a class named Individual that implements both the PhysicalActivity and FinancialActivity interfaces.
    Include private attributes:
        name: String - to store the name of the individual.
        expenses: HashMap<String, Double> - to store financial transactions with corresponding dates.

 - Implement a constructor with one parameter Individual(String name) that initializes the name to the passed name value
and expenses to a new HashMap.

- Implement the exercise() method to return the string "Exercising".
- Implement the manageExpense(String date, double amount) method to record financial transactions on a certain date
and store them in the expenses property where key is date and value is amount of the transaction.
  NOTE - (There can be multiple expenses for a single day)

- Implement a method called getTotalExpense(String date) that returns an Optional<Double> representing the total amount of
money spent on the given day.

The objective of the system is to provide a comprehensive solution for individuals to manage both their physical activities
and financial expenses effectively, allowing them to track their exercises and expenses efficiently. The implementation
should handle potential null values gracefully using Java's Optional class.
* */

interface PhysicalActivity {
    String exercise();
}

interface FinancialActivity {
    void manageExpense(String date, double amount);
}

class Individual implements PhysicalActivity, FinancialActivity {
    private String name;
    private HashMap<String, Double> expenses;

    public Individual(String name) {
        this.name = name;
        this.expenses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String exercise() {
        return "Exercising";
    }

    @Override
    public void manageExpense(String date, double amount) {
        if (expenses.containsKey(date)) {
            double currentExpense = expenses.get(date);
            expenses.put(date, currentExpense + amount);
        } else {
            expenses.put(date, amount);
        }
    }

    public Optional<Double> getTotalExpense(String date) {
        return Optional.ofNullable(expenses.get(date));
    }
}

class ActivityManagement {
    public static void main(String[] args) {
        Individual individual = new Individual("John Doe");

        // Perform exercises
        System.out.println(individual.exercise());

        // Manage expenses
        individual.manageExpense("2024-02-08", 50.0);
        individual.manageExpense("2024-02-08", 30.0); // Additional expense on the same day
        individual.manageExpense("2024-02-09", 20.0);

        // Display total expenses for a specific day
        individual.getTotalExpense("2024-02-08").ifPresentOrElse(
                total -> System.out.println("Total expenses on 2024-02-08: $" + total),
                () -> System.out.println("No expenses recorded on 2024-02-08")
        );

        individual.getTotalExpense("2024-02-09").ifPresentOrElse(
                total -> System.out.println("Total expenses on 2024-02-09: $" + total),
                () -> System.out.println("No expenses recorded on 2024-02-09")
        );

        individual.getTotalExpense("2024-02-10").ifPresentOrElse(
                total -> System.out.println("Total expenses on 2024-02-10: $" + total),
                () -> System.out.println("No expenses recorded on 2024-02-10")
        );
    }
}
