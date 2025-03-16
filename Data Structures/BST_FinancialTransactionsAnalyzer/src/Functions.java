import java.util.*;
public class Functions
{
    public Scanner scan = new Scanner(System.in);
    FTA root;
    int transaction_count=0;
    double sum = 0.0;
    double avg=0.0;
    boolean added = false;
    public void addTransaction(FTA trans)
    {
        if(root == null)
        {
            root = trans;
        }
        else
        {
            FTA temp = root;
            while(true)
            {
                if(temp.transactionAmount < trans.transactionAmount)
                {
                    if(temp.right == null)
                    {
                        temp.right = trans;
                        added = true;
                        sum+=trans.transactionAmount;
                        break;
                    }
                    else
                    {
                        temp = temp.right;
                    }
                }
                else
                {
                    if(temp.left == null)
                    {
                        temp.left = trans;
                        sum+=trans.transactionAmount;
                        added = true;
                        break;
                    }
                    else
                    {
                        temp = temp.left;
                    }
                }
                if(added)
                {
                    transaction_count++;
                }

            }
        }
    }
    public int count_Transactions()
    {
        return transaction_count;
    }
    public double calculate_Average_Transaction()
    {
        avg = sum/transaction_count;
        return avg;

    }
    public double total_transaction_amount()
    {
        return sum;
    }




}
