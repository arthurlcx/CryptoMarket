package cryptomarket;
public class Wallet {
    private double bitcoinCount;
    private double ethereumCount;
    private double litecoinCount;
    private double rippleCount;
    private double dashCount;
    private double bitcoinCashCount;
    private double bitcoinGoldCount;
    
    /**
     * no arg-constructor
     */
    public Wallet() {
        this.bitcoinCount = 0;
        this.ethereumCount = 0;
        this.litecoinCount = 0;
        this.rippleCount = 0;
        this.dashCount = 0;
        this.bitcoinCashCount = 0;
        this.bitcoinGoldCount = 0;
    }
    
    /***
     * 
     * @param bitcoinCount number of bitcoin
     * @param ethereumCount number of ethereum
     * @param litecoinCount number of litecoin
     * @param rippleCount number of ripple
     * @param dashCount number of dash
     * @param bitcoinCashCount number of bitcoin cash
     * @param bitcoinGoldCount number of bitcoin gold
     */
    public Wallet(double bitcoinCount, double ethereumCount, double litecoinCount, double rippleCount, double dashCount, double bitcoinCashCount, double bitcoinGoldCount) {
        this.bitcoinCount = bitcoinCount;
        this.ethereumCount = ethereumCount;
        this.litecoinCount = litecoinCount;
        this.rippleCount = rippleCount;
        this.dashCount = dashCount;
        this.bitcoinCashCount = bitcoinCashCount;
        this.bitcoinGoldCount = bitcoinGoldCount;
    }
    
    @Override
    public String toString() {
        
        return "Bitcoin \t\t" + String.format("%.6f",bitcoinCount) + "\nEthereum \t\t" + String.format("%.6f",ethereumCount) + "\nLitecoin \t\t" + String.format("%.6f",litecoinCount) + "\nRipple \t\t\t" + String.format("%.6f",rippleCount) + "\nDash \t\t\t" + String.format("%.6f",dashCount) + "\nBitcoin Cash \t\t" + String.format("%.6f",bitcoinCashCount) + "\nBitcoin Gold \t\t" + String.format("%.6f",bitcoinGoldCount);
    }

    /**
     * @return the bitcoinCount
     */
    public double getBitcoinCount() {
        return bitcoinCount;
    }

    /**
     * @param bitcoinCount the bitcoinCount to set
     */
    public void setBitcoinCount(double bitcoinCount) {
        this.bitcoinCount = bitcoinCount;
    }

    /**
     * @return the ethereumCount
     */
    public double getEthereumCount() {
        return ethereumCount;
    }

    /**
     * @param ethereumCount the ethereumCount to set
     */
    public void setEthereumCount(double ethereumCount) {
        this.ethereumCount = ethereumCount;
    }

    /**
     * @return the litecoinCount
     */
    public double getLitecoinCount() {
        return litecoinCount;
    }

    /**
     * @param litecoinCount the litecoinCount to set
     */
    public void setLitecoinCount(double litecoinCount) {
        this.litecoinCount = litecoinCount;
    }

    /**
     * @return the rippleCount
     */
    public double getRippleCount() {
        return rippleCount;
    }

    /**
     * @param rippleCount the rippleCount to set
     */
    public void setRippleCount(double rippleCount) {
        this.rippleCount = rippleCount;
    }

    /**
     * @return the dashCount
     */
    public double getDashCount() {
        return dashCount;
    }

    /**
     * @param dashCount the dashCount to set
     */
    public void setDashCount(double dashCount) {
        this.dashCount = dashCount;
    }

    /**
     * @return the bitcoinCashCount
     */
    public double getBitcoinCashCount() {
        return bitcoinCashCount;
    }

    /**
     * @param bitcoinCashCount the bitcoinCashCount to set
     */
    public void setBitcoinCashCount(double bitcoinCashCount) {
        this.bitcoinCashCount = bitcoinCashCount;
    }

    /**
     * @return the bitcoinGoldCount
     */
    public double getBitcoinGoldCount() {
        return bitcoinGoldCount;
    }

    /**
     * @param bitcoinGoldCount the bitcoinGoldCount to set
     */
    public void setBitcoinGoldCount(double bitcoinGoldCount) {
        this.bitcoinGoldCount = bitcoinGoldCount;
    }
}
