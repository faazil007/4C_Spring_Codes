import java.util.*;
public class Function {
    Scanner scan = new Scanner(System.in);
    Student root;

    public void addStudent(Student std)
    {

        if (root == null)
        {
            root = std;
        }
        else
        {
            Student temp = root;
            while (true)
            {
                if (temp.age < std.age)
                {
                    if (temp.right == null)
                    {
                        temp.right = std;
                        break;
                    }
                    else
                    {
                        temp = temp.right;
                    }
                }
                else
                {
                    if (temp.left == null)
                    {
                        temp.left = std;
                        break;
                    }
                    else
                    {
                        temp = temp.left;
                    }
                }
            }
        }

    }

    public void Display_Inorder(Student std)
    {
        if (std == null)
        {
            return;
        }
        else
        {
            Display_Inorder(std.left);
            System.out.println(std);
            Display_Inorder(std.right);
        }

    }

    public void Display_Preorder(Student std)
    {
        if (std == null)
        {
            return;
        }
        else
        {
            System.out.println(std);
            Display_Preorder(std.left);
            Display_Preorder(std.right);
        }
    }

    public void Display_Postorder(Student std)
    {
        if (std == null)
        {
            return;
        }
        else
        {
            Display_Postorder(std.left);
            Display_Postorder(std.right);
            System.out.println(std);
        }

    }

    public void Display_Youngest_Student(Student std)
    {
        if (root == null)
        {
            System.out.println(" Tree is Empty....");
        }
        else
        {
            Student temp = root;
            while (true)
            {

                if (temp.left == null)
                {
                    return;
                }
                else
                {
                    temp = temp.left;
                }
                System.out.println(temp);
            }
        }
    }
    public void Display_Eldest_Student(Student std)
    {
        if (root == null)
        {
            System.out.println(" Tree is Empty....");
        }
        else
        {
            Student temp = root;
            while (true)
            {
                if (temp.right == null)
                {
                    return;
                }
                else
                {
                    temp = temp.right;
                }
                System.out.println(temp);
            }
        }
    }
    public int menu()
    {
        System.out.println(" Add ");
        System.out.println(" Display InOrder ");
        System.out.println(" Display PreOrder ");
        System.out.println(" Display PostOrder ");
        System.out.println(" Display Youngest  ");
        System.out.println(" Display eldest ");
        int choice = scan.nextInt();
        return choice;

    }

}

