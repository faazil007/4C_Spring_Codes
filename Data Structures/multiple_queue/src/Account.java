public class Account
{
    private String accountHolder;
    private double balance;
    private Queue_Holder transactionQueue;
    private String accountNumber;
    private int queueCapacity = 500;

    public Account(String accountHolder, double initialBalance,  String accountNumber)
    {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionQueue = new Queue_Holder(queueCapacity);
        this.accountNumber = accountNumber;
    }
    public String toString()
    {
        String str = " Account Title :: " + accountHolder + "\n" + " Account Number :: " + accountNumber + "\n" + " Account Balance :: " + balance + "\n";
        return str;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void deposit(double amount, String date) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionQueue.enqueue_Transactions(new Transaction("Deposit", amount, date));
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount, String date) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            transactionQueue.enqueue_Transactions(new Transaction("Withdraw", amount, date));
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public void displayTransactionHistory() {
        transactionQueue.displayTransactions();
    }
}