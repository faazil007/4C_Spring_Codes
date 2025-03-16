import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256 {
    public static void main(String[] args)
    {
        String input = "Hello , Hash Algorithm!";
        try {
            String hash = generateSHA256Hash(input);
            System.out.println("Original Message is :: " + input);
            System.out.println("Hash :: " + hash);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }

    public static String generateSHA256Hash(String input) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes)
        {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1)
            {
                hexString.append('0'); // 1-character hex values ke liye padding
            }
            hexString.append(hex); // Yeh line missing thi, jo hex values ko append karti hai
        }
        return hexString.toString();
    }
}
