package ba.edu.ibu.quiz3.second;

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
