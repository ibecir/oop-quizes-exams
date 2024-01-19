package ba.edu.ibu.exams.midterms.midterm2.interfaces;

import java.util.HashMap;


/*

Create a Java interface called Enrollable with an abstract method enroll().
Implement this interface in a class Student who enrolls in a course. The enroll() in Student should print “Enrolled in a course”.

Now, create another interface called Payment with an abstract method makePayment(String date, double amount).
Implement the Payment interface in the above Student class, allowing students to make payments.
There can be multiple payments for a single day.
Create a method called getPayment(String date) that returns the total amount on the give day.

Note: Use the hashmaps where the key is day and value is the amount
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
        String output = human.breath();
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
