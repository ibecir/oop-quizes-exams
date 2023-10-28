package ba.edu.ibu.quiz2;

/**
 Write a class called Card that will have three attributes: cardNo of type String, balance of type int and enum attribute CardIssuer
 (attribute name is cardIssuer), values of the CardIssuer enum are: MASTERCARD, AMERICAN_EXPRESS. Create getters and setters for all
 the attributes. Create three constructors: first that accepts and sets the value of the cardNo attribute, second that accepts the and
 sets the balance attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed.
 Create one more method called depositMoney of the return type String that returns "Card deposit" upon calling.

 Create one more class called CreditCard that inherits the Card class and has one more attribute of type int called loanLimit and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field loanLimit and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method depositMoney so that
 for the CreditCard class it returns String "CreditCard deposit". Constructor for CreditCard class should receive parameter as follows:
 public CreditCard(String cardNo, int balance, CardIssuer cardType, int loanLimit)

 Create one more class called DebitCard that inherits the Card class and has one more attribute of type String called expiresAt and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field expiresAt and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the cardNo attribute). Also, override the
 method depositMoney so that for the DebitCard class it returns String "DebitCard balance".  Constructor for DebitCard should receive
 parameters as follows: public DebitCard(String cardNo, String expiresAt)
 * */

enum CardIssuer {
    MASTERCARD, AMERICAN_EXPRESS
}

class Card {
    private String cardNo;
    private int balance;
    private CardIssuer cardIssuer;

    public Card(String cardNo) {
        this.cardNo = cardNo;
    }

    public Card(int balance) {
        this.balance = balance;
    }

    public Card(String cardNo, int balance, CardIssuer cardIssuer) {
        this.cardNo = cardNo;
        this.balance = balance;
        this.cardIssuer = cardIssuer;
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

    public CardIssuer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public String depositMoney(){
        return "Card deposit";
    }
}

class CreditCard extends Card{
    private int loanLimit;

    public CreditCard(String cardNo, int balance, CardIssuer cardType, int loanLimit) {
        super(cardNo, balance, cardType);
        this.loanLimit = loanLimit;
    }

    public int getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(int loanLimit) {
        this.loanLimit = loanLimit;
    }

    @Override
    public String depositMoney(){
        return "CreditCard deposit";
    }
}

class DebitCard extends Card{
    private String expiresAt;

    public DebitCard(String cardNo, String expiresAt) {
        super(cardNo);
        this.expiresAt = expiresAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String depositMoney(){
        return "DebitCard deposit";
    }
}

class Smthing{
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard("123213", "02/25");
        System.out.println(debitCard.depositMoney());
    }
}
