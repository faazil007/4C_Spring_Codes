package code_package;

import java.util.Scanner;

public class Library
{
    private LinkedList books;
    private LinkedList redoStack;
    private Scanner scan;

    public Library()
    {
        this.books = new LinkedList();
        this.redoStack = new LinkedList();
        this.scan = new Scanner(System.in);
    }

    private Book getBookDetails()
    {
        Book book = new Book();
        System.out.print("Enter Book ID: ");
        book.bookID = scan.nextInt();
        System.out.print("Enter Book Price: ");
        book.bookPrice = scan.nextDouble();
        System.out.print("Enter Book Title: ");
        scan.nextLine(); // Consume the newline character
        book.bookTitle = scan.nextLine();
        System.out.print("Enter Book Edition: ");
        book.bookEdition = scan.nextInt();
        System.out.print("Enter Book Subject: ");
        scan.nextLine(); // Consume the newline character
        book.subject = scan.nextLine();
        System.out.print("Enter Number of Copies: ");
        book.noOfCopies = scan.nextInt();
        return book;
    }

    public void addBookAtEnd()
    {
        Book book = getBookDetails();
        books.append(book);
        redoStack = new LinkedList(); // Clear redo stack
    }

    public void addBookAtFront()
    {
        Book book = getBookDetails();
        books.push(book);
        redoStack = new LinkedList(); // Clear redo stack
    }

    public void deleteBookFromEnd()
    {
        if (!books.isEmpty())
        {
            Book book = books.removeLast();
            redoStack.push(book);
            System.out.println("Deleted: " + book);
        }
        else
        {
            System.out.println("No books to delete.");
        }
    }

    public void deleteBookFromFront()
    {
        if (!books.isEmpty())
        {
            Book book = books.pop();
            redoStack.push(book);
            System.out.println("Deleted: " + book);
        }
        else
        {
            System.out.println("No books to delete.");
        }
    }

    public void undo()
    {
        if (!books.isEmpty())
        {
            Book book = books.pop();
            redoStack.push(book);
            System.out.println("Undo: Removed " + book);
        }
        else
        {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo()
    {
        if (!redoStack.isEmpty())
        {
            Book book = redoStack.pop();
            books.push(book);
            System.out.println("Redo: Re-added " + book);
        }
        else
        {
            System.out.println("Nothing to redo.");
        }
    }

    public void displayBooks()
    {
        System.out.println("Books in Library: " + books);
    }

    public void displayRedoStack()
    {
        System.out.println("Redo Stack: " + redoStack);
    }

    public int menu()
    {
        System.out.println("\nMenu:");
        System.out.println("1 :: Add Book at End");
        System.out.println("2 :: Add Book at Front");
        System.out.println("3 :: Delete Book from End");
        System.out.println("4 :: Delete Book from Front");
        System.out.println("5 :: Undo");
        System.out.println("6 :: Redo");
        System.out.println("7 :: Display All Books");
        System.out.println("8 :: Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }
}
