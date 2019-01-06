package cryptomarket;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintStream;

public class CryptoMarket {
    static Cryptocurrency[] cryptocurrency;
    static User[] user;
    static Wallet[] wallet;
    static Random random;
    static Scanner scanner;
    static boolean endSystem = false;
    static int userNumber = 0;
    
    public static void main(String[] args) {
        generateCryptocurrency();
        initialiseUserAndWallet();
        // Prompt Login Page 
        login();
        //Show Crypto Market
        do {
        printCryptoMarket();
        
        scanner = new Scanner(System.in);
        System.out.println("\nMain Menu\n===================");
        System.out.println("1. Transaction \n2. View Wallet \n3. Manage Balance \n4. Exit");
        System.out.print("Enter your choice: ");
        int mainMenuChoice = scanner.nextInt();
        
        //Choose MAIN MENU option
        switch(mainMenuChoice) {
            case 1: 
                System.out.println("\nTRANSACTION************************\n1. Buy Cryptocurrency \n2. Sell Cryptocurrency");
                System.out.print("Enter choice: ");
                int transactionChoice = scanner.nextInt();
                
                switch(transactionChoice) {
                    case 1:
                        toBuy();
                        endSystem = backMainMenuPrompt();
                        break;
                    case 2:
                        toSell();
                        endSystem = backMainMenuPrompt();
                        break;
                    default:
                        System.out.println("Invalid input.");
                        endSystem = backMainMenuPrompt();
                }
                break;
            case 2:
                System.out.println("\nWALLET\n==============");
                System.out.println(user[userNumber].toString());
                System.out.println("\nCryptocurrency \t Number Of Coins You Own\n=============== =========================");
                System.out.println(wallet[userNumber].toString());

                endSystem = backMainMenuPrompt();
                break;
            case 3:
                System.out.println("\nMANAGE BALANCE\n************************\n1. Deposit Fund \n2. Withdraw Fund");
                System.out.print("Enter choice: ");
                int balanceChoice = scanner.nextInt();
                
                switch(balanceChoice) {
                    case 1:
                        toDeposit();
                        break;
                    case 2:
                        toWithdraw();
                        break;
                    default:
                        System.out.println("Invalid input.");
                        endSystem = backMainMenuPrompt();
                }
                endSystem = backMainMenuPrompt();
                break;
            case 4:
                System.out.println("Goodbye");
                endSystem = true;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                endSystem = backMainMenuPrompt();
        }
        } while (endSystem == false);
        
        
    }
    /***
     * To initialize user PROFILE and user WALLET array.
     */
    public static void initialiseUserAndWallet() {
        user = new User[2];
        wallet = new Wallet[2];
        
        wallet[0] = new Wallet(10, 4, 0, 0, 7, 1, 1);
        
        user[0] = new User("Chee Li Jia", "1G3QHeJJmAj2ooCYcwH2ncVZ38KSvUTw9Y", "L1fcpNE4wXFnnUPXvr12RnoQi5WXZoi5tp7FoZRVjQcUksYCkTLT" , wallet[0], 10000);
    }
    /***
     * Initialize all 7 cryptocurrencies in Cryptocurrency array.
     */
    public static void generateCryptocurrency() {
        cryptocurrency = new Cryptocurrency[7];
        
        cryptocurrency[0] = new Cryptocurrency("Bitcoin ", generateRandomMarketRate(72706.13), generateRandomMarketRate(73154.25), generateRandomMarketRate(1204.37155203));
        cryptocurrency[1] = new Cryptocurrency("Ethereum", generateRandomMarketRate(4145.85), generateRandomMarketRate(4313.30), generateRandomMarketRate(6348.00839900));
        cryptocurrency[2] = new Cryptocurrency("Litecoin", generateRandomMarketRate(967.63), generateRandomMarketRate(902.12), generateRandomMarketRate(479824));
        cryptocurrency[3] = new Cryptocurrency("Ripple  ", generateRandomMarketRate(10.63), generateRandomMarketRate(11.43), generateRandomMarketRate(5488652.412175));
        cryptocurrency[4] = new Cryptocurrency("Dash    ", generateRandomMarketRate(4721.05), generateRandomMarketRate(4920.92), generateRandomMarketRate(613.21845516));
        cryptocurrency[5] = new Cryptocurrency("Bitcoin Cash", generateRandomMarketRate(10269.03), generateRandomMarketRate(10833.80), generateRandomMarketRate(1129.46906146));
        cryptocurrency[6] = new Cryptocurrency("Bitcoin Gold", generateRandomMarketRate(1049.33), generateRandomMarketRate(1083.32), generateRandomMarketRate(2404.72941660));
    }
    /***
     * Generate prices for each cryptocurrencies by multiplying a fixed value with a set of randomly generated number between 0.5 to 1.5. 
     * Creating fluctuating cryptocurrency prices all the time.
     * @param amount a reference cryptocurrency market price from the real market
     * @return fluctuated cryptocurrency price
     */
    public static double generateRandomMarketRate(double amount) {
        random = new Random();
        
        double rate = random.nextDouble() * (1.0) + 0.50;
        return amount*rate;
    } 
    /***
     * Print a table with a list of cryptocurrency prices, change rate and volume in stimulated market
     */
    public static void printCryptoMarket() {
        System.out.println("\nMARKET\n********************************************************************************************************************************");
        System.out.printf("%20s %20s %20s %20s %20s %20s", "Cryptocurrency", "Today's Open(RM)", "Daily Change(RM)", "24h Change(%)", "24h Volume", "Buy Or Sell Remark");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------");
                
        for (Cryptocurrency cryptocurrency1 : cryptocurrency) {
            System.out.format("%20s %20s %20s %20s %20s %20s", cryptocurrency1.getCryptoName(), String.format("%.2f", cryptocurrency1.getCryptoTodayPrice()), String.format("%.2f", cryptocurrency1.getDailyChanges()), String.format("%.4f", cryptocurrency1.getRateOfChange()),String.format("%.6f",cryptocurrency1.getCrypto24hVolume()), cryptocurrency1.getBuySellRemark());
            System.out.println();
        }
    }
    /***
     * Print a table of cryptocurrency with its respective buy price. Buy price is greater than market price by 2%
     */
    public static void printBuyMarket() {
        System.out.println("\nBUY MARKET\n**************************************************************");
        System.out.printf("%20s %20s %20s", "Cryptocurrency", "Buy Price(RM)", "24h Volume");
        System.out.println("\n--------------------------------------------------------------");
        for (Cryptocurrency cryptocurrency1 : cryptocurrency) {
            System.out.format("%20s %20s %20s", cryptocurrency1.getCryptoName(), String.format("%.2f",cryptocurrency1.getBuyPrice()), String.format("%.6f",cryptocurrency1.getCrypto24hVolume()));
            System.out.println();
        }
        
    }
    /***
     * Print a table of cryptocurrency with its respective sell price. Sell price is lower than market price by 2%
     */
    public static void printSellMarket() {
        System.out.println("\nSELL MARKET\n****************************************************");
        System.out.printf("%20s %20s", "Cryptocurrency", "Sell Price(RM)", "24h Volume");
        System.out.println("\n----------------------------------------------------");
        for (Cryptocurrency cryptocurrency1 : cryptocurrency) {
            System.out.format("%20s %20s", cryptocurrency1.getCryptoName(), String.format("%.2f", cryptocurrency1.getSellPrice()));
            System.out.println();
        }
    }
    /***
     * Method to buy Cryptocurrency
     */
    public static void toBuy() {
        scanner = new Scanner(System.in);
        printBuyMarket();
        
        System.out.println("\nSelect cryptocurrency\n----------------");
        for(int i = 0; i < cryptocurrency.length; i++) {
            System.out.println((i+1) + ". " + cryptocurrency[i].getCryptoName());
        }
        System.out.print("Enter choice: ");
        int cryptoChoice = scanner.nextInt();
        System.out.print("Deposit Amount: ");
        double deposit = scanner.nextDouble();
        
        roiPrediction(cryptoChoice - 1, deposit);
        
        double quantity = (deposit / cryptocurrency[cryptoChoice - 1].getBuyPrice());
        
        System.out.print("Proceed to purchase? (Y/N)" + "\nEnter Your Choice : ");
        scanner = new Scanner(System.in);
        String purchaseChoice = scanner.nextLine();
        purchaseChoice = purchaseChoice.toUpperCase();
        
        if (purchaseChoice.equals("Y")) {
            boolean paymentStatus = false;
            do {
             System.out.println("\nSelect payment method\n==========================");
             System.out.println("1. Purchase with account balance. \n2. Purchase with credit/debit card");
             int methodChoice = scanner.nextInt();
             if (methodChoice == 1) {
                     if (user[userNumber].getAccountBalance() > deposit) {
                        accountPaymentMethod(cryptoChoice - 1, deposit, quantity);
                        paymentStatus = true; //payment approved
                     } else {
                        System.out.println("Insufficient fund to purchase. Please try another method.");
                        paymentStatus = false; //payment declined
                     }
             } else if (methodChoice == 2) {
                     
                     paymentStatus = cardPaymentMethod();

             }
            } while (paymentStatus == false); //loop as long as payment method is being declined, otherwise proceed
             
             switch(cryptoChoice) {
                case 1:
                    wallet[userNumber].setBitcoinCount(wallet[userNumber].getBitcoinCount() + quantity);
                    break;
                case 2:
                    wallet[userNumber].setEthereumCount(wallet[userNumber].getEthereumCount() + quantity);
                    break;
                case 3:
                    wallet[userNumber].setLitecoinCount(wallet[userNumber].getLitecoinCount() + quantity);
                    break;
                case 4:
                    wallet[userNumber].setRippleCount(wallet[userNumber].getRippleCount() + quantity);
                    break;
                case 5:
                    wallet[userNumber].setDashCount(wallet[userNumber].getDashCount() + quantity);
                    break;
                case 6:
                    wallet[userNumber].setBitcoinCashCount(wallet[userNumber].getBitcoinCashCount() + quantity);
                    break;
                default:
                    wallet[userNumber].setBitcoinGoldCount(wallet[userNumber].getBitcoinGoldCount() + quantity);
            }       
            
            System.out.println("\n.\n.\n.\nTransaction Successful.");
        }
    }
    /***
     * Run our ROI prediction algorithm. Gather the 24Hour change rate for the pass 30 days and calculate the average 24H change rate. 
     * Then multiply with today's price to predict the change rate 30 days later
     * @param cryptoChoice type of crypocurrency coin selected by buyer
     * @param deposit amount of cash the buyer wishes to invest
     */
    public static void roiPrediction(int cryptoChoice, double deposit) {
        random = new Random();
        double totalPrice = 0;
        double nextPrice = cryptocurrency[cryptoChoice].getCryptoTodayPrice();
         for(int i=0 ; i<30 ; i++)
        {
            double percent = (0.5 + (1.5 - (0.5)) * random.nextDouble());
            double temp = (nextPrice * percent);
            totalPrice += temp;
            nextPrice = temp;
        }
        
        double predictPercent = (totalPrice / 30) / cryptocurrency[cryptoChoice].getCryptoTodayPrice();
        
        double payback = predictPercent * deposit;

        if(predictPercent > 1.0) {
            System.out.println("\nPositive ROI. RECOMMEMDED FOR SHORT TERM INVESMENT.");
        }else {
            System.out.println("\nNegative ROI. NOT RECOMMENDED FOR SHORT TERM INVESTMENT.");
        }
                
        System.out.println ("Potential ROI percentage in next 30 days is " + String.format("%.2f",(-(1-predictPercent) * 100))+ "%");
        System.out.println ("Potential ROI in the next 30 DAYS for investing in " + cryptocurrency[cryptoChoice].getCryptoName() + "is RM " + String.format("%.2f",(payback - deposit)) );
        System.out.println("\nDeposit: RM " + deposit);
        System.out.println("Purchasable Unit: " + String.format("%.6f",(deposit / cryptocurrency[cryptoChoice].getBuyPrice())));
    }
    
    /***
     * Pay crpytocurrency with available account balance currently
     * @param cryptoChoice buyer's crypto choice
     * @param deposit amount of investment buyer wishes to invest
     * @param quantity the amount of coin to be purchased
     */
    public static void accountPaymentMethod(int cryptoChoice, double deposit, double quantity) {
         BuyCrypto buyCrypto = new BuyCrypto(user[userNumber].getAccountBalance(), quantity, cryptocurrency[cryptoChoice].getBuyPrice(), deposit);
         //update account balance
            user[userNumber].setAccountBalance(buyCrypto.calculateBalance());
            
    }
    /***
     * validate credit/debit card
     * @return validation of the card, TRUE = valid. FALSE = invalid
     */
    public static boolean cardPaymentMethod() 
    {
       Scanner scn= new Scanner(System.in);
       String answer;
       do {
           
       
       System.out.print("Enter your credit card number : " );
       int cardNumber = scn.nextInt();
       // 8 digits Card Number Validation Check 
       //Rule 1
       String strcardNumber = cardNumber + "";  //make it become string
       int total= 0;
       for(int i=1 ; i<strcardNumber.length() ; i=i+2){
           char charValue = strcardNumber.charAt(i);
           total += Integer.parseInt(charValue+"");
       }
        
       
       int total2 = 0;
       for(int i=0 ; i<strcardNumber.length() ; i=i+2){
           char charValue = strcardNumber.charAt(i);
           int number = Integer.parseInt(charValue+"");  //make it become integer
           number = number * 2;
           String strNumber = number + "" ;   //make it become string
           
           for(int j=0 ; j<strNumber.length() ; j++){
                char charNumber = strNumber.charAt(j);
                int Intnumber = Integer.parseInt(charNumber + "");
                total2 += Intnumber ;
          }
       }
       
       
       int sum = 0 ;
       
       sum = total + total2;
       if(sum%10==0)
       {
           String tac;
           int error = 0;
           System.out.println("Card number VALIDATED." );
           answer = "true";
           // After validation of card done, we check again for Transaction Authorisation Code 
           do {
               
               System.out.print("Enter your received TAC Number  : " );
               
               int tacNumber;
               tacNumber = scn.nextInt();
               if(tacNumber == 1010)
               {
                   System.out.println("Deposit Successful");
                   tac = "true";
               }
               else 
               {
                   System.out.println("ERROR:\nInvalid credit card number." );
                   tac ="false";
                   error++;
               }
                   
           }
           while(!tac.equals("true") && error < 3);
           if (error == 3)
           {
           System.out.println("Please call your bank for furthur assistant." );
           return false;
           }
           
       }
       else{
           System.out.println("ERROR:\nInvalid TAC number!!!" );
           System.out.println("Please check your card number." );
           answer ="false";
       }
       
    } while (!answer.equals("true" ));
    
       return true;
    }
    

    /***
     * Method to sell cryptocurrency 
     */
    public static void toSell() {
        scanner = new Scanner(System.in);
        boolean sellStatus = true; //sell approval
        printSellMarket();
        
        System.out.println("\nWALLET\n===========");
        System.out.println(wallet[userNumber].toString());
        
        System.out.println("\nSelect cryptocurrency to sell\n----------------------------");
        for(int i = 0; i < cryptocurrency.length; i++) {
            System.out.println((i+1) + ". " + cryptocurrency[i].getCryptoName());
        }
        System.out.print("Enter choice: ");
        int cryptoChoice = scanner.nextInt();
        System.out.print("Enter amount to sell: ");
        double quantity = scanner.nextDouble();
        
        switch(cryptoChoice)
        {
            //ensure the coin count is more than the number of coin the user wishes to sell before proceed to receive payment
            case 1:
                if(quantity>wallet[userNumber].getBitcoinCount())
                {
                    sellStatus = false; 
                } 
                break;
            case 2:
                if(quantity>wallet[userNumber].getEthereumCount())
                {
                    sellStatus = false;
                } 
                break;   
            case 3:
                if(quantity>wallet[userNumber].getLitecoinCount())
                {
                    sellStatus = false;
                } 
                break;
            case 4:
                if(quantity>wallet[userNumber].getRippleCount())
                {
                    sellStatus = false;
                } 
                break;   
            case 5:
                if(quantity>wallet[userNumber].getDashCount())
                {
                    sellStatus = false;
                } 
                break;
            case 6:
                if(quantity>wallet[userNumber].getBitcoinCashCount())
                {
                    sellStatus = false;
                } 
                break;   
            default:
                if(quantity>wallet[userNumber].getBitcoinGoldCount())
                {
                    sellStatus = false;
                } 
                break;   
        } 
        
        //ocnce approved, proceed to calculating potential earn. And prompt for confirmation
        if (sellStatus) {
        System.out.println("\nSelling " + String.format("%.6f",quantity) + " unit(s) of " + cryptocurrency[cryptoChoice - 1].getCryptoName() + " pays you RM" + String.format("%.2f",(cryptocurrency[cryptoChoice - 1].getSellPrice() * quantity)) + " with the current market price");
        System.out.print("\nProceed selling? (Y/N)" + "\nEnter Your Choice : ");
        scanner = new Scanner(System.in);
        String sellChoice = scanner.nextLine();
        sellChoice = sellChoice.toUpperCase();
        
        switch (sellChoice) {
            case "Y" :
            SellCrypto sellCrypto = new SellCrypto(user[userNumber].getAccountBalance(), quantity, cryptocurrency[cryptoChoice - 1].getSellPrice());
            //update account balance
            user[userNumber].setAccountBalance(sellCrypto.calculateBalance() - sellCrypto.chargeTax());
            //update wallet coin count
            switch(cryptoChoice) {
                case 1:
                    wallet[userNumber].setBitcoinCount(wallet[userNumber].getBitcoinCount() - quantity);
                    break;
                case 2:
                    wallet[userNumber].setEthereumCount(wallet[userNumber].getEthereumCount() - quantity);
                    break;
                case 3:
                    wallet[userNumber].setLitecoinCount(wallet[userNumber].getLitecoinCount() - quantity);
                    break;
                case 4:
                    wallet[userNumber].setRippleCount(wallet[userNumber].getRippleCount() - quantity);
                    break;
                case 5:
                    wallet[userNumber].setDashCount(wallet[userNumber].getDashCount() - quantity);
                    break;
                case 6:
                    wallet[userNumber].setBitcoinCashCount(wallet[userNumber].getBitcoinCashCount() - quantity);
                    break;
                default:
                    wallet[userNumber].setBitcoinGoldCount(wallet[userNumber].getBitcoinGoldCount() - quantity);
                    
            }   
                    
            System.out.println("\n.\n.\n.\nTransaction Successful.");
                
            case "N" :
                break;
        }
        
        } else {
            System.out.println("ERROR:\nInsufficient Coin.");
        }
    }
    
    /***
     * Method to deposit extra funds into user account to purchase coins in future
     */
    public static void toDeposit() {
        scanner = new Scanner(System.in);
        boolean depositStatus = false; //deposit approval
        
        System.out.println("\nDEPOSIT FUND\n================\nCurrent account information: \n");
        System.out.println("Name: " + user[userNumber].getName() + "\n" + "Current Account Balance: " + String.format("%.2f", user[userNumber].getAccountBalance()));
        System.out.print("\nEnter amount to deposit into your current account balance: ");
        double depositAmount = scanner.nextDouble();
        
        do {
            depositStatus = cardPaymentMethod();
        } while(depositStatus == false); //loop if deposit declined
        
        Deposit deposit = new Deposit(user[userNumber].getAccountBalance(), depositAmount);
        //once approved, account balance updated
        user[userNumber].setAccountBalance(deposit.getBalance());
        
        System.out.println("\n.\n.\n.\nTransaction Successfull.");
    }
    
    /***
     * Method to withdraw fund from user account balance
     */
    public static void toWithdraw() {
        scanner = new Scanner(System.in);
        boolean withdrawStatus = false; //withdraw approval
        
        System.out.println("\nWITHDRAW FUND\n================\n***4% WITHDRAWAL TRANSACTION TAX RATE***\nCurrent account information: \n");
        System.out.println("Name: " + user[userNumber].getName() + "\n" + "Current Account Balance: " + String.format("%.2f", user[userNumber].getAccountBalance()));
        
        do{
        System.out.print("\nEnter amount to withdraw from your current account balance: ");
        double withdrawAmount = scanner.nextDouble();
        Withdrawal withdrawal = new Withdrawal(user[userNumber].getAccountBalance(), withdrawAmount);
        
        //Using interface Comparable to compare the withdraw amount with accoubt balance. making sure its suficient ot be withdrew
        if(withdrawal.compareTo(withdrawAmount) == 1) {
        
        user[userNumber].setAccountBalance(withdrawal.getBalance());
        
        System.out.println("\n.\n.\n.\nTransaction Successfull.");
        withdrawStatus = true;
        } else {
            System.out.println("ERROR:\nInsufficient fund to withdraw.");
        }
        } while (withdrawStatus == false); //loop if withdrawal declined
    }
    
    /***
     * login form
     */
    public static void login() {
        Scanner input = new Scanner (System.in);
       String userID;
       int option, password;
       
       System.out.println("Welcome to CryptoMalaysia");
       System.out.println("*************************");
       System.out.println("1.Login as Current User");
       System.out.println("2.Create new Account");
       System.out.print("Choose 1 or 2 : ");
       option = input.nextInt();
       input.nextLine();
       
       
       switch(option)
       {
           case 1:
               String answer ;
               int change = 0;
               System.out.println("");
               
               do{
               input = new Scanner (System.in);
               System.out.print("Enter User ID :");
               userID = input.nextLine();
               System.out.print("Enter password :");
               password = input.nextInt();
               
               if(userID.equals("HENGHENG") && password == 888888)
               {
                   System.out.println("Welcome HengHeng !!!");
                   answer = "True";
                   userNumber = 0;
                   
               }
               else
               {
                   System.out.println("Invalid UserID or Password!!!");
                   System.out.println("Please enter a valid UserID or Password.\n");
                   answer = "False";
                   change++;
              
               }
               
               }while(!answer.equals("True") && change < 3);
               
               if(change == 3)
               {
               System.out.println("Your login was suspended!!!");
               System.out.println("Please contact admin!!!");
               System.out.println("ambrose@cryptoMY.com!!!");
               System.exit(0);
               }
               break;
               
           case 2:
               System.out.print("\nEnter New UserID : ");
               userID = input.nextLine();
               System.out.print("Enter New Password : ");
               password = input.nextInt();
               
               if(userID.equals("HENGHENG"))
               {
                   System.out.println("UserID already exists\n");
                   login();
               }
               else
               {
                   System.out.println("Welcome" + userID);
                   userNumber = 1;
                   wallet[userNumber] = new Wallet();
                   user[userNumber] = new User(userID , "13NdHD7e6yWJBWciZrhuqvSHMZpX2HQhnA", "L4V5UnLWNj8z6yuncmAkYqXNd8PFgyJZnoPhefHcEds4LVk4U3V7", wallet[userNumber], 0);
               }
               break;
       }
    }
    /***
     * prompt user if they want to back to main menu or end program
     * @return 
     */
    public static boolean backMainMenuPrompt() {
        scanner = new Scanner(System.in);
        System.out.print("\nBack to main menu? (Y/N)" + "\nEnter Your Choice : ");
        String choice = scanner.nextLine();
        choice = choice.toUpperCase();
        return !choice.equals("Y");
    }
    
     
}


