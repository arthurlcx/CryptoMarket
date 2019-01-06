package cryptomarket;
public class Cryptocurrency {
    private String cryptoName;
    private double cryptoYesterdayPrice;
    private double cryptoTodayPrice;
    private double crypto24hVolume;
    
    /***
     * no arg-constructor
     */
    public Cryptocurrency() {
        this.cryptoName = "";
        this.cryptoTodayPrice = 0;
        this.cryptoYesterdayPrice = 0;
        this.crypto24hVolume = 0;
    }
    
    /***
     * 
     * @param cryptoName cryptocurrency name
     * @param cryptoYesterdayPrice yesterday's open price
     * @param cryptoTodayPrice today's open price
     * @param crypto24hVolume 24 hours coin volume
     */
    public Cryptocurrency (String cryptoName, double cryptoYesterdayPrice, double cryptoTodayPrice, double crypto24hVolume) {
        this.cryptoName = cryptoName;
        this.cryptoYesterdayPrice = cryptoYesterdayPrice;
        this.cryptoTodayPrice = cryptoTodayPrice;
        this.crypto24hVolume = crypto24hVolume;
    }

    /***
     * 
     * @return the difference between today's price with yesterday price
     */
    public double getDailyChanges() {
        return getCryptoTodayPrice() - getCryptoYesterdayPrice();
    }    
    
    /***
     * 
     * @return the rate of change in the price for the last 24hours
     */
    public double getRateOfChange() {
        return (getDailyChanges() / getCryptoYesterdayPrice()) * 100;
    }
    
    /***
     * 
     * @return market buying price 
     */
    public double getBuyPrice() {
        return getCryptoTodayPrice() * 1.02;
    }
    
    /***
     * 
     * @return market selling price
     */
    public double getSellPrice() {
        return getCryptoTodayPrice() * 0.98;
    }
    
    /***
     * 
     * @return recommendation based on the daily 24hour rate of change
     */
    public String getBuySellRemark() {
        if (getRateOfChange() > 10 ) {
            return "Recommend to sell.";
        } else if (getRateOfChange() < -10) {
            return "Recommend to buy.";
        } else {
            return "HOLD";
    }
    }
    
    @Override
    public String toString() {
        return cryptoName + "\t" + String.format("%.2f", cryptoTodayPrice) + "\t" + String.format("%.2f", getDailyChanges()) + "\t" + String.format("%.4f", getRateOfChange()) + "\t" +crypto24hVolume;
    }

    /**
     * @return the cryptoName
     */
    public String getCryptoName() {
        return cryptoName;
    }

    /**
     * @param cryptoName the cryptoName to set
     */
    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    /**
     * @return the cryptoYesterdayPrice
     */
    public double getCryptoYesterdayPrice() {
        return cryptoYesterdayPrice;
    }

    /**
     * @param cryptoYesterdayPrice the cryptoYesterdayPrice to set
     */
    public void setCryptoYesterdayPrice(double cryptoYesterdayPrice) {
        this.cryptoYesterdayPrice = cryptoYesterdayPrice;
    }

    /**
     * @return the cryptoTodayPrice
     */
    public double getCryptoTodayPrice() {
        return cryptoTodayPrice;
    }

    /**
     * @param cryptoTodayPrice the cryptoTodayPrice to set
     */
    public void setCryptoTodayPrice(double cryptoTodayPrice) {
        this.cryptoTodayPrice = cryptoTodayPrice;
    }

    /**
     * @return the crypto24hVolume
     */
    public double getCrypto24hVolume() {
        return crypto24hVolume;
    }

    /**
     * @param crypto24hVolume the crypto24hVolume to set
     */
    public void setCrypto24hVolume(double crypto24hVolume) {
        this.crypto24hVolume = crypto24hVolume;
    }

    
}
