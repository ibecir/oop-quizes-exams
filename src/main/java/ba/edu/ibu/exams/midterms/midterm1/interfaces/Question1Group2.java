package ba.edu.ibu.exams.midterms.midterm1.interfaces;

import java.util.HashMap;


/*

Create a Java interface called Course with an abstract method teach().
Implement this interface in a class Teacher who teaches in a course. The teach() in Teacher should print “Teaching in a course”.

Now, create another interface called Salary with an abstract method receivePayment(String date, double amount).
Implement the Salary interface in the above Teacher class, allowing teachers to receive payment.
There can be multiple payments for a single day.
Create a method called getAllPayments(String date) that returns the total amount on the give day.
Create a method called countAllPayments() that returns the number of all payments ever received.

 */
interface Course {
    void teach();
}

interface Salary {
    void receivePayment(String date, double amount);
}

class Teacher implements Course, Salary {
    private HashMap<String, Double> payments;

    public Teacher() {
        payments = new HashMap<>();
    }

    @Override
    public void teach() {
        System.out.println("Teaching in a course");
    }

    @Override
    public void receivePayment(String date, double amount) {
        if (payments.containsKey(date)) {
            double currentAmount = payments.get(date);
            payments.put(date, currentAmount + amount);
        } else {
            payments.put(date, amount);
        }
    }

    public double getAllPayments(String date) {
        return payments.get(date);
    }
    public int countAllPayments() {
        return payments.size();
    }
}

class Question1Group2 {

    public static void main(String[] args) {

        // test ONE
        Teacher teacher = new Teacher();
        teacher.teach();
        teacher.receivePayment("2023-01-01", 100.0);
        teacher.receivePayment("2023-01-01", 200.0);
        teacher.receivePayment("2023-01-02", 200.0);
        System.out.println(teacher.getAllPayments("2023-01-01"));


        // test TWO
        Teacher teacher2 = new Teacher();
        teacher2.teach();
        teacher2.receivePayment("2023-01-01", 100.0);
        teacher2.receivePayment("2023-01-02", 200.0);
        System.out.println(teacher2.countAllPayments());
    }

}
