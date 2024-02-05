package ba.edu.ibu.exams.midterms.midterm2.interfaces;

import java.util.HashMap;


/*

You are tasked with designing a system that models both financial and biological activities for
individuals. The system should utilize interfaces to represent distinct functionalities,
and a class to implement these interfaces, allowing individuals to perform activities
related to breathing and making payments.

Interfaces:
    - Define two interfaces: Breathable and Payment.
    - The Breathable interface should declare a method breath() that returns a
      String indicating the act of breathing.
    - The Payment interface should declare a method makePayment(String date, double amount)
    that records a financial transaction.

Human Class:

- Create a class named Human that implements both the Breathable and Payment interfaces.
    Include private attributes:
        - String fullName to store the full name of the individual.
        - HashMap<String, Double> payments to store financial transactions with corresponding dates.
- Implement a constructor that initializes the attributes.
- Implement the breath() method to return the string "Breathing".
- Implement the makePayment(String date, double amount) method to record financial transactions
  on a certain date. (There can be multiple payments for a single day)
- Implement a method called getPayment(String date) that returns the total amount of money on the give day.
 */
interface Breathable {
    String breath();
}

interface Payment {
    void makePayment(String date, double amount);
}

class Human implements Breathable, Payment {
    private String fullName;
    private HashMap<String, Double> payments;

    public Human(String fullName) {
        this.fullName = fullName;
        this.payments = new HashMap<>();
    }

    @Override
    public String breath() {
        return "Breathing";
    }

    @Override
    public void makePayment(String date, double amount) {
        if (payments.containsKey(date)) {
            double currentAmount = payments.get(date);
            payments.put(date, currentAmount + amount);
        } else {
            payments.put(date, amount);
        }
    }

    public double getPayment(String date) {
        return payments.get(date);
    }
}

class InterfaceMidterm {

    public static void main(String[] args) {
        Human human = new Human("Becir Isakovic");
        System.out.println(human.breath());

        human.makePayment("20", 100.0);
        human.makePayment("20", 200.0);
        System.out.println(human.getPayment("20"));

        Human secondHuman = new Human("Amila Causevic");
        String secondOutput = secondHuman.breath();
        secondHuman.makePayment("2023-11-03", 83.0);
        secondHuman.makePayment("2023-11-03", 91.0);
        secondHuman.makePayment("2023-12-03", 200.0);
        System.out.println(secondHuman.getPayment("2023-11-03"));
    }

}
