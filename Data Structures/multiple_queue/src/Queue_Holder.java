public class Queue_Holder
{
    private Transaction[] transactions;
    private int front;
    private int rear;
    private int size;

    public Queue_Holder(int capacity)
    {
        transactions = new Transaction[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue_Transactions(Transaction transaction)
    {
        if (size == transactions.length)
        {
            System.out.println("Queue is full! Cannot add more transactions.");
            return;
        }
        if (rear == transactions.length - 1)
        {
            rear = -1;
        }
        transactions[++rear] = transaction;
        size++;
    }

    public Transaction dequeue_Transactions()
    {
        if (size == 0)
        {
            return null;
        }
        Transaction data = transactions[front + 1];
        if (front == transactions.length - 1)
        {
            front = -1;
        }
        front++;
        size--;
        return data;
    }

    public void displayTransactions()
    {
        if (size == 0)
        {
            System.out.println("No transactions available.");
            return;
        }
        int index = front + 1;
        for (int i = 0; i < size; i++)
        {
            if (index == transactions.length)
            {
                index = 0;
            }
            System.out.println(transactions[index++]);
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}