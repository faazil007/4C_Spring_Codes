import java.util.*;
public class Ceaser_Cipher
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter a Message to Encrypt");
        String message = scan.next();
        System.out.println(" Enter the Shift Value (integer) :");
        int shift = scan.nextInt();
        String encryptedMessage = encrypt(message , shift);
        System.out.println(" Encrypted Message : "+ encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage , shift);
        System.out.println(" Decrypted Message : " + decryptedMessage);
    }
    public static String encrypt(String message , int shift)
    {
        StringBuilder encrypted = new StringBuilder();
        for(int i =0;i<message.length();i++)
        {
            char ch = message.charAt(1);
            if(Character.isLetter())
            {
                char shifted = (char)(ch + shift);
            }
        }
    }
}
