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
                    bst.addEmployees();
                    break;
                }
                case 2:
                {
                    bst.sort();
                    break;
                }
                case 3:
                {
                    bst.displayAllBooks();
                    break;
                }
                case 4:
                {
                    break;
                }
            }
        }
    }

}
