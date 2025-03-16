import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {


        Scanner scan = new Scanner(System.in);
        BST tree = new BST();
        int choice;
        while (true)
        {
            choice = tree.menu();
            switch(choice)
            {
                case 1:
                {
                    tree.insertValue();
                    break;
                }
                case 2:
                {
                    tree.displayTree();
                    break;
                }
                case 3:
                {
                    break;
                }
            }

        }
    }
}
