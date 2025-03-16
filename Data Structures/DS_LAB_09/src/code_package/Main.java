package code_package;

public class Main
{
    public static void main(String [] args)
    {
        Emergency op = new Emergency();
        int choice ;
        do
        {
            choice = op.menu();
            switch(choice)
            {
                case 1 :
                {
                    op.Enqueue();
                    break;
                }
                case 2:
                {
                    op.Dequeue();
                    break;
                }
                case 3:
                {
                    op.display();
                    break;
                }
                case 4:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Operator ");
                }
            }

        }while(choice!=4);
    }
}
