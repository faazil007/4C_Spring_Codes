import java.util.*;
public class Non_Preemptive_Technique_Array
{
    int size = 10;
    Process processes[] = new Process[size];
    Scanner scanner = new Scanner(System.in);
    int count;
    public Non_Preemptive_Technique_Array()
    {
        for(int i =0 ; i < processes.length; i++)
        {
            processes[i] = new Process();
            count =0;
        }
    }
    public void enqueue()
    {
        System.out.println(" Process ID    :: ");
        processes[count].processID = scanner.nextInt();
        System.out.println(" Allocate Time :: ");
        processes[count].processTime = scanner.nextDouble();
        count++;
        ensureCapacity();
    }
    public int index_finder()
    {
        int index=0;
        double min_time = processes[0].processTime;
        for(int i =1 ; i < count ; i++)
        {
            if(processes[i].processTime < min_time)
            {
                min_time = processes[i].processTime;
                index = i;
            }
        }
        return index;

    }
    public void dequeue()
    {
        int index = index_finder();
        if(index < 0 || index >= count)
        {
            System.out.println(" Invalid Index ");
            return;
        }
        for(int i =index ; i < count - 1 ; i++)
        {
            processes[i] = processes[i+1];
        }
        processes[count-1] = new Process();
        count--;
        shrinkCapacity();
    }
    public int menu()
    {
        System.out.println(" 1 ::  Enqueue Processes ");
        System.out.println(" 2 ::  Dequeue Processes ");
        System.out.println(" 3 ::  Display Processes ");
        System.out.println(" 4 ::  Exit              ");
        int choice = scanner.nextInt();
        return choice;
    }
    public void Display()
    {
        for(int i =0 ; i < count; i++)
        {
            System.out.println();
            System.out.println(" Process ID     :: " + processes[i].processID);
            System.out.println(" Allocated Time :: " + processes[i].processTime );
            System.out.println();
        }
    }


    public void ensureCapacity()
    {
        if(count == size)
        {
            size *=2;
            resizeArray(size);

        }
    }
    public void resizeArray(int size_2)
    {
        Process processes_2[] = new Process[size_2];
        for(int i =0 ; i < count; i++)
        {
            processes_2[i] = processes[i];
        }
        processes = processes_2;

    }
    private void shrinkCapacity()
    {
        if (count < size / 10 && size > 10)
        {
            size /= 5;
            resizeArray(size);
        }
    }



}
