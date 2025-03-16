import java.util.*;
public class Hospital_Management_System
{
    public static void main(String [] args)
    {


        Scanner scan = new Scanner(System.in);
        Insertion_of_Data data = new Insertion_of_Data();
        Patient pat = new Patient();
        Doctor doc = new Doctor();
        int choice;
        while(true)
        {
            choice = data.Menu();
            switch(choice)
            {
                case 1:
                {
                    System.out.println(" Doctor ID      ::  ");
                    doc.doctorID = scan.nextInt();
                    System.out.println(" Doctor Name    ::  ");
                    doc.doctorName = scan.next();
                    System.out.println(" Contact Number ::  ");
                    doc.contactNumber = scan.next();
                    System.out.println(" Speciality     ::  ");
                    doc.category = scan.next();
                    doc.isAvailable = true;
                    data.addDoctors(doc);
                    break;
                }
                case 2:
                {
                    System.out.println(" Patient ID     ::  ");
                    pat.patientID = scan.nextInt();
                    System.out.println(" Patient Name   ::  ");
                    pat.patientName = scan.next();
                    System.out.println(" Patient Age    ::  ");
                    pat.patientAge = scan.nextInt();
                    System.out.println(" Contact Number ::  ");
                    pat.contactNumber= scan.next();
                    System.out.println(" Ailment        ::  ");
                    pat.category_ailment= scan.next();
                    data.addPatients(pat);
                    break;
                }
                case 3:
                {
                    data.freeThePatient();
                    break;

                }
                case 4:
                {
                    System.out.println(" Enter Patient ID Whose Appointment is Cancelled :: ");
                    int patientID = scan.nextInt();
                    data.freeThePatient(patientID);
                    break;
                }
                case 5:
                {
                    data.displayAllPatients();
                    break;
                }
                case 6:
                {
                    data.displayAllDoctors();
                    break;
                }
                case 7:
                {
                    data.displayAllAppointments();
                    break;
                }
                case 8:
                {
                    data.status();
                    break;
                }
                case 9:
                {
                    break;
                }
                default:
                {
                    System.out.println(" Invalid Choice ! ");
                }

            }
        }
    }
}
