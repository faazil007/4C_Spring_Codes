import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        Graph gr = new Graph();
        int choice;
        while(true)
        {
            choice = gr.menu();
            switch(choice)
            {
                case 1:
                {
                    System.out.println(" Enter UserID :: ");
                    String userID = scan.next();
                    System.out.println(" Enter User Name :: ");
                    String u_name = scan.next();
                    System.out.println(" Enter Age :: ");
                    int age = scan.nextInt();
                    gr.addUser(userID);
                    break;
                }
                case 2:
                {
                    System.out.println(" Enter First User ID  :: ");
                    String user1 = scan.next();
                    System.out.println(" Enter Second User ID :: ");
                    String user2 = scan.next();
                    System.out.println(" Enter No of Days :: ");
                    int days = scan.nextInt();
                    gr.addFriendship(user1 , user2 ,days);
                    break;
                }
                case 3:
                {
                    System.out.println(" Enter User ID  :: ");
                    String id = scan.next();
                    gr.displayFriends(id);
                    break;


                }
                case 4:
                {
                    System.out.println(" Enter User1 ID ::  ");
                    String user1 = scan.next();
                    System.out.println(" Enter User2 ID :: ");
                    String user2 = scan.next();
                    gr.checkFriendship(user1 , user2);
                    break;

                }
                case 5:
                {
                    break;
                }
            }
        }
    }

}
