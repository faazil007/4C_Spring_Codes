import java.util.*;

public class Hospital_Management_System
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Insertion_of_Data data = new Insertion_of_Data();
        Patient pat = new Patient();
        Doctor doc = new Doctor();
        int choice;

        while (true)
        {
            choice = data.Menu();
            switch (choice)
            {
                case 1:
                {
                    // Validate Doctor's Name (Only alphabets and spaces allowed)
                    System.out.println("Enter Doctor Name:");
                    doc.doctorName = scan.next();
                    while (!doc.doctorName.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid name. Doctor's name should only contain alphabets and spaces. Please enter again:");
                        doc.doctorName = scan.next();
                    }

                    // Validate Contact Number
                    System.out.println("Enter Contact Number:");
                    doc.contactNumber = scan.next();
                    while (!doc.contactNumber.matches("\\d{10}")) {
                        System.out.println("Invalid contact number. Please enter a 10-digit number.");
                        doc.contactNumber = scan.next();
                    }

                    System.out.println(" Select Speciality:");
                    System.out.println(" 1: Cardio, 2: Dermatology, 3: ENT, 4: Medical, 5: Surgical ");
                    int choice2 = scan.nextInt();
                    switch(choice2)
                    {
                        case 1:
                            doc.category="Cardio";
                            break;
                        case 2:
                            doc.category="Dermatology";
                            break;
                        case 3:
                            doc.category = "ENT";
                            break;
                        case 4:
                            doc.category = "Medical";
                            break;
                        case 5:
                            doc.category = "Surgical";
                            break;
                        default:
                            System.out.println(" Invalid Character ");
                            break;
                    }

                    // Validate Doctor's Age
                    System.out.println(" Enter Age:");
                    while (true) {
                        doc.age = scan.nextInt();
                        if (doc.age > 0 && doc.age <= 120) {
                            break;
                        } else {
                            System.out.println("Invalid age. Please enter a valid age between 1 and 120:");
                        }
                    }

                    // Validate Career Starting Age
                    System.out.println(" Enter Career Starting Age:");
                    int s_age;
                    while (true) {
                        s_age = scan.nextInt();
                        if (s_age > 0 && s_age <= doc.age) {
                            break;
                        } else {
                            System.out.println("Career starting age must be less than or equal to the current age. Please enter a valid career starting age:");
                        }
                    }

                    // Validate Experience
                    System.out.println(" Enter Experience:");
                    int exp;
                    while (true) {
                        exp = scan.nextInt();
                        if (exp >= 0 && exp <= (doc.age - s_age)) {
                            break;
                        } else {
                            System.out.println("Experience cannot be negative or exceed the difference between the current age and the career starting age. Please enter a valid experience:");
                        }
                    }

                    doc.isAvailable = true;

                    data.addDoctors(doc);
                    break;
                }
                case 2:
                {
                    // Validate Patient ID
                    System.out.println("Enter Patient ID:");
                    pat.patientID = scan.nextInt();

                    // Validate Patient's Name (Only alphabets and spaces allowed)
                    System.out.println("Enter Patient Name:");
                    pat.patientName = scan.next();
                    while (!pat.patientName.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid name. Patient's name should only contain alphabets and spaces. Please enter again:");
                        pat.patientName = scan.next();
                    }

                    // Validate Patient Age
                    System.out.println("Enter Patient Age:");
                    while (true) {
                        pat.patientAge = scan.nextInt();
                        if (pat.patientAge > 0) {
                            break;
                        } else {
                            System.out.println("Invalid age. Please enter a valid positive age:");
                        }
                    }

                    // Validate Contact Number
                    System.out.println("Enter Contact Number:");
                    pat.contactNumber = scan.next();
                    while (!pat.contactNumber.matches("\\d{10}")) {
                        System.out.println("Invalid contact number. Please enter a 10-digit number:");
                        pat.contactNumber = scan.next();
                    }

                    // Validate Patient's Category
                    System.out.println("Choose Category :");
                    System.out.println(" 1: Cardio, 2: Dermatology, 3: ENT, 4: Medical, 5: Surgical ");
                    int choice3 = scan.nextInt();
                    while (choice3 < 1 || choice3 > 5)
                    {
                        System.out.println("Invalid choice. Please select a valid category (1-5):");
                        choice3 = scan.nextInt();
                    }

                    switch(choice3)
                    {
                        case 1:
                            pat.category = "Cardio";
                            break;
                        case 2:
                            pat.category = "Dermatology";
                            break;
                        case 3:
                            pat.category = "ENT";
                            break;
                        case 4:
                            pat.category = "Medical";
                            break;
                        case 5:
                            pat.category = "Surgical";
                            break;
                    }

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
                    data.displayAllPatients();
                    break;
                }
                case 5:
                {
                    data.displayAllDoctors();
                    break;
                }
                case 6:
                {
                    data.displayAllAppointments();
                    break;
                }
                case 7:
                {
                    System.out.println("Exiting...");
                    return;
                }
                default:
                {
                    System.out.println("Invalid Choice!");
                }
            }
        }
    }
}
