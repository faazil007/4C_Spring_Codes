package code_package;
import java.util.*;
public class Operations
{
    Scanner scan = new Scanner(System.in);
    Transport head;
    public void Enqueue()
    {
        Transport tr = new Transport();
        System.out.println(" Enter Passenger Name :: ");
        tr.passenger_name = scan.next();
        System.out.println(" Enter Flight Number  :: ");
        tr.flight_number=scan.nextInt();
        System.out.println(" Enter Departure Time :: ");
        tr.departure_time = scan.nextDouble();
        System.out.println(" Enter No Of Bags With Passenger :: ");
        tr.no_of_bags= scan.nextInt();
        System.out.println(" Enter Luggage Weight of All Bags  :: ");
        tr.luggage_weight= scan.nextDouble();
        if(head == null)
        {
            head = tr;
        }
        else
        {
            if (tr.no_of_bags <= 3 && tr.departure_time == 3.0)
            {
                tr.next = head;
                head = tr;
            }
            else
            {
                System.out.println(" Can't Enqueue ");
            }
        }
    }
    public void Dequeue()
    {
        if(head == null)
        {
            System.out.println(" No Records of Passengers Found !!! ");
        }
        else
        {
            if(head.luggage_weight <= 50.0)
            {
                head = head.next;
            }
            else
            {
                System.out.println(" Can't Dequeue Passenger is Warned to Step Aside !!! ");
            }
        }

    }
    public void display()
    {
        Transport temp = new Transport();
        if(head == null)
        {
            System.out.println(" No Passengers Added ");
        }
        else
        {
            temp = head;
            while (temp != null)
            {
                System.out.println(" Passenger's Name :: " + temp.passenger_name);
                System.out.println(" Passenger's Flight Number :: " + temp.flight_number);
                System.out.println(" Passenger's Departure Hours Remaining :: " + temp.departure_time);
                System.out.println(" Passenger's Number of Bags :: " + temp.no_of_bags);
                System.out.println(" Passenger's Luggage's Weight :: " + temp.luggage_weight);
                temp = temp.next;
            }
        }
    }
    public void peek()
    {


    }

    public int menu()
    {
        System.out.println(" 1 :: To Enqueue ");
        System.out.println(" 2 :: To Dequeue ");
        System.out.println(" 3 :: To Display ");
        System.out.println(" 4 :: To Exit ");
        int choice = scan.nextInt();
        return choice;
    }


}
