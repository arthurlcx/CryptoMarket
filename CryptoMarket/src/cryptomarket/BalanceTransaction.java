package cryptomarket;
public abstract class BalanceTransaction {
    private double accountBalance;
    private double amount;
    
    /***
     * BalanceTransaction
     */
    public BalanceTransaction() {
        this.accountBalance = 0;
        this.amount = 0;
    }
    
    /***
     * 
     * @param accountBalance current account balance
     * @param amount amount to deposit or withdraw
     */
    public BalanceTransaction(double accountBalance, double amount) {
        this.accountBalance = accountBalance;
        this.amount = amount;
    }
    
    public abstract double getBalance();

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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
