package code_package;
import java.util.*;
public class Functions
{
    Customer custs [] = new Customer[10];
    Scanner scan = new Scanner(System.in);
    int count;
    public Functions()
    {
        for(int i =0; i < custs.length;i++)
        {
            custs[i] = new Customer();
            count =0;
        }
    }
    public void add_customer()
    {
        System.out.println("Enter Customer ID  ");
        custs[count].customerID = scan.nextInt();
        System.out.println(" Enter Customer Name");
        custs[count].name = scan.next();
        System.out.println(" Enter Customer Age ");
        custs[count].age = scan.nextInt();
        System.out.println(" Enter Amount");
        custs[count].p_amount = scan.nextDouble();
        count++;
    }
    public void display()
    {
        for(int i=0; i < count ; i++)
        {
            System.out.println(" Customer ID " + custs[i].customerID);
            System.out.println(" Customer Name " + custs[i].name);
            System.out.println(" Customer Age " + custs[i].age);
            System.out.println(" Customer's Purchase Amount " + custs[i].p_amount);
        }
    }
    public void customersX()
    {
        System.out.println(" Enter the Amount to Check ");
        int x = scan.nextInt();
        boolean check = false;
        for(int i =0;i < custs.length;i++)
        {
            if(custs[i].p_amount > x)
            {

                check =true;
            }

        }
        if(check)
        {
            System.out.println(" Customer ID " + custs[i].customerID);
            System.out.println(" Customer Name " + custs[i].name);
            System.out.println(" Customer Age " + custs[i].age);
            System.out.println(" Customer's Purchase Amount " + custs[i].p_amount);
        }
        else if(!check)
        {
            System.out.println(" ");
        }
    }
    public void cust_age()
    {
        System.out.println(" Enter a Age to Check ");
        int age = scan.nextInt();
        for(int i =0; i < custs.length;i++)
        {
            if(custs[i].age == age)
            {
                System.out.println(" Customer ID " + custs[i].customerID);
                System.out.println(" Customer Name " + custs[i].name);
                System.out.println(" Customer Age " + custs[i].age);
                System.out.println(" Customer's Purchase Amount " + custs[i].p_amount);
            }
            else
            {
                System.out.println(" Their is No Body of Age Entered By You  ");

            }
        }
    }
    public void young_cust()
    {
        Customer young = custs[0];
        for(int i =0; i < custs.length ; i++)
        {
            if(custs[i].age < young.age)
            {
                young = custs[i];
            }
        }
        System.out.println(" Youngest Customer is " + young.name);
    }
    public static int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Press 1 to add Customer");
        System.out.println(" Press 2 to Display All Customers ");
        System.out.println(" Press 3 to Display Customers With Purchase Amount Greater Than X");
        System.out.println(" Press 4 to Search Customer By Age ");
        System.out.println(" Press 5 to Display Youngest Customer ");
        System.out.println(" Press 6 to Exit");
        int choice = scan.nextInt();
        return choice;
    }

}
