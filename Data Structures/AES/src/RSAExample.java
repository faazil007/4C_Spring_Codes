import java.math.BigInteger;
import java.util.Scanner;

public class RSAExample {
    private static BigInteger privateKey;
    private static BigInteger publicKey;
    private static BigInteger modulus;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // User se p aur q input lena
        System.out.println("Enter a prime number (p): ");
        BigInteger p = new BigInteger(scan.nextLine());

        System.out.println("Enter another prime number (q): ");
        BigInteger q = new BigInteger(scan.nextLine());

        generateKeys(p, q);

        System.out.println("\nPublic Key  :: " + publicKey);
        System.out.println("Private Key :: " + privateKey);
        System.out.println("Modulus (n) :: " + modulus);

        System.out.println("\nEnter a Message to Encrypt!");
        String message = scan.nextLine();

        BigInteger encryptedMessage = encrypt(message);
        System.out.println("\nEncrypted Message :: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted Message :: " + decryptedMessage);

        scan.close();
    }

    private static void generateKeys(BigInteger p, BigInteger q)
    {
        modulus = p.multiply(q); // n = p * q
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); // ϕ(n) = (p-1)(q-1)

        publicKey = new BigInteger("65537"); // Commonly used public exponent
        privateKey = publicKey.modInverse(phi); // d = e^(-1) mod ϕ(n)
    }

    private static BigInteger encrypt(String message)
    {
        byte[] bytes = message.getBytes();
        BigInteger plainText = new BigInteger(1, bytes);
        return plainText.modPow(publicKey, modulus);
    }

    private static String decrypt(BigInteger encryptedMessage)
    {
        BigInteger decryptedBigInt = encryptedMessage.modPow(privateKey, modulus);
        byte[] decryptedBytes = decryptedBigInt.toByteArray();
        return new String(decryptedBytes);
    }
}
