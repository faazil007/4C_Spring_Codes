package code_package;

public class Book {
    public int bookID;
    public double bookPrice;
    public String bookTitle;
    public int bookEdition;
    public String subject;
    public int noOfCopies;

    @Override
    public String toString() {
        return "Book [ID=" + bookID + ", Price=" + bookPrice + ", Title=" + bookTitle +
                ", Edition=" + bookEdition + ", Subject=" + subject + ", Copies=" + noOfCopies + "]";
    }
}
