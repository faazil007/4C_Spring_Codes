import java.util.*;
public class Student_Data {
    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Press 1 for Check ");
        System.out.println(" Press 2 to Exit ");
        int choice = scan.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1: {

                    Scanner scan = new Scanner(System.in);
                    System.out.println(" Enter Total Credit Hours ");
                    int c_hours = scan.nextInt();
                    System.out.println(" Enter Quality Points ");
                    double q_points = scan.nextDouble();
                    while(q_points <0|| q_points > 60)
                    {
                        System.out.println(" Invalid Input Enter Again");
                        q_points = scan.nextDouble();
                    }
                    double cgpa = q_points / c_hours;
                    if (cgpa < 2.5) {
                        System.out.println(" Student is Not Completing Degree Requirement");
                    } else {
                        System.out.println(" Student is Qualified for Award of Degree ");
                    }
                }
                case 2: {
                    break;
                }
                default: {
                    System.out.println(" Invalid Input ");
                }
            }


        } while (choice != 3) ;

    }
}

