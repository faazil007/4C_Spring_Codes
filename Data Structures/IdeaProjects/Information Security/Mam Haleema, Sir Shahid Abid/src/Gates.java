import java.util.*;
public class Gates
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter Value for A ");
        int a = sc.nextInt();
        System.out.println(" Enter Value for B ");
        int b = sc.nextInt();
        System.out.println(a^b);
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(~(a | b));
    }

}
