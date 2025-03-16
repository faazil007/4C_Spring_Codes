import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class SimpleAESExample
{
    public static void main(String[] args) throws Exception
    {
        String originalText = "Hello, AES!";
        System.out.println(" Original Text : " + originalText);
        SecretKey secretKey = generateSecretKey();
        String encryptedText = encrypt(originalText, secretKey);
        System.out.println(" Encrypted Text : " + encryptedText);
        String decryptedText = decrypt(encryptedText , secretKey);
        System.out.println(" Decrypted Text : " + decryptedText);

    }
    private static SecretKey generateSecretKey() throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }
    private static String encrypt(String plainText , SecretKey secretKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE , secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    private static String decrypt(String encrptedText , SecretKey secretKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE , secretKey);
        byte [] encryptedBytes = Base64.getDecoder().decode(encrptedText);
        byte [] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}
