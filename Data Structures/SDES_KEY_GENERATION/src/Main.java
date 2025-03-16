import java.util.Arrays;

public class Main
{
    public static void main(String [] args)
    {
        SDES_KEY obj = new SDES_KEY();
        while (true) {
            int choice = obj.menu();
            switch (choice) {
                case 1:
                {
                    System.out.println();
                    int []originalKey = obj.input();
                    int[][] generatedKeys = obj.key_generator(originalKey);

                    System.out.println("Original Key: " + Arrays.toString(originalKey));
                    System.out.println("Generated Keys:");
                    for (int i = 0; i < generatedKeys.length; i++)
                    {
                        System.out.println("K" + (i + 1) + ": " + Arrays.toString(generatedKeys[i]));
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Exiting...");
                    break;
                }

                default:
                {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
