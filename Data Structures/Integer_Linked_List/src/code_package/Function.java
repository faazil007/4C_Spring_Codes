package code_package;
import java.util.*;
public class Function
{
    LL head;
    Scanner scan = new Scanner(System.in);
    public void insertAtEnd()
    {
        LL l1 = new LL();
        System.out.println(" Enter the Element ");
        l1.data = scan.nextInt();
        if(head==null)
        {
            head=l1;
        }
        else
        {
            LL temp = new LL();
            temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=l1;
        }
    }
    public void insertAtFront()
    {
        LL l1 = new LL();
        System.out.println(" Enter the Element ");
        l1.data=scan.nextInt();
        l1.next=head;
        head=l1;

    }
    public void searchIndex()
    {
        LL temp = new LL();
        System.out.println(" Enter a Value to Search From Linked List");
        int value =scan.nextInt();
        int count=0;
        LL t_temp=null;
        int target_index=0;
        temp=head;
        while(temp!=null)
        {
            if(temp.data == value)
            {
                t_temp=temp;
                target_index=count;
            }
            count++;
        }
        System.out.println(" Index of Target Value is " + target_index);
    }
    public void display()
    {
        if(head == null)
        {
            System.out.println(" The List is Empty ");
        }
        else
        {
            LL temp=head;
            while (temp != null) {
                System.out.println(" Data :: " + temp.data);
                temp = temp.next;
            }

        }
    }
    public void deleteAtFront()
    {
        if(head == null)
        {
            System.out.println(" No Elements Found ");
        }
        else
        {
            head = head.next;
        }
    }
    public void deleteAtEnd()
    {
        if(head == null)
        {
            System.out.println(" No Elements Found ");
        }
        else
        {
            if(head.next==null)
            {
                head=null;
            }
            else
            {
                LL temp = head;
                while(temp.next.next!=null)
                {
                    temp=temp.next;
                }
                temp.next=null;
            }
        }
    }
    public void deleteSpecificNode() {
        System.out.println(" Enter the Value of the Node to Delete: ");
        int value = scan.nextInt();
        if (head == null) {
            System.out.println(" The List is Empty ");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println(" Node with value " + value + " deleted.");
            return;
        }
        LL temp = head;
        while (temp.next != null && temp.next.data != value)
        {
            temp = temp.next;
        }
        if (temp.next == null)
        {
            System.out.println(" Node with value " + value + " not found.");
        }
        else
        {
            temp.next = temp.next.next;
            System.out.println(" Node with value " + value + " deleted.");
        }
    }
    public int menu()
    {
        System.out.println(" 1 :: To insert at End ");
        System.out.println(" 2 :: To insert at front ");
        System.out.println(" 3 :: To Search Through List ");
        System.out.println(" 4 :: To Delete the Specific Node ");
        System.out.println(" 5 :: To Display the List ");
        System.out.println(" 6 :: To Exit ");
        int choice = scan.nextInt();
        return choice;
    }



}
