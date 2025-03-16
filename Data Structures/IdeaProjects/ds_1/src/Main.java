import java.util.*;
public class Main
{
    private static  Book[]   books = new Book[5];
    public static void main(String[] args)
    {
        books[0] = new Book(001 , " Sociology");
        books[1] = new Book(002 , " Biology");
        books[2] = new Book(003 , " Physics");
        books[3] = new Book(004 , " Mathematics");
        books[4] = new Book(005 , " Chemistry");
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int choice = menu();
            if(choice == 1 )
            {
                for(Book book : books)
                {
                    book.Display_books();
                }
            }
            else if(choice == 2)
            {
                System.out.println(" Enter Book's ID You want to Borrow ");
                int id = scan.nextInt();
                Book b1 = search_book(id);
                if(b1 != null)
                {
                    b1.Borrow_Book();
                }
                else {
                    System.out.println(" Invalid Book ID ");
                }
            }
            else if(choice == 3)
            {
                System.out.println(" Enter Book's ID You want to Return ");
                int id = scan.nextInt();
                Book b1 = search_book(id);
                if(b1 != null)
                {
                    b1.Return_Book();
                }
                else {
                    System.out.println(" Book Not Borrowed ");
                }
            }
            else if(choice == 4)
            {
                System.out.println(" Exiting ");
                break;
            }
        }

    }


    public static int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Press 1 for Displaying Book's Information ");
        System.out.println(" Press 2 for Borrowing a Book ");
        System.out.println(" Press 3 for Returning a Book ");
        System.out.println(" Press 4 to Exit ");
        int choice = scan.nextInt();
        return choice;
    }
    public static Book search_book(int id)
    {
        for(Book book : books)
        {
            if(book.getBookID() == id)
            {
                return book;
            }
            else {
                System.out.println(" Invalid ID");
            }
        }
        return null;
    }
}