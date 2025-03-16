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
                    tree.addPatients();
                    break;
                }
                case 2:
                {
                    tree.searchByID();
                    break;
                }
                case 3:
                {
                    tree.ListPatient();
                    break;
                }
            }

        }
    }
}
