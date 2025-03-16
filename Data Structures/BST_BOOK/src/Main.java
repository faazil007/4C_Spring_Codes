import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        BST bst = new BST();
        int choice;
        while(true)
        {
            choice = bst.menu();
            switch(choice)
            {
                case 1:
                {
                    Scanner scan = new Scanner(System.in);
                    Book book = new Book();
                    System.out.println(" Book ID     :: ");
                    book.id = scan.nextInt();
                    System.out.println(" Book Title  :: ");
                    book.title = scan.next();
                    System.out.println(" Book Author :: ");
                    book.author = scan.next();
                    System.out.println(" Book Price  :: ");
                    book.price = scan.nextDouble();
                    bst.addBook(book);
                    break;
                }
                case 2:
                {
                    bst.sort();
                    break;
                }
                case 3:
                {
                    bst.

                }
            }
        }
    }

}
