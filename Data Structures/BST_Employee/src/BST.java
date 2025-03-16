import java.util.*;
public class BST
{
    int count;
    Employee employees[] = new Employee[10];
    Scanner scan = new Scanner(System.in);
    public BST()
    {
        for(int i =0 ; i < employees.length; i++)
        {
            employees[i] = new Employee();
            count =0;
            employees[i].l = -1;
            employees[i].r = -1;
        }
    }
    public void addEmployees()
    {
        Employee emp = new Employee();
        System.out.println(" Employee's Name :: ");
        emp.name = scan.next();
        System.out.println(" Employee's Age :: ");
        emp.age = scan.nextInt();
        addEmployee(emp);
    }
    public void addEmployee(Employee emp)
    {
        if (count == employees.length)
        {
            System.out.println(" Tree is Full !");
        }
        else
        {
            if (count == 0)
            {
                employees[count] = emp;
            }
            else if (count > 0)
            {
                int index = 0;
                while (true)
                {
                    if (employees[index].age < employees[count].age)
                    {
                        if (employees[index].r == -1)
                        {
                            employees[index].r = count;
                            break;
                        }
                        else
                        {
                            index = employees[index].r;
                        }
                    }
                    else
                    {
                        if (employees[index].l == -1)
                        {
                            employees[index].l = count;
                            break;
                        }
                        else
                        {
                            index = employees[index].l;
                        }
                    }
                }
                count++;
            }
        }
    }

    public void minify() {
        int p = (count / 2) - 1;
        for (int i = p; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < count && employees[left].age < employees[smallest].age) {
            smallest = left;
        }

        if (right < count && employees[right].age < employees[smallest].age) {
            smallest = right;
        }

        if (smallest != i) {
            Employee temp = employees[i];
            employees[i] = employees[smallest];
            employees[smallest] = temp;
            heapify(smallest);
        }
    }

    public void sort() {
        for (int i = count - 1; i > 0; i--) {
            Employee temp = employees[0];
            employees[0] = employees[i];
            employees[i] = temp;
            count--;
            minify();
        }
    }


    public int menu()
    {
        System.out.println(" 1 :: Add Employees");
        System.out.println(" 2 :: Sort Them ");;
        System.out.println(" 3 :: Display Using Heap ");
        System.out.println(" 4 :: Exit ");
        int choice = scan.nextInt();
        return choice;
    }
    public void displayAllBooks()
    {
        if (count == 0)
        {
            System.out.println("No Data Available");
        }
        else
        {
            for(int i =0 ; i < count ; i++)
            {
                System.out.println(employees[i]);
            }
        }
    }



}
