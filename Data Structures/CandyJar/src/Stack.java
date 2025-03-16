import java.util.*;
public class Stack
{
    private String [] stack;
    private int top;
    private int capacity;
    public Stack()
    {
        this.capacity = 10;
        stack = new String[capacity];
        top = -1;
    }
    public void push(String value)
    {
        if(top == capacity - 1)
        {
            System.out.println(" Stack is Full ,, Cannot Push " + value);
        }
        else
        {
            stack[++top] = value;
        }
    }
    public String pop()
    {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        } else {
            return stack[top--];
        }

    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i]);
        }
    }





}
