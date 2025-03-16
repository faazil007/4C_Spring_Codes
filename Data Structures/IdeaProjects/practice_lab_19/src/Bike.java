public class Bike extends Vehicle
{
    public String Fuel_type;
   public Bike(String model , int year)
   {
       super(model , year);
   }
   public String FuelType()
   {
       this.Fuel_type = " This Vehicle is Using Diesel or Fuel";
       return Fuel_type;
   }
    public void Display()
    {
        System.out.println(" Car's Model " + model);
        System.out.println(" Car's Manufacturer Year " + year);
        System.out.println(" Fuel Type " + FuelType());

    }
}
