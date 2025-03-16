package code_package;
import java.util.*;
public class Functions
{
    Scanner scan = new Scanner(System.in);
    opStack start;
    evStack start1;
    public char pop()
    {
        if(start == null)
        {
            return null;
        }
        else
        {
            char c=start.x;
            start=start.n;
            return c;
        }

    }
    public void push(char c)
    {
        opStack s = new opStack();
        s.x=c;
        s.n=start;
        start=s;
    }
    char peak()
    {
        if(start==null)
        {
            return null;
        }
        else
        {
            return start.x;
        }
    }
    public void infixTopostfix()
    {
        String infix,pf = null;
        System.out.println(" Enter the String ");
        infix = scan.next();
        int  i=0;
        while(i < infix.length())
        {
            char c = infix.charAt(i);
            if(c=='+' || c=='-' || c== '*' || c == '/' || c == '(' || c== ')')
            {
                start==null;
                if(peak()==null || c=='/' || c=='(')
                {
                    push(c);
                    i++;

                }
                else if(c=='*')
                {
                    if(peak()=='/')
                    {
                        pf=pf+pop();
                    }
                    else
                    {
                        push(c);
                        i++;
                    }
                }
                else if(c=='-')
                {
                    if(peak()=='/')
                    {
                        pf=pf+pop();
                    }
                    else
                    {
                        push(c);
                        i++;
                    }
                }
                else if(c=='+')
                {
                    if(peak()=='/')
                    {
                        pf=pf+pop();
                    }
                    else
                    {
                        push(c);
                        i++;
                    }
                }
                else if(c ==')')
                {
                    while(peak()!='c') {
                        pf = pf + pop();
                    }
                        pop();
                        i++;
                    }

                }
            else
            {
                pf=pf+c;
                i++;
            }

        }
    }
}
