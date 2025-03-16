import java.util.Scanner;
public class Preemptive_Technique_Array {
    int size = 10;
    Process processes[] = new Process[size];
    Scanner scanner = new Scanner(System.in);
    int count;
    double quantumTime = 2.0;

    public Preemptive_Technique_Array()
    {
        for (int i = 0; i < processes.length; i++)
        {
            processes[i] = new Process();
        }
        count = 0;
    }

    public void enqueue()
    {
        System.out.println("Enter Process ID: ");
        processes[count].processID = scanner.nextInt();
        System.out.println("Enter Allocated Time: ");
        processes[count].processTime = scanner.nextDouble();
        count++;
        ensureCapacity();
        preemptIfNecessary();
    }


    public void preemptIfNecessary()
    {
        int shortestIndex = index_finder();
        if (shortestIndex != 0)
        {
            System.out.println("Preempting Process ID " + processes[0].processID + " for Process ID " + processes[shortestIndex].processID);
            processes[0].processTime -= quantumTime;
            if (processes[0].processTime > 0)
            {
                moveProcessToEnd(0);
            }
            else
            {
                System.out.println("Process ID " + processes[0].processID + " completed.");
                dequeue_2(0);
            }
            swapProcesses(0, shortestIndex);
        }
    }

    public int index_finder()
    {
        int index = 0;
        double min_time = processes[0].processTime;

        for (int i = 1; i < count; i++)
        {
            if (processes[i].processTime < min_time)
            {
                min_time = processes[i].processTime;
                index = i;
            }
        }
        return index;
    }

    public void dequeue()
    {
        dequeue_2(0);
    }

    private void dequeue_2(int index)
    {
        if (index < 0 || index >= count)
        {
            System.out.println("Invalid Index.");
            return;
        }

        for (int i = index; i < count - 1; i++)
        {
            processes[i] = processes[i + 1];
        }

        processes[count - 1] = new Process();
        count--;
        shrinkCapacity();
    }

    public void moveProcessToEnd(int index)
    {
        Process temp = processes[index];
        for (int i = index; i < count - 1; i++) {
            processes[i] = processes[i + 1];
        }
        processes[count-1] = temp;
    }

    public void swapProcesses(int index1, int index2)
    {
        Process temp = processes[index1];
        processes[index1] = processes[index2];
        processes[index2] = temp;
    }

    public int menu()
    {
        System.out.println("1 :: Enqueue Processes");
        System.out.println("2 :: Dequeue Processes");
        System.out.println("3 :: Display Processes");
        System.out.println("4 :: Exit");
        int choice = scanner.nextInt();
        return choice;
    }

    public void display()
    {
        if (count == 0) {
            System.out.println("No processes to display.");
            return;
        }

        for (int i = 0; i < count; i++)
        {
            System.out.println();
            System.out.println("Process ID     :: " + processes[i].processID);
            System.out.println("Allocated Time :: " + processes[i].processTime);
            System.out.println();
        }
    }

    public void ensureCapacity()
    {
        if (count == size) {
            size *= 2;
            resizeArray(size);
        }
    }

    public void resizeArray(int newSize)
    {
        Process[] newProcesses = new Process[newSize];
        for (int i = 0; i < count; i++)
        {
            newProcesses[i] = processes[i];
        }
        processes = newProcesses;
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
