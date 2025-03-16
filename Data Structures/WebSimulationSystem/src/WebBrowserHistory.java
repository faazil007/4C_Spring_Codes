import java.util.*;
public class WebBrowserHistory
{
    private String[] stack;
    private int top;
    private int capacity;
    Scanner scan = new Scanner(System.in);


    // Constructor
    public WebBrowserHistory()
    {
        capacity = 50;
        stack = new String[capacity];
        top = -1;
    }

    // Push a new page onto the stack
    public void visitPage(String page)
    {
        if (top == capacity - 1)
        {
            System.out.println("History is full. Can't visit more pages.");
        }
        else
        {
            stack[++top] = page;
            System.out.println("Visited: " + page);
        }
    }

    // Pop the top page to go back
    public void goBack()
    {
        if (top == -1)
        {
            System.out.println("No pages in history to go back to.");
        }
        else
        {
            System.out.println("Going back from: " + stack[top]);
            top--;
        }
    }

    // View the current page without removing it
    public void viewCurrentPage()
    {
        if (top == -1)
        {
            System.out.println("No pages in history to view.");
        }
        else
        {
            System.out.println("Current page: " + stack[top]);
        }
    }

    // Display all visited pages
    public void displayHistory()
    {
        if (top == -1)
        {
            System.out.println("No browsing history available.");
        }
        else
        {
            System.out.println("Browsing History:");
            for (int i = top; i >= 0; i--)
            {
                System.out.println(stack[i]);
            }
        }
    }
    public int menu()
    {
        System.out.println("\n--- Web Browser History Menu ---");
        System.out.println("1. Visit a Web Page");
        System.out.println("2. Go Back");
        System.out.println("3. View Current Page");
        System.out.println("4. Display Browsing History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        return choice;
    }
}
