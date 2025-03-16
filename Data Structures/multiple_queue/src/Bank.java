import java.util.*;
public class Bank
{
    private Account[] accounts;
    public int accountCount;
    private int maxAccounts;

    public Bank(int maxAccounts )
    {
        this.maxAccounts = maxAccounts;
        accounts = new Account[maxAccounts];
        accountCount = 0;
    }

    public void addAccount(String accountHolder, double initialBalance, String accountNumber)
    {
        if (accountCount < maxAccounts)
        {

            accounts[accountCount] = new Account(accountHolder, initialBalance,  accountNumber);
            accountCount++;
            System.out.println("Account created with account number: " + accountNumber + " for " + accountHolder);
        }
        else
        {
            System.out.println("Bank has reached maximum account limit.");
            resizeAccountsArray();
            accounts[accountCount] = new Account(accountHolder, initialBalance, accountNumber);
            accountCount++;
            System.out.println("Account created with account number after resizing: " + accountNumber + " for " + accountHolder);
        }
    }
    public void displayAccounts()
    {
        if(accountCount ==0)
        {
            System.out.println(" No Accounts Found !");
        }
        else
        {
            for(int i =0 ; i < accountCount ; i++)
            {
                System.out.println(accounts[i]);
            }
        }
    }

    private void resizeAccountsArray() {
        int newSize = maxAccounts * 2;
        Account[] newAccounts = new Account[newSize];
        System.arraycopy(accounts, 0, newAccounts, 0, accounts.length);
        accounts = newAccounts;
        maxAccounts = newSize;
    }

    public Account getAccountByNumber(String accountNumber)
    {
        for (int i = 0; i < accountCount; i++)
        {
            if (accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber))
            {
                return accounts[i];
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount, String date)
    {
        Account account = getAccountByNumber(accountNumber);
        if (account != null)
        {
            account.deposit(amount, date);
        }
        else
        {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount, String date)
    {
        Account account = getAccountByNumber(accountNumber);
        if (account != null)
        {
            account.withdraw(amount, date);
        }
        else
        {
            System.out.println("Account not found!");
        }
    }

    public void displayBalance(String accountNumber)
    {
        Account account = getAccountByNumber(accountNumber);
        if (account != null)
        {
            account.displayAccountInfo();
        }
        else
        {
            System.out.println("Account not found!");
        }
    }

    public void displayTransactionHistory(String accountNumber)
    {
        Account account = getAccountByNumber(accountNumber);
        if (account != null)
        {
            account.displayTransactionHistory();
        }
        else
        {
            System.out.println("Account not found!");
        }
    }
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n----- Bank System -----");
        System.out.println("1. Create Account");
        System.out.println("2. Display Accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. View Transaction History");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        return choice;
    }
}