public abstract class Vehicle
{
     protected String model;
     protected int year;
     public Vehicle(String mod , int yr)
     {
         this.model = mod;
         this.year = yr;
     }
     public abstract String FuelType();
     public abstract void Display();





}
