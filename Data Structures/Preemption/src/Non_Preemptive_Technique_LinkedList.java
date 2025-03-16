import java.util.*;
public class Non_Preemptive_Technique_LinkedList
{
    Scanner scan = new Scanner(System.in);
    Process head;
    public void enqueue()
    {
        System.out.println();
        Process process = new Process();
        System.out.println(" Process ID :: ");
        process.processID = scan.nextInt();
        System.out.println(" Allocated Time ");
        process.processTime = scan.nextDouble();
        System.out.println();
        if(head == null)
        {
            head = process;
        }
        else
        {
            Process temp = head;
            while(temp.next!= null)
            {
                temp = temp.next;
            }
            temp.next = process;
        }
    }
    public Process node_finder() {
        if (head == null) {
            return null; // Return null if the list is empty
        }

        Process temp = head;
        Process target_node = head;
        double shortest_time = temp.processTime;

        while (temp != null) {
            if (temp.processTime < shortest_time) {
                shortest_time = temp.processTime;
                target_node = temp;
            }
            temp = temp.next;
        }
        return target_node;
    }

    public void dequeue() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }

        Process node = node_finder();
        if (node == null) {
            System.out.println("No process found to dequeue.");
            return;
        }

        if (head == node) {
            System.out.println("Process ID " + node.processID + " with Time " + node.processTime + " is Executed.");
            head = head.next;
            return;
        }

        Process temp = head;
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }

        if (temp.next == node) {
            System.out.println("Process ID " + node.processID + " with Time " + node.processTime + " is Executed.");
            temp.next = temp.next.next;
        } else {
            System.out.println("Process not found in the list.");
        }
    }

    public void Display()
    {
        Process temp = head;
        while(temp != null)
        {
            System.out.println();
            System.out.println(" Process ID     :: " + temp.processID);
            System.out.println(" Allocated Time :: " + temp.processTime);
            System.out.println();
            temp = temp.next;
        }
    }
    public int menu()
    {
        System.out.println();
        System.out.println(" 1 ::  Enqueue Processes ");
        System.out.println(" 2 ::  Dequeue Processes ");
        System.out.println(" 3 ::  Display Processes ");
        System.out.println(" 4 ::  Exit              ");
        System.out.println();
        int choice = scan.nextInt();
        System.out.println();
        return choice;
    }
}
