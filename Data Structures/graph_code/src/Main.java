public class Main
{
    public static void main(String [] args)
    {
        Functions func = new Functions();
        int choice;
        while(true)
        {
            choice = func.menu();
            switch(choice)
            {
                case 1:
                {
                    func.addUser();
                    break;
                }
                case 2:
                {
                    func.addEdge();
                    break;
                }
                case 3:
                {
                    func.checkFriendship();
                    break;
                }
                case 4:
                {
                    func.displayAllUsers();
                    break;
                }
                case 5:
                {
                    func.displayFriends();
                    break;
                }
                case 6:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Choice !");
                }
            }
        }
    }

}
