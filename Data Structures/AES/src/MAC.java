
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class MAC
{
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        String secretKey = "mySecretKey";
        byte[] keyBytes = secretKey.getBytes();
        String message = "Hello , World!";
        try{
            SecretKey secret = new SecretKeySpec(keyBytes , "hmacSHA256");
            byte[] mac = calculateMAC(message.getBytes() , secret);
            boolean isValid = verifyMAC(message.getBytes() , mac , secret);
            System.out.println(" Message :: " + message);
            System.out.println(" MAC :: " + bytesToHex(mac));
            System.out.println(" IS Valid :: " + isValid);
        }catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

    }
    private static byte[] calculateMAC(byte[] message , SecretKey key) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(key.getEncoded());
        return md.digest(message);
    }
    private static boolean verifyMAC(byte[] message ,byte[]mac , SecretKey key) throws NoSuchAlgorithmException
    {
        byte[] calculatedMAC = calculateMAC(message , key);
        return MessageDigest.isEqual(calculatedMAC , mac);
    }
    private static String bytesToHex(byte[] bytes)
    {
        StringBuilder hexStringBuilder = new StringBuilder(2 * bytes.length);
        for(byte b : bytes)
        {
            hexStringBuilder.append(String.format("%02x" , b));
        }
        return hexStringBuilder.toString();
    }


}
