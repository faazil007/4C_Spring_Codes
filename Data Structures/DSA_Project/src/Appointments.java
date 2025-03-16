public class Appointments
{
    public Patient patient;
    public Doctor doctor;
    public Appointments(Patient patient , Doctor doctor)
    {
        this.patient = patient;
        this.doctor = doctor;
    }

    public String toString()
    {
        String str =  "Appointment{patient=" + patient.patientName + ", doctor=" + doctor.doctorName + '}';
        return str;
    }
}
