package cryptomarket;
public class SellCrypto extends CryptoTransaction implements Taxable{
    private double sellPrice;
    
    /***
     * constructor
     * @param accountBalance current account balance
     * @param quantity amount of coins sold
     * @param sellPrice current selling price
     */
    public SellCrypto(double accountBalance, double quantity, double sellPrice) {
        super(accountBalance, quantity);
        this.sellPrice = sellPrice;
    }
    
    /**
     *
     * @return updated balance after the paid
     */
    @Override
    public double calculateBalance(){
        return getAccountBalance() + (sellPrice * getQuantity());
    }
    
    /***
    * 
    * @return 4% transaction fee
    */
    @Override
    public double chargeTax(){
        return sellPrice * getQuantity() * 0.04;
    }

    /**
     * @return the sellPrice
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * @param sellPrice the sellPrice to set
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
