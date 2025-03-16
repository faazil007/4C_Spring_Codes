import java.util.*;
public class Scientific_Calculator
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int choice;
        do
        {
            System.out.println(" Select An Operation");
            System.out.println("Press 1 for Applying Addition ");
            System.out.println("Press 2 for Applying Subtraction");
            System.out.println("Press 3 for Applying Multiplication ");
            System.out.println("Press 4 for Applying Division ");
            System.out.println("Press 5 for Taking Modulus  ");
            System.out.println("Press 6 for Finding Exponent ");
            System.out.println("Press 7 for Taking Logarithm ");
            System.out.println("Press 8 to Exit");
            choice = scanner.nextInt();
            System.out.print("Enter 1ST number: ");
            num1 = scanner.nextDouble();
            System.out.print("Enter  2ND number: ");
            num2 = scanner.nextDouble();
            switch (choice) {
                case 1:
                    System.out.println("Addition of"+num1+"and " + num2 +" is" + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Subtraction of"+num1+"and"+ num2 +" is" + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Product of"+num1+"and"+num2+"is" + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Division of "+num1+"and"+"num2"+"is" + (num1 / num2));
                    } else {
                        System.out.println(" Can't Divide With Zero");
                    }
                    break;
                case 5:
                    System.out.println("Modulus of "+num1+"and"+num2+"is"+ (num1 % num2));
                    break;
                case 6:
                    System.out.println("Exponential ANS :" + Math.pow(num1, num2));
                    break;
                case 7:
                    if (num1 > 0) {
                        System.out.println("Logarithm of"+num1+"and"+num2+"is" + Math.log(num1));
                    } else {
                        System.out.println("Logarithm Can't be Applied on Negative Numbers6");
                    }
                    break;
                case 8:
                {
                    System.out.println(" Thanks For Using Calculator "+"\n"+"Exiting  ");
                }
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != '8');


    }
}
