import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        int choice;
        Function func = new Function();
        Student std = new Student();
        do {
            choice = func.menu();
            switch(choice)
            {
                case 1:
                {
                    Scanner scan = new Scanner(System.in);

                    System.out.println(" Name :: ");
                    std.name = scan.next();
                    System.out.println(" ID   :: ");
                    std.id = scan.nextInt();
                    System.out.println(" Age  :: ");
                    std.age = scan.nextInt();
                    func.addStudent(std);
                    break;
                }
                case 2:
                {
                    func.Display_Inorder(std);
                    break;
                }
                case 3:
                {
                    func.Display_Preorder(std);
                    break;
                }
                case 4:
                {
                    func.Display_Postorder(std);
                    break;
                }
                case 5:
                {
                    func.Display_Youngest_Student(std);
                    break;
                }
                case 6:
                {
                    func.Display_Eldest_Student(std);
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Choice ");
                }
            }

        }while(choice != 7);
    }

}
