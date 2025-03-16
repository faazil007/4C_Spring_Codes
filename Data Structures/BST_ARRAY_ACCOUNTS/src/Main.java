import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {


        Scanner scan = new Scanner(System.in);
        BST2 tree = new BST2();
        Account acc = new Account();
        int choice;
        while (true)
        {
            choice = tree.menu();
            switch(choice)
            {
                case 1:
                {
                    tree.AddAccount();
                    break;
                }
                case 2:
                {
                    tree.DisplayAccounts();
                    break;
                }
                case 3:
                {
                    break;
                }
            }

        }
    }
}
