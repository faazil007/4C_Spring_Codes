public class Main
{
    public static void main(String [] args)
    {
        Operations op = new Operations();
        int choice;
        do {
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
                    op.Display();
                    break;
                }

            }

        }while(choice!=4);
    }
}
