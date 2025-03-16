import java.util.*;
public class Operations
{
    Scanner scan = new Scanner(System.in);
    Process start;
    public void Enqueue()
    {
        Process proc = new Process();
        System.out.println(" Process ID   :: ");
        proc.process_id = scan.nextInt();
        System.out.println(" Process Time :: ");
        proc.process_time = scan.nextDouble();

        if(start == null)
        {
            start = proc;
        }
        else
        {
            Process temp = new Process();
            temp = start;
            while(temp.next!=null)
            {
                temp = temp.next;

            }
            temp.next = proc;
        }

    }
    public void Dequeue() {
        Process temp = start;
        Process shortest = start;
        Process prev = null;
        Process prevSmallest = null;
        while (temp != null) {
            if (temp.process_time < shortest.process_time) {
                shortest = temp;
                prevSmallest = prev;
            }
            prev = temp;
            temp = temp.next;
        }
        if (shortest == start) {
            start = start.next;
        } else {
            prevSmallest.next = shortest.next;
        }
        System.out.println(" Dequeued Successfully " + shortest);
    }




    public void Display()
    {
        Process temp = start;
        while(temp != null)
        {
            System.out.println(" Process ID   :: " + temp.process_id);
            System.out.println(" Process Time :: " + temp.process_time);
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
