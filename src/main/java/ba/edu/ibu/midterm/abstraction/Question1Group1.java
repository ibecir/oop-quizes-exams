package ba.edu.ibu.midterm.abstraction;


/*

Create an abstract class called PaymentProcess with an abstract method makePayment(double amount).

Extend this abstract class in a class called CreditCardPayment, add a variable balance of type double and processor of type String.
Create a construction that will accept the processor as a parameter.

Implement the makePayment() method in the CreditCardPayment class, adding the amount to the balance and printing "Payment of $X processed.".

Create a method called currentBalance() that returns the current balance.


 */
abstract class PaymentProcess {
    abstract void makePayment(double amount);
}

class CreditCardPayment extends PaymentProcess {
    private double balance;
    private String processor;

    public CreditCardPayment(String processor) {
        this.processor = processor;
        this.balance = 0.0;
    }

    public double currentBalance() {
        return balance;
    }

    @Override
    void makePayment(double amount) {
        balance += amount;
        System.out.println("Payment of $" + amount + " processed.");
    }


}

public class Question1Group1 {
    public static void main(String[] args) {
        CreditCardPayment creditCardPayment = new CreditCardPayment("clickbank");
        creditCardPayment.makePayment(50.0);
        creditCardPayment.makePayment(50.0);
        creditCardPayment.makePayment(50.0);

        System.out.println(creditCardPayment.currentBalance());
    }
}
