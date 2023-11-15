package ba.edu.ibu.midterm.interfaceHashmap;

import java.util.HashMap;


/*

Create a Java interface called Enrollable with an abstract method enroll().
Implement this interface in a class Student who enrolls in a course. The enroll() in Student should print “Enrolled in a course”.

Now, create another interface called Payment with an abstract method makePayment(String date, double amount).
Implement the Payment interface in the above Student class, allowing students to make payments.
There can be multiple payments for a single day.
Create a method called getPayment(String date) that returns the total amount on the give day.

 */
interface Enrollable {
    void enroll();
}

interface Payment {
    void makePayment(String date, double amount);
}

class Student implements Enrollable, Payment {
    private HashMap<String, Double> payments;

    public Student() {
        payments = new HashMap<>();
    }

    @Override
    public void enroll() {
        System.out.println("Enrolled in a course");
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

class Question1Group1 {

    public static void main(String[] args) {
        Student student = new Student();
        student.enroll();
        student.makePayment("20", 100.0);
        student.makePayment("20", 200.0);
        System.out.println(student.getPayment("20"));
    }

}
