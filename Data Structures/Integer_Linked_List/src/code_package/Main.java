package code_package;

public class Main
{
    public static void main(String [] args)
    {
        Function f = new Function();
        int choice;
        do {
            choice = f.menu();
            switch(choice)
            {
                case 1 :
                {
                    f.insertAtEnd();
                    break;
                }
                case 2:
                {
                    f.insertAtFront();
                    break;
                }
                case 3:
                {
                    f.searchIndex();
                    break;
                }
                case 4:
                {
                    f.deleteSpecificNode();
                    break;
                }
                case 5:
                {
                    f.display();
                    break;
                }
                case 6:
                {
                    break;

                }
                default:
                {
                    System.out.println(" Invalid Choice ");
                }
            }

        }while(choice !=6);
    }
}
