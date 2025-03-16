package code_package;

public class LinkedList
{
    private Node head;

    public LinkedList()
    {
        this.head = null;
    }


    public void push(Book book)
    {
        Node existingNode = findBook(book);
        if (existingNode != null)
        {
            existingNode.book.noOfCopies += book.noOfCopies;
            return;
        }
        Node newNode = new Node(book);
        newNode.next = head;
        head = newNode;
    }


    public Book pop()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("List is empty! Cannot pop.");
        }
        if (head.book.noOfCopies > 1)
        {
            head.book.noOfCopies--;
            return head.book;
        }
        Book removedBook = head.book;
        head = head.next;
        return removedBook;
    }


    public void append(Book book)
    {
        Node existingNode = findBook(book);
        if (existingNode != null)
        {
            existingNode.book.noOfCopies += book.noOfCopies;
            return;
        }
        Node newNode = new Node(book);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public Book removeLast()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("List is empty! Cannot remove.");
        }
        if (head.next == null)
        { // Only one node
            if (head.book.noOfCopies > 1)
            {
                head.book.noOfCopies--;
                return head.book;
            }
            Book removedBook = head.book;
            head = null;
            return removedBook;
        }
        Node temp = head;
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        if (temp.next.book.noOfCopies > 1)
        {
            temp.next.book.noOfCopies--;
            return temp.next.book;
        }
        Book removedBook = temp.next.book;
        temp.next = null;
        return removedBook;
    }


    private Node findBook(Book book)
    {
        Node current = head;
        while (current != null)
        {
            if (current.book.bookTitle.equals(book.bookTitle) &&
                    current.book.bookEdition == book.bookEdition)
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null)
        {
            sb.append(temp.book.toString());
            if (temp.next != null)
            {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}


