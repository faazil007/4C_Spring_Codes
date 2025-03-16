import java.util.Scanner;

public class BST {
    int[] data;
    int size;
    int count;

    public BST()
    {
        this.size = 20;
        data = new int[size];
        for (int i = 0; i < size; i++)
        {
            data[i] = 0;
        }
        count = 0;
    }
    public void insertValue()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Value:");
        int value = scan.nextInt();

        if (count == 0)
        {
            data[0] = value;
            count++;
            return;
        }

        int index = 0;
        while (true)
        {
            if (value > data[index])
            {
                int rightIndex = 2 * index + 2;
                ensureCapacity(rightIndex);
                if (data[rightIndex] == 0)
                {
                    data[rightIndex] = value;
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
                if (data[leftIndex] == 0)
                {
                    data[leftIndex] = value;
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
    public void displayTree()
    {
        if (count == 0)
        {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("BST elements:");
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != 0)
            {
                System.out.print(data[i] + " ");
            }
            else
            {
                System.out.print("null ");
            }
        }
        System.out.println();
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
        int[] newData = new int[newSize];
        for (int i = 0; i < newSize; i++)
        {
            newData[i] = 0;
        }
        for (int i = 0; i < data.length; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
        size = newSize;
    }
    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 :: Insertion");
        System.out.println("2 :: Display Tree");
        System.out.println("3 :: Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }


}
