public class Doctor {
    public static int doctorCounter = 1;  // Auto-incremented for unique ID
    public int doctorID;
    public String doctorName;
    public int experience;
    public int career_starting_age;
    public int age;
    public String contactNumber;
    public String category;
    public boolean isAvailable;

    public Doctor() {
        this.doctorID = doctorCounter++;
    }
}

