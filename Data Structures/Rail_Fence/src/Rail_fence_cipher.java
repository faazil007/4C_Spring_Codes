import java.util.*;
public class Rail_fence_cipher
{
    public static String encrypt(String plainText, int rails)
    {
        if (rails <= 1)
        {
            return plainText;
        }
        char[][] fence = new char[rails][plainText.length()];
        for (int i = 0; i < rails; i++)
        {
            for (int j = 0; j < plainText.length(); j++)
            {
                fence[i][j] = '\0'; // Initialize the array with null characters
            }
        }
        int rail = 0;
        boolean directionDown = true;
        for (int i = 0; i < plainText.length(); i++)
        {
            fence[rail][i] = plainText.charAt(i);
            if (rail == 0)
            {
                directionDown = true;
            }
            else if (rail == rails - 1)
            {
                directionDown = false;
            }
            if (directionDown)
            {
                rail++;
            }
            else
            {
                rail--;
            }
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < rails; i++)
        {
            for (int j = 0; j < plainText.length(); j++)
            {
                if (fence[i][j] != '\0')
                {
                    encryptedText.append(fence[i][j]);
                }
            }
        }
        return encryptedText.toString();
    }
    public static String decrypt(String cipherText, int rails)
    {
        if (rails <= 1)
        {
            return cipherText;
        }
        char[][] fence = new char[rails][cipherText.length()];
        for (int i = 0; i < rails; i++)
        {
            for (int j = 0; j < cipherText.length(); j++)
            {
                fence[i][j] = '\0'; // Initialize the array with null characters
            }
        }
        int rail = 0;
        boolean directionDown = true;
        for (int i = 0; i < cipherText.length(); i++)
        {
            fence[rail][i] = '*';
            if (rail == 0)
            {
                directionDown = true;
            }
            else if (rail == rails - 1)
            {
                directionDown = false;
            }
            if (directionDown)
            {
                rail++;
            }
            else
            {
                rail--;
            }
        }
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < cipherText.length(); j++) {
                if (fence[i][j] == '*' && index < cipherText.length()) {
                    fence[i][j] = cipherText.charAt(index++);
                }
            }
        }
        StringBuilder decryptedText = new StringBuilder();
        rail = 0;
        directionDown = true;
        for (int i = 0; i < cipherText.length(); i++) {
            decryptedText.append(fence[rail][i]);
            if (rail == 0) {
                directionDown = true;
            } else if (rail == rails - 1) {
                directionDown = false;
            }
            if (directionDown) {
                rail++;
            } else {
                rail--;
            }
        }
        return decryptedText.toString();
    }
    public static void main(String[] args) {
        String plainText = "meetmeaftermeeting";
        int rails = 3;
        String encryptedText = encrypt(plainText, rails);
        System.out.println("Encrypted: " + encryptedText);
        String decryptedText = decrypt(encryptedText, rails);
        System.out.println("Decrypted: " + decryptedText);
    }
}