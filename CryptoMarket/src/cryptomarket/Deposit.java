package cryptomarket;
public class Deposit extends BalanceTransaction{
    /***
     * 
     * @param accountBalance current account balance
     * @param amount amount to be deposited
     */
    public Deposit(double accountBalance, double amount) {
        super(accountBalance, amount);
    }
    
    /**
     *
     * @return updated balance after topping up account balance
     */
    @Override
    public double getBalance() {
        return getAccountBalance() + getAmount();
    }
    
}
