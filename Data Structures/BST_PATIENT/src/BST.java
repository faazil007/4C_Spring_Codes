import java.util.*;
public class BST
{
    Patient [] data;
    int size;
    int count;
    public BST()
    {
        this.size = 20;
        data = new Patient[size];
        for(int i = 0 ; i < size ; i++)
        {
            data[i] = new Patient();
            data[i].r=-1;
            data[i].l = -1;
        }
        count =0;
    }
    public void addPatients()
    {
        Scanner scan = new Scanner(System.in);
        Patient pat = new Patient();
        System.out.println(" Name of the Patient :: ");
        data[count].name = scan.next();
        System.out.println(" ID of the Patient   :: ");
        data[count].id = scan.nextInt();
        System.out.println(" Medical Condition   :: ");
        data[count].medicalCondition = scan.next();
        if(count == data.length)
        {
            System.out.println(" Tree is Full ! Can't Insert ");

        }
        int index=0;
        if(count > 0)
        {
            while(true)
            {
                if(data[index].id < data[count].id)
                {
                    if(data[index].r == -1)
                    {
                        data[index].r = count;
                        break;
                    }
                }
                else
                {
                    if(data[index].id > data[count].id)
                    {
                        if(data[index].l == -1)
                        {
                            data[index].l = count;
                            break;
                        }
                    }
                }

            }
        }
        count++;
    }
    public void searchByID()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter the ID you want to Search from Tree :: ");
        int target_id = scan.nextInt();
        if(count == 0 )
        {
            System.out.println(" Tree is Empty.");
        }
        else
        {
            for(int i = 0 ; i < count; i++)
            {
                if(data[i].id == target_id)
                {
                    System.out.println(data[i]);
                }
            }
        }
    }

    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" 1 :: To Add Patients ");
        System.out.println(" 2 :: Display List of Patients Based on Medical Condition ");
        System.out.println(" 3 :: Search a Patient By ID ");
        int choice = scan.nextInt();
        return choice;
    }
    public void ListPatient()
    {
        if(count == 0 )
        {
            System.out.println(" Tree is Empty");
        }
        else
        {
            String target = "Serious";
            String target2 = "Medium";
            String target3 = "Normal";
            for(int i =0 ; i < count ; i++)
            {
                if(data[i].medicalCondition.equalsIgnoreCase(target))
                {
                    System.out.println(data[i]);
                }
            }
            for(int i =0 ; i < count; i++)
            {
                if(data[i].medicalCondition.equalsIgnoreCase(target2))
                {
                    System.out.println(data[i]);
                }
            }
            for(int i =0 ; i < count; i++)
            {
                if(data[i].medicalCondition.equalsIgnoreCase(target3))
                {
                    System.out.println(data[i]);
                }
            }



        }
    }



}
