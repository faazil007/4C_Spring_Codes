import javax.xml.crypto.Data;
import java.util.*;
public class addition
{
    int count;
    Scanner scan = new Scanner(System.in);
    Data_Node data[];
    public addition()
    {
        count =0;
        data = new Data_Node[100];
        for(int i =0 ; i < data.length; i++)
        {
            data[i] = new Data_Node();
            data[i].l=-1;
            data[i].r=-1;
        }

    }
    public int addData()
    {
        Data_Node data = new Data_Node();
        System.out.println(" Enter Data :: ");
        data.data = scan.nextInt();
        return data;

    }
}
