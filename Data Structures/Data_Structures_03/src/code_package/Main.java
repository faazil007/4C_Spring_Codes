package code_package;

public class Main {
    public static void main(String[] args)
    {
        Functions f = new Functions();
        int choice;
        do
        {
            choice = f.menu();
            switch(choice)
            {
                case 1:
                {
                    f.add_customer();
                    break;
                }
                case 2:
                {
                    if(f.count ==0)
                    {
                        System.out.println(" Their Is No Customer , First Add Customers");
                    }
                    else {
                        f.display();
                        break;
                    }
                }
                case 3:
                {
                    f.customersX();
                    break;
                }
                case 4:
                {
                    f.cust_age();
                }
                case 5:
                {
                    f.young_cust();
                }
                case 6:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Input");
                    break;
                }
            }
        }while(choice != 6);
    }
}
