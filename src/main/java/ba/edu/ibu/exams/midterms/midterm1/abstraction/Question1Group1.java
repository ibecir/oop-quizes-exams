package ba.edu.ibu.exams.midterms.midterm1.abstraction;


/*

You are tasked with extending the functionality of a simple payment processing system.
The system includes an abstract class PaymentProcess and a concrete class CreditCardPayment
that extends the abstract class.

PaymentProcess Class:
The abstract class PaymentProcess has one abstract method:

 - void makePayment(double amount) - This method is responsible for processing a payment of the specified amount.
 The concrete implementation of this method should be provided in the derived class.

CreditCardPayment Class:
The CreditCardPayment class extends the PaymentProcess abstract class and has the following attributes:

 - private double balance - Represents the current balance in the credit card account.
 - private String processor - Represents the payment processor associated with the credit card.

The class has the following methods:

    public CreditCardPayment(String processor) - Constructor that initializes the payment processor and sets the balance to 0.0.
    public double currentBalance() - Returns the current balance in the credit card account.
    void makePayment(double amount) - Overrides the abstract method from the PaymentProcess class. It processes a payment by
    updating the balance and printing a message "Payment of $X processed." where te X is the payment amount.



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
