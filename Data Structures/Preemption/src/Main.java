public class Main
{
    public static void main(String [] args)
    {
        Non_Preemptive_Technique_Array technique = new Non_Preemptive_Technique_Array();
        int choice ;
        do {
            choice = technique.menu();
            switch(choice)
            {
                case 1:
                {
                    technique.enqueue();
                    break;
                }
                case 2:
                {
                    technique.dequeue();
                    break;
                }
                case 3:
                {
                    technique.Display();
                    break;
                }
                case 4:
                {
                    System.out.println(" Exiting ");
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Choice ");
                }
            }

        }while(choice != 4);
    }
}
