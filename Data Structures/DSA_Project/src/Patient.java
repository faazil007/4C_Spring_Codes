public class Patient
{
    public int patientID;
    public String patientName;
    public int patientAge;
    public String contactNumber;
    public String category_ailment;
    public String toString()
    {
       String str =  "Patient{Name='" + patientName + '\'' + ", Age=" + patientAge + ", Contact_Number='" + contactNumber + '\'' + ", Ailment='" + category_ailment + '\'' + '}';
       return str;
    }
}
