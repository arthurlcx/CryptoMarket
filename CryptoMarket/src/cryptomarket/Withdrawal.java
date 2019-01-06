package cryptomarket;
public class Withdrawal extends BalanceTransaction implements Taxable, Comparable{
    /***
     * 
     * @param accountBalance current account balance
     * @param amount amount to be withdrew
     */
    public Withdrawal(double accountBalance, double amount) {
        super(accountBalance, amount);
    }
    
    /**
     *
     * @return updated balance after withdrawal
     */
    @Override
    public double getBalance() {
        return getAccountBalance() - getAmount() - chargeTax();
    }
    
    /**
     *
     * @return 4% transaction fees
     */
    @Override
    public double chargeTax(){
        return getAmount() * 0.04;
    }
    
    public int compareTo(Object o) {
        if (getAccountBalance() >= ((double)o)) {
            return 1;
        } else {
            return 0;
        }
    }
}
