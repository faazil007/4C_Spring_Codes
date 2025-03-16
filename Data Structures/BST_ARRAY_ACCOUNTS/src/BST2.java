import java.util.*;
public class BST2 {
    Scanner scan = new Scanner(System.in);
    int count;
    Account[] accs = new Account[500];

    public BST2()
    {
        for (int i = 0; i < 500; i++) {
            accs[i] = new Account();
            accs[i].l = -1;
            accs[i].r = -1;
        }
    }
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" 1 :: Add Data ");
        System.out.println(" 2 :: Display Tree ");
        System.out.println(" 3 :: Exit         ");
        int choice = scan.nextInt();
        return choice;
    }

    public void AddAccount()
    {
        if (count == accs.length)
        {
            System.out.println(" tree is Full ");
        }
        else
        {
            System.out.println(" Account ID      :: ");
            accs[count].id = scan.nextInt();
            System.out.println(" Account Balance :: ");
            accs[count].balance = scan.nextDouble();
            int index = 0;
            if (count > 0) {

                while (true)
                {
                    if (accs[index].balance < accs[count].balance)
                    {
                        if (accs[index].r == -1)
                        {
                            accs[index].r = count;
                            break;
                        }
                        else
                        {
                            index = accs[index].r;
                        }
                    }
                    else
                    {
                        if (accs[index].balance > accs[count].balance)
                        {
                            if (accs[index].l == -1)
                            {
                                accs[index].l = count;
                                break;
                            }
                            else
                            {
                                index = accs[index].l;
                            }

                        }

                    }
                    count++;
                }
            }
        }

    }
    public void DisplayAccounts()
    {
        if(count == 0)
        {
            System.out.println(" Tree is Empty !!");
            return;
        }
        System.out.println(" Data of BST :: ");
        for(int i =0; i < accs.length;i++)
        {
            if(accs[i] != null)
            {
                System.out.println(accs[i] + " ");
            }
            else
            {
                System.out.println(" Null ");
            }
        }
        System.out.println();
    }
}
