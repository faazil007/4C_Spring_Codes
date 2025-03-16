import java.util.*;
public class BrowserHistorySimulation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        WebBrowserHistory history = new WebBrowserHistory();
        int choice;

        do {
            choice = history.menu();
            switch (choice) {
                case 1:
                    System.out.print("Enter the URL or title of the page to visit: ");
                    String page = scanner.nextLine();
                    history.visitPage(page);
                    break;

                case 2:
                    history.goBack();
                    break;

                case 3:
                    history.viewCurrentPage();
                    break;

                case 4:
                    history.displayHistory();
                    break;

                case 5:
                    System.out.println("Exiting browser history simulation.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
