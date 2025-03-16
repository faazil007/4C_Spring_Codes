package code_package;

public class Stack
{
    public String [] stackArray;
    public int top;
    public int capacity;
    public Stack ()
    {
        this.capacity=100;
        this.top=-1;
        this.stackArray= new String[capacity];
    }
    public void push(String value )
    {
        if(top == capacity -1)
        {
            throw new IllegalStateException(" Stack Over Flow! Can't Push  ");
        }
        else
        {
            stackArray[++top]=value;
        }
    }
    public String pop()
    {
        if(isEmpty())
        {
            throw new IllegalStateException(" Stack Underflow! , Can't Pop ");
        }
        else
        {
            return stackArray[top--];
        }
    }
    public boolean isEmpty()
    {
        return top==-1;
    }
    public void clear()
    {
        top=-1;
    }
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
