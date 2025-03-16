import java.util.*;
public class BST
{
    Account[] accs;
    int size;
    int count;
    public BST()
    {
        this.size = 50;
        accs= new Account[size];
        for(int i =0 ; i < size ; i++)
        {
            accs[i] = null;
        }
        count =0;
    }
    public void insertData(Account acc)
    {
        Scanner scan = new Scanner(System.in);
        if(count == 0)
        {
            accs[0] = acc;
            count++;
            return;
        }
        int index =0;
        while(true)
        {
            if(acc.balance > accs[index].balance)
            {
                int rightIndex = 2 * index +2;
                ensureCapacity(rightIndex);
                if(accs[rightIndex] == null)
                {
                    accs[rightIndex] = acc;
                    count++;
                    break;
                }
                else
                {
                    index = rightIndex;
                }
            }
            else
            {
                int leftIndex = 2 * index + 1;
                ensureCapacity(leftIndex);
                if(accs[leftIndex] == null)
                {
                    accs[leftIndex] = acc;
                    count++;
                    break;
                }
                else
                {
                    index = leftIndex;
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
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" 1 :: Add Data ");
        System.out.println(" 2 :: Display Tree ");
        System.out.println(" 3 :: Exit         ");
        int choice = scan.nextInt();
        return choice;
    }
    private void ensureCapacity(int index)
    {
        if (index >= size)
        {
            resizeArray(index + 1);
        }
    }
    private void resizeArray(int newSize)
    {
        Account[] newData = new Account[newSize];
        for (int i = 0; i < newSize; i++)
        {
            newData[i] = null;
        }
        for (int i = 0; i < accs.length; i++)
        {
            newData[i] = accs[i];
        }
        accs = newData;
        size = newSize;
    }


}
