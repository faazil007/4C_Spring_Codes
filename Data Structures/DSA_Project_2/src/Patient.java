public class Patient {
    public static int patientCounter = 1;  // Auto-incremented for unique ID
    public int patientID;
    public String patientName;
    public int patientAge;
    public String contactNumber;
    public String category;

    public Patient() {
        this.patientID = patientCounter++;
    }
}
