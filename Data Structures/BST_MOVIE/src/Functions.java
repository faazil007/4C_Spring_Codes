import java.util.*;
public class Functions
{
    public Scanner scan = new Scanner(System.in);
    Movie root;
    public void addMovie(Movie move)
    {

        if (root == null)
        {
            root = move;
        }
        else
        {
            Movie temp = root;
            while (true)
            {
                if (temp.Rating < move.Rating)
                {
                    if (temp.right == null)
                    {
                        temp.right = move;
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
                        temp.left = move;
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
    public Movie searchMovie(double rating)
    {
        Movie temp = root;
        while (temp != null)
        {
            if (temp.Rating == rating)
            {
                return temp;
            }
            else if (rating < temp.Rating)
            {
                temp = temp.left;
            }
            else
            {
                temp = temp.right;
            }
        }
        return null;
    }
    public int menu()
    {
        System.out.println(" 1:: Addition of Movies :: ");
        System.out.println(" 2:: Searching of Movies :: ");
        System.out.println(" 3:: Addition of Movies :: ");
        int choice = scan.nextInt();
        return choice;
    }



}
