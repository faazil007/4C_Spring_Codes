package code_package;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Text_Editor textEditor = new Text_Editor();
        int choice;
        do {
            choice = textEditor.menu();
            switch(choice)
            {
                case 1:
                {
                    System.out.println(" Enter the Text ");
                    String text = scan.next();
                    textEditor.addText(text);
                    break;
                }
                case 2:
                {
                    textEditor.undo();
                    break;
                }
                case 3:
                {
                    textEditor.redo();
                    break;
                }
                case 4:
                {
                    textEditor.displayStack();
                    break;
                }
                case 5:
                {
                    textEditor.displayRedoStack();
                    break;
                }
                case 6:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Character ");
                }
            }
        }while(choice!=6);



    }
}
