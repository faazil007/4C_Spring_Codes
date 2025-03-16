import java.util.Scanner;

class Transaction {
    String type;
    double amount;
    String date;

    public Transaction(String type, double amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Type: " + type + "\nAmount: " + amount + "\nDate: " + date;
    }
}