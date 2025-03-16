package code_package;
import java.util.*;
public class Emergency
{
    Scanner scan = new Scanner(System.in);
    Hospital head;
    public void Enqueue()
    {
        Hospital hos = new Hospital();
        System.out.println(" Enter Patient Name :: ");
        hos.patient_name = scan.next();
        System.out.println(" Is Patient Serious or Not ? y/n ");
        char check = scan.next().charAt(0);
        if(check == 'Y' || check == 'y')
        {
            hos.serious_patient = true;
        }
        else
        {
            hos.serious_patient = false;
        }
        if(head == null)
        {
            head = hos;
        }
        else
        {
            hos.next = head;
            head = hos;
        }

    }
    public void Dequeue()
    {
        Hospital t_temp = null;
        Hospital temp = new Hospital();
        temp = head;
    while(temp != null)
    {
        if(temp.serious_patient == true)
        {
            temp = null;
        }
    }
    head = head.next;


    }
    public void display()
    {
        Hospital temp = new Hospital();
        if(head == null)
        {
            System.out.println(" No Passengers Added ");
        }
        else
        {
            temp = head;
            while (temp != null)
            {
                System.out.println(" Patient Name :: "+ temp.patient_name);
                if(temp.serious_patient == true)
                {
                    System.out.println(" Patient is Serious ");
                }
                else
                {
                    System.out.println(" Patient is Normal ");
                }
                temp = temp.next;
            }
        }
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
