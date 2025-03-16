import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(20 );
        int choice;

        while (true)
        {
            choice = bank.menu();
            switch (choice)
            {
                case 1:
                {
                    System.out.print("Enter account holder's name:: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter initial balance for new account:: ");
                    double initialBalance = scanner.nextDouble();
                    System.out.println(" Enter Account Number :: ");
                    String accountNumber = scanner.next();
                    bank.addAccount(accountHolder, initialBalance, accountNumber);
                    break;
                }
                case 2:
                {
                    bank.displayAccounts();
                    break;
                }

                case 3:
                {
                    System.out.print("Enter account number (1 to " + bank.accountCount + "): ");
                    String accountNumberForDeposit = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter deposit date (e.g., YYYY-MM-DD): ");
                    String depositDate = scanner.nextLine();
                    bank.deposit(accountNumberForDeposit, depositAmount, depositDate);
                    break;
                }

                case 4:
                {
                    System.out.print("Enter account number (1 to " + bank.accountCount + "): ");
                    String accountNumberForWithdraw = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter withdrawal date (e.g., YYYY-MM-DD): ");
                    String withdrawDate = scanner.nextLine();
                    bank.withdraw(accountNumberForWithdraw, withdrawAmount, withdrawDate);
                    break;
                }

                case 5:
                {
                    System.out.print("Enter account number (1 to " + bank.accountCount + "): ");
                    String accountNumberForBalance = scanner.next();
                    bank.displayBalance(accountNumberForBalance);
                    break;
                }

                case 6:
                {

                    System.out.print("Enter account number (1 to " + bank.accountCount + "): ");
                    String accountNumberForHistory = scanner.next();
                    bank.displayTransactionHistory(accountNumberForHistory);
                    break;
                }

                case 7:
                {
                    System.out.println("Exiting the bank system.");
                    break;
                }

                default:
                {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}