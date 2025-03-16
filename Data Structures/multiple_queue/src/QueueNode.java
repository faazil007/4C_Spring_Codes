public class QueueNode
{
    Transaction transaction;
    QueueNode next;
    public QueueNode(Transaction transaction)
    {
        this.transaction = transaction;
        this.next =null;
    }

}
