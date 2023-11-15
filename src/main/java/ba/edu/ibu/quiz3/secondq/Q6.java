package ba.edu.ibu.quiz3.secondq;

abstract class Card {
    private String cardNo;
    private int balance;

    public Card(String cardNo, int balance) {
        this.cardNo = cardNo;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public abstract String makePayment();

    public int pay() {
        return 100;
    }
}

class CreditCard extends Card {
    private int limit;

    public CreditCard(String cardNo, int balance, int limit) {
        super(cardNo, balance);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String makePayment() {
        return "CC payment";
    }
}

class DebitCard extends Card {
    private int cvc;

    public DebitCard(String cardNo, int balance, int cvc) {
        super(cardNo, balance);
        this.cvc = cvc;
    }

    @Override
    public String makePayment() {
        return "DC payment";
    }
}

class Bank<T extends Card> {
    private T card;

    public Bank(T card) {
        this.card = card;
    }

    public T getCard() {
        return card;
    }

    public void setCard(T card) {
        this.card = card;
    }
}

class C6 {
    public static void main(String[] args) {
        Bank<CreditCard> creditCardBank = new Bank<>(new CreditCard("12345", 120, 1000));
        Bank<DebitCard> debitCardBank = new Bank<>(new DebitCard("789", 77, 3000));

        System.out.println(creditCardBank.getCard().pay());
        System.out.println(creditCardBank.getCard().makePayment());
        System.out.println(debitCardBank.getCard().makePayment());
    }
}