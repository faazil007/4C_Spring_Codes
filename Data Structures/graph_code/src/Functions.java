import java.util.*;
public class Functions
{
    Scanner scan = new Scanner(System.in);
    int count;
    User[] nodes = new User[100];
    int edges[][] = new int[100][100];
    public Functions()
    {
        for(int i =0 ; i < 100 ; i++)
        {
            nodes[i] = new User();
            for(int j =0 ; j < 100 ; j++)
            {
                edges[i][j] = -1;
            }
        }
    }
    public void addUser()
    {
        if(count == nodes.length)
        {
            System.out.println(" Can't Insert Array is Full ");
        }
        else
        {
            String u_name;
            System.out.println(" Enter Name :: ");
            u_name = scan.next();
            int searched = Search(u_name);
            if(searched == -1)
            {
                nodes[count].name = u_name;
                count++;
            }
            else
            {
                System.out.println(" User Already Exists ");
            }
        }
    }
    public void checkFriendship()
    {
        System.out.println(" Enter Name of First Friend          :: ");
        String name = scan.next();
        System.out.println(" Enter the Name of the Second Friend :: ");
        String name2 = scan.next();
        int i = Search(name);
        int j = Search(name2);
        if(i == -1 || j == -1)
        {
            System.out.println(" One or Both Does'nt Exist !");
        }
        else
        {
            if(edges[i][j] == 1 || edges[j][i] == 1)
            {
                System.out.println(name + " and " + name2 + " are Friends     ");
            }
            else
            {
                System.out.println(name + " and " + name2 + " are Not Friends ");
            }
        }

    }
    public void displayAllUsers()
    {
        if(count == 0 )
        {
            System.out.println(" No Users Found !");
        }
        else
        {
            for(int i =0 ; i < count ; i++)
            {
                System.out.println(nodes[i]);
            }
        }

    }
    public int menu()
    {
        System.out.println(" 1 :: To Add Users                            :: ");
        System.out.println(" 2 :: To Add Friendships                      :: ");
        System.out.println(" 3 :: To Check Friendship Between Two Friends :: ");
        System.out.println(" 4 :: To Display All Users                    :: ");
        System.out.println(" 5 :: To Display friends of Specific User     :: ");
        System.out.println(" 6 :: Exit                                    :: ");
        int choice = scan.nextInt();
        return choice;
    }
    public void displayFriends()
    {
        System.out.println(" Enter User Name :: ");
        String u_name = scan.next();
        int searched = Search(u_name);
        if(searched== -1)
        {
            System.out.println(" User Does'nt Exists ");
        }
        else
        {
            for(int i =0 ; i <  count ; i++)
            {
                if(edges[searched][i] == 1 || edges[i][searched] == 1)
                {
                    System.out.println(nodes[i]);
                }

            }
        }
    }
    public void addEdge()
    {
        System.out.println(" Enter Name of First Friend          :: ");
        String name = scan.next();
        System.out.println(" Enter the Name of the Second Friend :: ");
        String name2 = scan.next();
        int i = Search(name);
        int j = Search(name2);
        if(i == -1 || j == -1)
        {
            System.out.println(" One or Both Does'nt Exist !");
        }
        else
        {
            edges[i][j] = 1;
            edges[j][i] = 1;
        }
    }
    public int Search(String u_name)
    {
        for (int i = 0; i < count; i++)
        {
            if (nodes[i].name.equalsIgnoreCase(u_name))
            {
                return i;
            }

        }
        return -1;
    }


}
