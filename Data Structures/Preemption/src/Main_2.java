public class Main_2
{
        public static void main(String [] args)
        {
            Non_Preemptive_Technique_LinkedList technique = new Non_Preemptive_Technique_LinkedList();
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


