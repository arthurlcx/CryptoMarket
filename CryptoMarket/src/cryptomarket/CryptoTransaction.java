package cryptomarket;
public abstract class CryptoTransaction {
    
    private double accountBalance;
    private double quantity;
    
    public CryptoTransaction() {
        this.accountBalance = 0;
        this.quantity = 0;
    }
    
    public CryptoTransaction(double accountBalance, double quantity) {
        this.accountBalance = accountBalance;
        this.quantity = quantity;
    }
    
    /***
     * abstract class
     * @return 
     */
    public abstract double calculateBalance();

    /**
     * @return the deposit
     */
    
    /**
     * @return the accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    
}
