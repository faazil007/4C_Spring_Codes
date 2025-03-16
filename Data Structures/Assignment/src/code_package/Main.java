package code_package;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        int choice;

        do {
            choice = library.menu();
            switch (choice) {
                case 1:
                    library.addBookAtEnd();
                    break;
                case 2:
                    library.addBookAtFront();
                    break;
                case 3:
                    library.deleteBookFromEnd();
                    break;
                case 4:
                    library.deleteBookFromFront();
                    break;
                case 5:
                    library.undo();
                    break;
                case 6:
                    library.redo();
                    break;
                case 7:
                    library.displayBooks();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }
}
