public class Appointments
{
    public Patient patient;
    public Doctor doctor;

    public Appointments(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public String toString()
    {
        return "Appointment{Patient=" + patient.patientName + ", Doctor=" + doctor.doctorName + "}";
    }
}
