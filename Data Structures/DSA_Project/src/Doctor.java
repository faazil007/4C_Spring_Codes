public class Doctor
{
    public int doctorID;
    public String doctorName;
    public String contactNumber;
    public String category;
    public boolean isAvailable;
    public String toString()
    {
         String str ="Doctor{Name='" + doctorName + '\'' + ", ID='" + doctorID + '\'' + ", IsAvailable=" + isAvailable + '\'' + ", Contact_Number=" + contactNumber + '\'' + " Speciality=" + category + '\'' +'}';
         return str;
    }





}
