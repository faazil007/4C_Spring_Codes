public class Student
{
    public String name;
    public int age;
    public int id;
    Student left, right;
    public String toString()
    {
        String str = " Name :: " + name + "\n" + " Age :: " + age + "\n" + " ID :: " + id + "\n";
        return str;
    }
}
