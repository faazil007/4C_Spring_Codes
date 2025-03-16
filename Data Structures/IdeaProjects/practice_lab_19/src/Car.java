public class Car extends Vehicle
{
    public String fuel_type;
    public Car(String model , int year)
    {
        super(model , year);
    }
    public String FuelType()
    {
        this.fuel_type = " This Car is Using Gasoline";
        return fuel_type;

    }
    public void Display()
    {
            System.out.println(" Car's Model " + model);
            System.out.println(" Car's Manufacturer Year " + year);
            System.out.println(" Fuel Type " + FuelType());

    }

}
