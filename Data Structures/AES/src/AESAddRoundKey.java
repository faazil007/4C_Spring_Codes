import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AESAddRoundKey
{

    public static void addRoundKey(byte[][] state, byte[][] roundKey)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                state[i][j] ^= roundKey[i][j]; // XOR operation
            }
        }
    }

    public static void printState(byte[][] state)
    {
        for (byte[] row : state)
        {
            for (byte b : row)
            {
                System.out.printf("%02X ", b);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        byte[][] state =
                {
                {0x32, (byte) 0x88, 0x31, (byte) 0xE0},
                {0x43, 0x5A, 0x31, 0x37},
                {(byte) 0xF6, 0x30, (byte) 0x98, 0x07},
                {(byte) 0xA8, (byte) 0x8D, (byte) 0xA2, 0x34}};

        byte[][] roundKey =
                {
                {0x2B, 0x28, (byte) 0xAB, 0x09},
                {0x7E, (byte) 0xAE, (byte) 0xF7, (byte) 0xCF},
                {0x15, (byte) 0xD2, 0x15, 0x4F},
                {0x16, (byte) 0xA6, (byte) 0x88, 0x3C}
        };

        System.out.println("State Before AddRoundKey:");
        printState(state);

        addRoundKey(state, roundKey);

        System.out.println("State After AddRoundKey:");
        printState(state);
    }
}

