import java.io.*;
import java.util.*;

public class Insertion_of_Data {
    Scanner scan = new Scanner(System.in);
    private Patient[] patients;
    private Doctor[] doctors;
    private Appointments[] appointments;
    private Patient[] awaitedPatients;
    int patientCount, doctorCount, appointmentCount;
    int sizePatient = 20, sizeAwaitedPatient = 20, sizeDoctor = 20, sizeAppointments = 20;
    File_Handler fileHandler;

    public Insertion_of_Data() {
        patients = new Patient[sizePatient];
        awaitedPatients = new Patient[sizeAwaitedPatient];
        doctors = new Doctor[sizeDoctor];
        appointments = new Appointments[sizeAppointments];
        patientCount = 0;
        doctorCount = 0;
        appointmentCount = 0;
        for (int i = 0; i < (sizeAwaitedPatient); i++) {
            awaitedPatients[i] = new Patient();
        }
        for (int i = 0; i < sizePatient; i++) {
            patients[i] = new Patient();
        }
        for (int i = 0; i < sizeDoctor; i++) {
            doctors[i] = new Doctor();
        }
    }

    public void addDoctors(Doctor doc) {
        // Increment the doctorCounter to generate unique doctor ID
        doc.doctorID = Doctor.doctorCounter++;
        doctors[doctorCount] = doc;
        doctorCount++;
        try {
            fileHandler = new File_Handler("doctors.txt", true);
            fileHandler.writeData(doc.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPatients(Patient pat) {
        // Increment the patientCounter to generate unique patient ID
        pat.patientID = Patient.patientCounter++;
        patients[patientCount] = pat;
        patientCount++;
        schedule_Appointments(patients[patientCount - 1]);
        try {
            fileHandler = new File_Handler("patients.txt", true);
            fileHandler.writeData(pat.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void schedule_Appointments(Patient patient) {
        boolean appointmentScheduled = false;

        for (int i = 0; i < doctorCount; i++) {
            if (patient.category.equalsIgnoreCase(doctors[i].category) && doctors[i].isAvailable) {
                appointments[appointmentCount] = new Appointments(patient, doctors[i]);

                appointmentCount++;

                try {
                    fileHandler = new File_Handler("appointments.txt");
                    fileHandler.writeData(appointments[appointmentCount - 1].toString() + "\n");
                    System.out.println("Appointment scheduled for " + patient.patientName);
                    appointmentScheduled = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }
        }

        if (!appointmentScheduled) {
            System.out.println("No available doctor for the patient's ailment.");
        }
    }

    public void freeThePatient() {
        if (appointmentCount > 0) {
            Patient freedPatient = appointments[0].patient;

            try {
                fileHandler = new File_Handler("patients.txt");
                fileHandler.removeData(freedPatient.patientName);  // Remove the patient data from file
                System.out.println("Patient " + freedPatient.patientName + " has been removed from appointments.");
                dequeueAppointment();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No appointments to free.");
        }
    }

    public void markDoctorAvailable(int doctorID) {
        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i].doctorID == doctorID) {
                doctors[i].isAvailable = true;
                System.out.println("Doctor " + doctors[i].doctorName + " is now available.");
                return;
            }
        }
        System.out.println("Doctor with ID " + doctorID + " not found.");
    }

    public void dequeueAppointment() {
        for (int i = 0; i < appointmentCount - 1; i++) {
            appointments[i] = appointments[i + 1];
        }
        appointments[--appointmentCount] = null;
    }

    public void displayAllPatients() {
        try {
            fileHandler = new File_Handler("patients.txt");
            String fileData = fileHandler.readData();
            if (fileData.isEmpty()) {
                System.out.println("No patients found.");
            } else {
                System.out.println(fileData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllDoctors() {
        try {
            fileHandler = new File_Handler("doctors.txt");
            String fileData = fileHandler.readData();
            if (fileData.isEmpty()) {
                System.out.println("No doctors found.");
            } else {
                System.out.println(fileData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllAppointments() {
        try {
            fileHandler = new File_Handler("appointments.txt");
            String fileData = fileHandler.readData();
            if (fileData.isEmpty()) {
                System.out.println("No appointments found.");
            } else {
                System.out.println(fileData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int Menu() {
        System.out.println("1. Enter Doctor Data");
        System.out.println("2. Register an Appointment");
        System.out.println("3. Free the Patient");
        System.out.println("4. View Patients");
        System.out.println("5. View Doctors");
        System.out.println("6. View Appointments");
        System.out.println("7. Exit");
        int choice = scan.nextInt();
        return choice;
    }
}
