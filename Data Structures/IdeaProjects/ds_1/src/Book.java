public class Book
{
    public int bookID;
    public String title;
    public boolean isAvailable;
    public Book(int b_id, String tit)
    {
        this.bookID = b_id;
        this.title = tit;
        this.isAvailable = true;
    }
    public void Borrow_Book()
    {
        if(isAvailable)
        {
            isAvailable = false;
            System.out.println(" The Book " + title + " is Successfully Borrowed ");
        }
        else
        {
            System.out.println(" The Book is Currently not Available ");
        }
    }
    public void Return_Book()
    {
        if(!isAvailable)
        {
            isAvailable = true;
            System.out.println(" The Book " + title + " is Succesfully Returned ");
        }
        else
        {
            System.out.println(" The Book Was Not Borrowed ");
        }
    }
    public int getBookID()
    {
        return bookID;
    }
    public String toString()
    {
        String str = " Title " + title + "\n" + " Book ID " + bookID + "\n" ;
        return str;
    }
    public void Display_books()
    {
        String status;
        if(isAvailable)
        {
            status = " Available";
        }
        else
        {
            status = " Un Available";
        }
        System.out.println(" Book's ID " + bookID + "\n" + " Book's Title " + title + "\n"+ " Status " + status);

    }

}