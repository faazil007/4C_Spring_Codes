public class Patient
{
    public int id;
    public String name;
    public String medicalCondition;
    public int l,r;
    public String toString()
    {
        String str = "ID of Patient :: " + id + " Name of Patient :: " + name + "\n" + " Medical Condition " + medicalCondition + "\n";
        return str;
    }

}
