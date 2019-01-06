package cryptomarket;
public class BuyCrypto extends CryptoTransaction{
    private double buyPrice;
    private double deposit;
    
    /***
     * constructor
     * @param accountBalance current account balance
     * @param quantity amount of coins purchased
     * @param buyPrice current buy price
     * @param deposit investment amount
     */
    public BuyCrypto(double accountBalance, double quantity, double buyPrice, double deposit){
        super(accountBalance, quantity);
        this.buyPrice = buyPrice;
        this.deposit = deposit;
    }
    /***
     * calculate the latest account balance
     * @return 
     */
    public double calculateBalance(){
        return getAccountBalance()- (buyPrice * getQuantity());
    }

    /**
     * @return the buyPrice
     */
     // Buy Price 
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice the buyPrice to set
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * @return the deposit
     */
    public double getDeposit() {
        return deposit;
    }

    /**
     * @param deposit the deposit to set
     */
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

   
}
