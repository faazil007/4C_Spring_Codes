import java.util.*;
public class EmergencyRoomQueue
{
    Patient start;
    Scanner scan = new Scanner(System.in);

    public void Enqueue()
    {
        Patient pat = new Patient();
        System.out.println(" Patient ID :: ");
        pat.patientId = scan.nextInt();
        System.out.println(" Patient Name :: ");
        pat.patient_name = scan.next();
        System.out.println(" Condition Severity :: ");
        pat.condition_severity = scan.nextInt();

        if(start == null)
        {
            start = pat;
        }
        else
        {
            if(pat.condition_severity == 1)
            {
                pat.next = start;
                start = pat;
            }
            else
            {
                Patient temp = start;
                while(temp.next!= null)
                {
                    temp = temp.next;
                }
                temp.next = pat;
            }
        }
    }
    public void Dequeue()
    {
        Patient temp = new Patient();
        temp = start;
        Patient target_temp = null;
        if(start == null)
        {
            System.out.println(" Empty_______");
        }
        else
        {
            start = start.next;
        }
    }
    public void Display()
    {
        Patient temp = start;
        while(temp!=null)
        {
            System.out.println(" Patient ID   :: " + temp.patientId);
            System.out.println(" Patient Name :: " + temp.patient_name);
            if(temp.condition_severity == 1)
            {
                System.out.println(" Patient is in Critical Situation ");
            }
            else
            {
                System.out.println(" Patient is in Normal Situation ");
            }
            temp = temp.next;

        }
    }
    public int menu()
    {
        System.out.println(" 1 :: Enqueue :: ");
        System.out.println(" 2 :: Dequeue :: ");
        System.out.println(" 3 :: Display :: ");
        int choice = scan.nextInt();
        return choice;
    }

}
