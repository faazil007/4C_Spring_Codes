import java.util.*;
public class Insertion_of_Data
{
    Scanner scan = new Scanner(System.in);
    private Patient[] patients;
    private Patient[] awaitedPatients;
    private Doctor[] doctors;
    private Appointments[] appointments;
    int sizePatient = 20;
    int sizeAwaitedPatient=20;
    int sizeDoctor = 20;
    int sizeAppointments = 20;
    int patientCount;
    int awaitedCount;
    int doctorCount;
    int appointmentCount;

    public Insertion_of_Data()
    {
        patients = new Patient[sizePatient];
        awaitedPatients = new Patient[sizeAwaitedPatient];
        doctors = new Doctor[sizeDoctor];
        appointments = new Appointments[sizeAppointments];
        for(int i = 0 ; i < (sizeAwaitedPatient) ; i++)
        {
            awaitedPatients[i] = new Patient();
        }
        for(int i =0 ; i < sizePatient ; i++)
        {
            patients[i] = new Patient();
        }
        for(int i =0 ; i < sizeDoctor ; i++)
        {
            doctors[i] = new Doctor();
        }
        patientCount = 0;
        doctorCount = 0;
        appointmentCount = 0;
        awaitedCount=0;
    }

    public void addDoctors(Doctor dod)
    {
        doctors[doctorCount].doctorID = dod.doctorID;
        doctors[doctorCount].doctorName = dod.doctorName;
        doctors[doctorCount].contactNumber = dod.contactNumber;
        doctors[doctorCount].category = dod.category;
        doctors[doctorCount].isAvailable = dod.isAvailable;
        doctorCount++;
    }

    public void addPatients(Patient pat)
    {
        patients[patientCount].patientID = pat.patientID;
        patients[patientCount].patientName = pat.patientName;
        patients[patientCount].patientAge = pat.patientAge;
        patients[patientCount].contactNumber = pat.contactNumber;
        patients[patientCount].category_ailment = pat.category_ailment;
        schedule_Appointments(patients[patientCount]);
        patientCount++;

    }

    public void schedule_Appointments(Patient patient)
    {
        boolean appointmentScheduled = false;

        for (int i = 0; i < doctorCount; i++)
        {
            if (patient.category_ailment.equalsIgnoreCase(doctors[i].category) && doctors[i].isAvailable)
            {
                appointments[appointmentCount] = new Appointments(patient, doctors[i]);
                doctors[i].isAvailable = false;
                appointmentCount++;
                System.out.println("Appointment of Patient " + patient.patientName + "scheduled successfully with Doctor: " + doctors[i].doctorName);
                appointmentScheduled = true;
                break;
            }
            else
            {
                System.out.println("No available doctors found for the patient's ailment.");
                awaitedPatients[i] = patient;
                awaitedCount++;
            }
        }

    }
    public void markDoctorAvailable(int doctorID)
    {
        for (int i = 0; i < doctorCount; i++)
        {
            if (doctors[i].doctorID == doctorID)
            {
                doctors[i].isAvailable = true;
                System.out.println("Doctor " + doctors[i].doctorName + " is now available.");
                processAwaitedPatients();
                return;
            }
        }
        System.out.println("Doctor with ID " + doctorID + " not found.");
    }
    private void processAwaitedPatients()
    {
        for (int i = 0; i < awaitedCount; i++)
        {
            for (int j = 0; j < doctorCount; j++)
            {
                if (awaitedPatients[i] != null && awaitedPatients[i].category_ailment.equalsIgnoreCase(doctors[j].category) && doctors[j].isAvailable)
                {
                    appointments[appointmentCount] = new Appointments(awaitedPatients[i], doctors[j]);
                    doctors[j].isAvailable = false;
                    System.out.println("Awaited patient " + awaitedPatients[i].patientName + " scheduled with Doctor " + doctors[j].doctorName);
                    appointmentCount++;
                    dequeueAwaitedPatient(i);
                    break;
                }
            }
        }
    }
    private void dequeueAwaitedPatient(int index)
    {
        for (int i = index; i < awaitedCount - 1; i++)
        {
            awaitedPatients[i] = awaitedPatients[i + 1];
        }
        awaitedPatients[--awaitedCount] = null;
    }
    public void freeThePatient()
    {
        if (appointmentCount > 0)
        {
            int firstIndex = 0;
            Doctor doc = appointments[firstIndex].doctor;
            System.out.println("Patient " + appointments[firstIndex].patient.patientName + " has been removed from appointments.");
            markDoctorAvailable(doc.doctorID);
            dequeueAppointment(firstIndex);
        }
        else
        {
            System.out.println("No appointments to free.");
        }
    }

    public void freeThePatient(int patientID)
    {
        for (int i = 0; i < appointmentCount; i++)
        {
            if (appointments[i].patient.patientID == patientID)
            {
                markDoctorAvailable( appointments[i].doctor.doctorID);
                System.out.println("Patient " + appointments[i].patient.patientName + " has been removed from appointments.");
                dequeueAppointment(i);
                return;
            }
        }
        System.out.println("No appointment found for patient ID " + patientID);
    }
    private void dequeueAppointment(int index)
    {
        for (int i = index; i < appointmentCount - 1; i++)
        {
            appointments[i] = appointments[i + 1];
        }
        appointments[--appointmentCount] = null;
    }
    public void displayAllPatients()
    {
        if (patientCount == 0)
        {
            System.out.println(" Empty !");
            System.out.println(" Add Patients !");
        }
        else
        {
            System.out.println("                 :: Database For Patients ::     ");
            for (int i = 0; i < patientCount; i++)
            {
                System.out.println(patients[i]);
            }
        }
    }
    public void displayAllDoctors()
    {
        if (doctorCount == 0)
        {
            System.out.println(" Empty  !");
            System.out.println(" Add Doctors !");
        }
        else
        {
            System.out.println("                 :: Database For Doctors ::       ");
            for (int i = 0; i < doctorCount; i++)
            {
                System.out.println(doctors[i]);
            }
        }
    }

    public void displayAllAppointments()
    {
        if (appointmentCount == 0)
        {
            System.out.println(" No Appointments Registered Yet  !");
            System.out.println(" Register Appointments !");
        }
        else
        {
            System.out.println("                 :: Database For Appointments ::       ");
            for (int i = 0; i < appointmentCount; i++)
            {
                System.out.println(appointments[i]);
            }
        }
    }

    public void status()
    {
        System.out.println(" Total Patients Arrived are        : " + patientCount);
        System.out.println(" Total Doctors in Hospital  are    : " + doctorCount);
        System.out.println(" Total Appointments Registered are : " + appointmentCount);
    }

    public int Menu()
    {
        System.out.println("           :: Hospital Management System :: ");
        System.out.println(" 1 :: Enter Doctors Data                                   :: ");
        System.out.println(" 2 :: Register an Appointment                              :: ");
        System.out.println(" 3 :: Treat 33the Patient                                     :: ");
        System.out.println(" 4 :: Free the Patient in Case of Appointment Cancellation :: ");
        System.out.println(" 5 :: View Records of Patients                             :: ");
        System.out.println(" 6 :: View Data of Doctors                                 :: ");
        System.out.println(" 7 :: View All Registered Appointments                     :: ");
        System.out.println(" 8 :: Check Status                                         :: ");
        System.out.println(" 9 :: Exit                                                 :: ");

        int choice = scan.nextInt();
        return choice;
    }


    private void ensureCapacityForPatients()
    {
        if (patientCount == sizePatient)
        {
            sizePatient *= 2;
            resizeArrayPatient(sizePatient);
        }
    }

    public void resizeArrayPatient(int capacitypatient)
    {
        Patient[] patients_2 = new Patient[capacitypatient];
        for (int i = 0; i < patientCount; i++)
        {
            patients_2[i] = patients[i];
        }
        patients = patients_2;
    }

    private void shrinkCapacityForPatients()
    {
        if (patientCount < sizePatient / 10 && sizePatient > 10)
        {
            sizePatient /= 5;
            resizeArrayPatient(sizePatient);
        }
    }

    private void ensureCapacityForDoctors()
    {
        if (doctorCount == sizeDoctor)
        {
            sizeDoctor *= 2;
            resizeArrayDoctor(sizeDoctor);
        }
    }

    public void resizeArrayDoctor(int capacityDoctor)
    {
        Doctor[] doctors_2 = new Doctor[capacityDoctor];
        for (int i = 0; i < patientCount; i++)
        {
            doctors_2[i] = doctors[i];
        }
        doctors = doctors_2;
    }

    private void shrinkCapacityForDoctors()
    {
        if (doctorCount < sizeDoctor / 10 && sizeDoctor > 10)
        {
            sizeDoctor /= 5;
            resizeArrayPatient(sizeDoctor);
        }
    }

    private void ensureCapacityForAppointments()
    {
        if (appointmentCount == sizeAppointments)
        {
            sizeAppointments *= 2;
            resizeArrayAppointments(sizeAppointments);
        }
    }

    public void resizeArrayAppointments(int capacityAppointments)
    {
        Appointments[] appointments_2 = new Appointments[capacityAppointments];
        for (int i = 0; i < appointmentCount; i++)
        {
            appointments_2[i] = appointments[i];
        }
        appointments = appointments_2;
    }

    private void shrinkCapacityForAppointments()
    {
        if (appointmentCount < sizeAppointments / 10 && sizeAppointments > 10)
        {
            sizeAppointments /= 5;
            resizeArrayAppointments(sizeAppointments);
        }
    }
}
