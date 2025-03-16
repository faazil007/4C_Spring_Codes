package code_package;
import java.util.*;
public class Functions
{
    PlayList head;
    public void addSongAtStart()
    {
        PlayList pl = new PlayList();
        pl.next=head;
        head=pl;
    }
    public void addSongAtEnd()
    {
        PlayList pl = new PlayList();
        if(head == null)
        {
            head = pl;
        }
        else
        {
            PlayList tail = new PlayList();
            tail = head;
            while(tail.next!=null)
            {

            }
        }
    }

}
