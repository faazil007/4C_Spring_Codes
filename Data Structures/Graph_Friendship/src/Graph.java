import java.util.*;
public class Graph
{
    User start;
   public User search(String userid)
   {
       User t = start;
       while(t!=null)
       {
           if(t.userID.equalsIgnoreCase(userid))
           {
               return t;
           }
           t = t.user_next;
       }
       return null;
   }
   public void addUser(String u_ID)
   {
       User t = search(u_ID);
       if(t!=null)
       {
           System.out.println(" Already Exists ! ");
       }
       else
       {
           User x = new User();
           x.userID = u_ID;
           x.user_next = start;
           start = x;
       }
   }
   public void addFriendship(String x , String y , int no_days)
   {
       User t = search(x);
       User t1 = search(y);
       if(t == null || t1 == null)
       {
           System.out.println(" One or Both Does'nt Exist ");
       }
       else
       {
           Adjacent z = new Adjacent();
           z.id = y;
           z.next = t.adjacent_next;
           z.days = no_days;
           t.adjacent_next = z;
       }
   }
   public void checkFriendship(String x , String y)
   {
       User temp = search(x);
       if(temp == null)
       {
           System.out.println(" User Does'nt Exist");
       }
       Adjacent adjacent = temp.adjacent_next;
       while(adjacent != null)
       {
           if(adjacent.id.equalsIgnoreCase(y))
           {
               System.out.println(" Friendship Exists");
           }
           adjacent = adjacent.next;
       }
   }
   public void displayFriends(String id)
   {
       User temp = search(id);
       if(temp == null)
       {
           System.out.println(" User Does'nt Exist ");
           return;
       }
       System.out.println(" Friends Are :: ");
       Adjacent adjacent = temp.adjacent_next;
       while(adjacent != null)
       {
           System.out.println(" Adjacents are :: " + adjacent.id);
           adjacent = adjacent.next;
       }

   }
   public int menu()
   {
       Scanner scan = new Scanner(System.in);
       System.out.println(" 1 :: Add Vertices                       !");
       System.out.println("2  :: Add Friendship                     !");
       System.out.println("3  :: All Friends With Given USer        !");
       System.out.println("4  :: Check Friendship Between Two Users !");
       System.out.println("5 :: Exit ");
       int choice = scan.nextInt();
       return choice;
   }

}
