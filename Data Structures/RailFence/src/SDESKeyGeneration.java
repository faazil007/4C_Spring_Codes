import java.util.Arrays;1
public class SDESKeyGeneration {
    public static void main(String[] args)
    {
        int[] originalKey = {1, 0, 1, 0, 0, 0,0, 0, 1, 0};
        int[][] generatedKeys = generateKeys(originalKey);

        System.out.println("Original Key: " + Arrays.toString(originalKey));
        System.out.println("Generated Keys:");
        for (int i = 0; i < generatedKeys.length; i++) {
            System.out.println("K" + (i + 1) + ": " + Arrays.toString(generatedKeys[i]));
        }
    }

    public static int[][] generateKeys(int[] ten_bit_key) {
        int[] p10Key = permute10(ten_bit_key);
        int[] leftShiftedKey1 = leftShift(p10Key, 1);
        int[] leftShiftedKey2 = leftShift(leftShiftedKey1, 2);

        int[] key1 = permute8(leftShiftedKey1);
        int[] key2 = permute8(leftShiftedKey2);

        return new int[][] {key1, key2};
    }

    public static int[] permute10(int[] key) {
        int[] p10 = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};
        return permute(key, p10, 10);
    }

    public static int[] leftShift(int[] key, int numberOfShifts) {
        int length = key.length;
        int[] shiftedKey = new int[length];

        for (int i = 0; i < length; i++) {
            shiftedKey[i] = key[(i + numberOfShifts) % length];
        }

        return shiftedKey;
    }

    public static int[] permute8(int[] key) {
        int[] p8 = {5, 2, 6, 3, 7, 4, 9, 8};
        return permute(key, p8, 8);
    }

    public static int[] permute(int[] key, int[] permutationTable, int newSize) {
        int[] result = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            result[i] = key[permutationTable[i]];
        }
        return result;
    }
}
