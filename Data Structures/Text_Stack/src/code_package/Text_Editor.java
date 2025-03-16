package code_package;
import java.util.*;
public class Text_Editor
{
    Scanner scan = new Scanner(System.in);
    private Stack redoStack;
    private Stack stack;

    public Text_Editor()
    {

        this.redoStack= new Stack();
        this.stack=new Stack();

    }

    public void addText(String text)
    {
        stack.push(text);
        redoStack.clear();
    }
    public void undo()
    {
        if(!stack.isEmpty())
        {
            redoStack.push(stack.pop());
        }
        else
        {
            System.out.println(" Nothibg to Undo ");
        }
    }
    public void redo()
    {
        if(!redoStack.isEmpty())
        {
            stack.push(redoStack.pop());
        }
        else
        {
            System.out.println(" Nothing to Redo ");
        }
    }
    public void displayStack()
    {
        System.out.println(" Current Stack: " + stack);
    }
    public void displayRedoStack()
    {
        System.out.println(" Redo Stack : " + redoStack);
    }
    public int menu()
    {
        System.out.println(" 1 :: To Enter the Text ");
        System.out.println(" 2 :: To Undo ");
        System.out.println(" 3 :: To Redo ");
        System.out.println(" 4 :: To Display  Stack ");
        System.out.println(" 5 :: To Display Redo Stack ");
        System.out.println(" 6 :: To Exit ");
        int choice = scan.nextInt();
        return choice;
    }


}
