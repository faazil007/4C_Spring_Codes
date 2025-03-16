import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Employee_Functions f = new Employee_Functions();
        int choice;
        do
        {
            f.menu();
            choice = scan.nextInt();
            switch(choice)
            {
                case 1 :
                {
                    f.input();
                    break;
                }
                case 2:
                {
                    f.Display_Employee();
                    break;
                }
                case 3:
                {
                    f.id_Employee();
                    break;
                }
                case 4:
                {
                    f.Younger_Employee();
                    break;
                }
                case 5:
                {
                    f.age_Employee();
                    break;
                }
                case 6:
                {
                    f.great_Salary();
                    break;
                }
                case 7:
                {
                    f.remove_employee();
                    break;
                }
                case 8:
                {
                    f.update_employee();
                    break;
                }
                case 9:
                {
                    f.calculate_avg_salary();
                    break;
                }
                case 10:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Input ");
                    break;
                }
            }

        }while(choice != 10);
    }
}