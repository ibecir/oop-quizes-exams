package ba.edu.ibu.quiz3.second;
/*Create and interface called Payable that has one abstract method called pay that returns int.

Create class called DebitCard that has one property called cardNo of type String. This class should
implement the interface Payable and implement the method pay, so it returns the value 100 of the
cardNo property for the DebitCard class instance. Provide the constructor that gets and sets the value
of that property and implement the get and set methods for that property.

Create class called CreditCard that has one property called limit of type int. This class should
implement the interface Payable and implement the method pay, so it returns the value 10000 of limit
property for the CreditCard class instance. Provide the constructor that gets and sets the value of
that property and implement the get and set methods for that property.
*/
interface Payable {
    public int pay();
}

class DebitCard implements Payable {
    private String cardNo;

    public DebitCard(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public int pay() {
        return 100;
    }
}

class CreditCard implements Payable {
    private int limit;

    public CreditCard(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public int pay() {
        return 10000;
    }
}

class C6 {
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard("123123");
        CreditCard creditCard = new CreditCard(10000);

        System.out.println(debitCard.pay());
        System.out.println(creditCard.pay());
    }
}
