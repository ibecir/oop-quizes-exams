package ba.edu.ibu.quiz2;

enum CardType {
    MASTERCARD, AMERICAN_EXPRESS
}

class Card {
    private String cardNo;
    private int balance;
    private CardType cardType;

    public Card(String cardNo) {
        this.cardNo = cardNo;
    }

    public Card(int balance) {
        this.balance = balance;
    }

    public Card(String cardNo, int balance, CardType cardType) {
        this.cardNo = cardNo;
        this.balance = balance;
        this.cardType = cardType;
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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String depositMoney(){
        return "Card deposit";
    }
}

class CreditCard extends Card{
    private int loanLimit;

    public CreditCard(String cardNo, int balance, CardType cardType, int loanLimit) {
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
