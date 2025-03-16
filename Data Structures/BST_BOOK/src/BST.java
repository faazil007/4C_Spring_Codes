import java.util.Scanner;

public class BST {
    int count;
    Scanner scan = new Scanner(System.in);
    Book books[];
    int size = 100;

    public BST()
    {
        count = 0;
        books = new Book[size];
        for (int i = 0; i < books.length; i++)
        {
            books[i] = new Book();
            books[i].l = -1;
            books[i].r = -1;
        }
    }
    public void addBook(Book book) {
        if (count == books.length)
        {
            System.out.println(" Tree is Full !");
        }
        else
        {
            if (count == 0)
            {
                books[count] = book;
            }
            else if (count > 0)
            {
                int index = 0;
                while (true)
                {
                    if (books[index].id < books[count].id)
                    {
                        if (books[index].r == -1)
                        {
                            books[index].r = count;
                            break;
                        }
                        else
                        {
                            index = books[index].r;
                        }
                    }
                    else
                    {
                        if (books[index].l == -1)
                        {
                            books[index].l = count;
                            break;
                        }
                        else
                        {
                            index = books[index].l;
                        }
                    }
                }
                count++;

            }
        }

    }
    public void maxify()
    {
        int p = (count / 2) - 1;
        for (int i = p; i >= 0; i--)
        {
            heapify(i);
        }
    }

    private void heapify(int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < count && books[left].id > books[largest].id)
        {
            largest = left;
        }

        if (right < count && books[right].id > books[largest].id)
        {
            largest = right;
        }

        if (largest != i)
        {
            Book temp = books[i];
            books[i] = books[largest];
            books[largest] = temp;
            heapify(largest);
        }
    }
    public void sort()
    {
        for (int i = count - 1; i > 0; i--)
        {
            Book temp = books[0];
            books[0] = books[i];
            books[i] = temp;
            count--;
            maxify();
        }
    }

    public int menu()
    {
        System.out.println(" 1 :: Add Books ");
        System.out.println(" 2 :: Sort Them ");
        System.out.println(" 3 :: Display Using BST ");
        System.out.println(" 4 :: Display Using Heap ");
        int choice = scan.nextInt();
        return choice;
    }
    public void displayInBinaryTreeStyle()
    {
        if (count == 0)
        {
            System.out.println("No Data Available");
        }
        else
        {
            displayTree(0, 0);
        }
    }

    private void displayTree(int index, int level)
    {
        if (index == -1 || index >= count)
        {
            return;
        }
        displayTree(books[index].r, level + 1);
        for (int i = 0; i < level; i++)
        {
            System.out.print("\t");
        }
        System.out.println(books[index].toString());
        displayTree(books[index].l, level + 1);
    }
    private void DisplayInorder(int i)
    {
        if (i == -1)
        {
            return;
        }
        else
        {
            DisplayInorder(books[i].l);
            System.out.println(books[i].toString());
            DisplayInorder(books[i].r);
        }
    }

    public void displayAllBooks()
    {
        if (count == 0)
        {
            System.out.println("No Data Available");
        }
        else
        {
            for(int i =0 ; i < count ; i++)
            {
                System.out.println(books[i]);
            }
        }
    }



}
