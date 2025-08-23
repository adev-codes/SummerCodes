public class BankAccount{
    private int accountNumber;
    private float balance;

    public BankAccount(int n,float b){
        this.accountNumber = n;
        this.balance = b;

    }
    public int getAccountNumber(){
         return accountNumber;
    }
    public float getBalance(){
        return balance;
    }

    public void setAccountNumber(int n){
        this.accountNumber = n;
    }
    public void setBalance(float b){
        this.balance = b;
    }
    public void deposit(double amount){
        
        System.out.println("\n========Processing Transaction========");
        if(amount >= 1){
        this.balance += amount;
        System.out.println("Rs."+amount+" deposited successfully to account number: "+accountNumber);
        System.out.println("The current balance is: "+balance);
        System.out.println("------------------------------");
    }
    else{
        System.out.println("Invalid Deposit Amount entered");
        System.out.println("------------------------------\n");
    }
}

    public void withdraw(double amount){
         System.out.println("\n========Processing Transaction========");
        if(amount <= balance){
        this.balance -= amount;
        System.out.println("Rs."+amount+" has been withdrawn successfully from account number: "+accountNumber);
        System.out.println("The current balance is: "+balance);
        System.out.println("------------------------------\n");
    }
        else{
            System.out.println("Insufficient Funds.");
            System.out.println("------------------------------\n");
        }
    }

    public void displayBalance(){
        System.out.println("=========Bank Details=========");
        System.out.println("The current balance is: "+balance);
        System.out.println("------------------------------");
    }
    public static void main(String[] args) {
     BankAccount b1 = new BankAccount(1001, 50000);
     BankAccount b2 = new BankAccount(1002, 10000);
     b1.deposit(5000);
     b2.deposit(10000);
     b1.withdraw(20000);
     b2.withdraw(3200);
     b1.displayBalance();
     b2.displayBalance();

}
 }
