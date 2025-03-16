public class Book
{
    public int id;
    public String title;
    public String author;
    public boolean availability;
    public double price;
    public int l,r;
    public String toString()
    {
        String str = " ID :: " + id + "\n" + " Title :: " + title + "\n" + " Author :: " + author + "\n" + " Availablity " + availability + " \n" + " Price :: " + price + "\n";
        return str;
    }
}
