package cryptomarket;
public class User {
    private String name;
    private String publicAddress;
    private String privateAddress;
    private Wallet wallet;
    private double accountBalance;
    
    /***
     * User no arg-constructor
     */
    public User() {
    this.name = "";
    this.publicAddress = "";
    this.privateAddress = "";
    this.wallet = new Wallet();
    this.accountBalance = 0;
    }
    
    /***
     * 
     * @param name user name
     * @param publicAddress user wallet public address
     * @param privateAddress user wallet private address
     * @param wallet user wallet with coins inside
     * @param accountBalance user account balance
     */
public User (String name, String publicAddress, String privateAddress, Wallet wallet, double accountBalance) {
    this.name = name;
    this.publicAddress = publicAddress;
    this.privateAddress = privateAddress;
    this.wallet = wallet;
    this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
    return "Name: " + name + "\nAccount Balance: " +String.format("%.2f", accountBalance)
     + "\nPublic Wallet Address: " + publicAddress + "\nPrivate Wallet Address: " + privateAddress;
}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the publicAddress
     */
    public String getPublicAddress() {
        return publicAddress;
    }

    /**
     * @param publicAddress the publicAddress to set
     */
    public void setPublicAddress(String publicAddress) {
        this.publicAddress = publicAddress;
    }

    /**
     * @return the privateAddress
     */
    public String getPrivateAddress() {
        return privateAddress;
    }

    /**
     * @param privateAddress the privateAddress to set
     */
    public void setPrivateAddress(String privateAddress) {
        this.privateAddress = privateAddress;
    }

    /**
     * @return the wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

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
}
