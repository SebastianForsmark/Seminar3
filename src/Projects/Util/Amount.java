package Projects.Util;


public class Amount {
    int amount;
    String currency;

    public Amount(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
