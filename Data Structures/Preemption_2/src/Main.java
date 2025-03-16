public class Main
{
    public static void main(String[] args)
    {
    Preemptive_Technique_Array scheduler = new Preemptive_Technique_Array();
    int choice;

    do {
        choice = scheduler.menu();

        switch (choice)
        {
            case 1:
            {
                scheduler.enqueue();
                break;
            }
            case 2:
            {
                scheduler.dequeue();
                break;
            }
            case 3:
            {
                scheduler.display();
                break;
            }
            case 4:
            {
                System.out.println("Exiting...");
                break;
            }
            default:
            {
                System.out.println("Invalid choice. Please try again.");
            }

        }

    } while (choice != 4);
}
}
