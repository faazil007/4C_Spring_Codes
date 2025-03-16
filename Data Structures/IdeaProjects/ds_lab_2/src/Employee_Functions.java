import java.util.*;
public class Employee_Functions
{
    Scanner scan = new Scanner(System.in);
    Employee emp[]= new Employee[10];
    public void input()
    {
        Scanner scan = new Scanner(System.in);
        for(int i =0; i < emp.length ; i++)
        {
            System.out.println(" Enter Name of the Employee ");
            String nme = scan.next();
            System.out.println(" Enter ID of Employee ");
            int id = scan.nextInt();
            System.out.println(" Enter Age of Employee ");
            int age = scan.nextInt();
            System.out.println(" Enter Salary of Employee ");
            double sal = scan.nextDouble();
            emp[i] = new Employee(nme , id , age , sal);
        }
    }
    public void menu()
    {
        System.out.println(" Press 1 for Input");
        System.out.println(" Press 2 for Displaying all Employees");
        System.out.println(" Press 3 for Displaying Specific Employee by ID");
        System.out.println(" Press 4 for Displaying Youngest Employee ");
        System.out.println(" Press 5 for Displaying Employee According to Given Age ");
        System.out.println(" Press 6 for Displaying Employee Whose Salary is Greater than Given Salary ");
        System.out.println(" Press 7 for Removing Data of Specific Employee ");
        System.out.println(" Press 8 for Updating Data of Specific Employee");
        System.out.println(" Press 9 for Calculating Average Salary of Employees");
        System.out.println(" Press 10 to Exit ");
    }
    public void Younger_Employee()
    {
        Employee young_emp = emp[0];
        for(int i =0; i < emp.length ; i++)
        {
            if(emp[i].age < young_emp.age)
            {
                young_emp = emp[i];
            }

        }
        System.out.println(" Name of Employee " + young_emp.name);
        System.out.println(" ID of Employee " + young_emp.emp_id);
        System.out.println(" Age of Employee" + young_emp.age);
        System.out.println(" Salary of Employee " + young_emp.salary);
    }
    public void Display_Employee()
    {
        for(int i =0 ; i< emp.length ; i++)
        {
            System.out.println(" Name of Employee " + emp[i].name);
            System.out.println(" ID of Employee " + emp[i].emp_id);
            System.out.println(" Age of Employee" + emp[i].age);
            System.out.println(" Salary of Employee " + emp[i].salary);
        }
    }
    public void id_Employee()
    {

        System.out.println(" Enter ID of that Specific Person ");
        int id = scan.nextInt();
        for(int i =0; i < emp.length ; i++)
        {
            if(emp[i].emp_id == id)
            {
                System.out.println(" Name of Employee " + emp[i].name);
                System.out.println(" ID of Employee " + emp[i].emp_id);
                System.out.println(" Age of Employee" + emp[i].age);
                System.out.println(" Salary of Employee " + emp[i].salary);
            }
            else
            {
                System.out.println(" ID Not Matched ");
            }
        }
    }
    public void great_Salary()
    {
        System.out.println(" Enter Fixed Salary to Check ");
        double salary = scan.nextDouble();
        for(int i = 0 ; i < emp.length; i++)
        {
            if(emp[i].salary > salary)
            {
                System.out.println(" Name of Employee " + emp[i].name);
                System.out.println(" ID of Employee " + emp[i].emp_id);
                System.out.println(" Age of Employee" + emp[i].age);
                System.out.println(" Salary of Employee " + emp[i].salary);
            }
            else
            {
                System.out.println(" No One Have Salary Greater Than Given Salary");
            }
        }
    }
    public void remove_employee()
    {
        System.out.println(" Enter ID of that Specific Person You want to Remove ");
        int id = scan.nextInt();
        boolean check = false;
        for(int i =0; i < emp.length ; i++)
        {
            if(emp[i].emp_id == id)
            {
                for(int j = i ; j < emp.length-1; j++ )
                {
                    emp[j] = emp[j + 1];
                }
                emp[emp.length -1] = null;
                check = true;
                System.out.println(" Employee With ID " + emp[i].emp_id + " has been Removed");
                break;
            }
        }
        if(!check)
        {
            System.out.println(" Employee Not Found");
        }
    }
    public void update_employee()
    {
        System.out.println(" Enter ID of that Specific Person You want to Update ");
        int id = scan.nextInt();
        for(int i =0; i < emp.length ; i++)
        {
            if(emp[i].emp_id == id)
            {
                System.out.println(" Enter Updated Name");
                emp[i].name = scan.next();
                System.out.println(" Enter Updated Age ");
                emp[i].age = scan.nextInt();
                System.out.println(" Enter Updated Salary ");
                emp[i].salary = scan.nextDouble();
                break;
            }
        }
    }
    public void calculate_avg_salary()
    {
        double sum_sal = 0.0;
        for(int i =0; i < emp.length ; i++)
        {
            sum_sal = sum_sal + emp[i].salary;
        }
        double avg_sal = sum_sal / 10;
        System.out.println(" Average Salary of Each Employee is " + avg_sal);
    }
    public void age_Employee()
    {

        System.out.println(" Enter Age of that Specific Person ");
        int age = scan.nextInt();
        for(int i =0; i < emp.length ; i++)
        {
            if(emp[i].age == age)
            {
                System.out.println(" Name of Employee " + emp[i].name);
                System.out.println(" ID of Employee " + emp[i].emp_id);
                System.out.println(" Age of Employee" + emp[i].age);
                System.out.println(" Salary of Employee " + emp[i].salary);
            }
            else
            {
                System.out.println(" Age Not Matched ");
            }
        }
    }

}
