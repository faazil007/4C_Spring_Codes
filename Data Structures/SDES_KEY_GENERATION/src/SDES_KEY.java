import java.util.*;

public class SDES_KEY
{
    public int[] input()
    {
        int size = 10;
        int[] original_key = new int[size];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter values for the key (0 or 1 only):");
        for (int i = 0; i < original_key.length; i++)
        {
            while (true)
            {
                System.out.print("Enter value for index " + i + ": ");
                int value = scan.nextInt();
                if (value == 0 || value == 1)
                {
                    original_key[i] = value;
                    break;
                }
                else
                {
                    System.out.println("Invalid value! Only 0 or 1 is allowed.");
                    System.out.println("Please enter again.");
                }
            }
        }

        return original_key;
    }


    public  int[][] key_generator(int[] ten_bit_key)
    {
        int[] ten_permuted_key = permute10(ten_bit_key);
        int[][] left_shifted_keys_1 = leftShift(ten_permuted_key, 1);
        int[][] left_shifted_keys_2 = leftShift(ten_permuted_key, 2);

        int[] left_side_key_1 = left_shifted_keys_1[0];
        int[] right_side_key_1 = left_shifted_keys_1[1];

        int[] left_side_key_2 = left_shifted_keys_2[0];
        int[] right_side_key_2 = left_shifted_keys_2[1];

        int[] combined_key_1 = combineKeys(left_side_key_1, right_side_key_1);
        int[] combined_key_2 = combineKeys(left_side_key_2, right_side_key_2);

        int[] key1 = permute8(combined_key_1);
        int[] key2 = permute8(combined_key_2);

        return new int[][]{key1, key2};
    }

    public static int[] combineKeys(int[] leftKey, int[] rightKey)
    {
        int combined_length = leftKey.length + rightKey.length;
        int half_length = combined_length / 2;
        int[] combinedKey = new int[combined_length];


        for (int i = 0; i < half_length; i++)
        {
            combinedKey[i] = leftKey[i];
        }

        for (int i =0 ; i < half_length; i++)
        {
            combinedKey[i + 5] = rightKey[i];
        }

        return combinedKey;
    }


    public static int[] permute(int[] key, int[] permutationTable, int newSize)
    {
        int[] result = new int[newSize];
        for (int i = 0; i < newSize; i++)
        {
            result[i] = key[permutationTable[i]];
        }
        return result;
    }

    public static int[] permute8(int[] key)
    {
        int[] p8 = {5, 2, 6, 3, 7, 4, 9, 8};
        return permute(key, p8, 8);
    }

    public static int[] permute10(int[] key)
    {
        int[] p10 = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};
        return permute(key, p10, 10);
    }

    public static int[][] leftShift(int[] key, int no_of_shifts)
    {
        int length = key.length;
        int[] left = new int[length / 2];
        int[] right = new int[length / 2];
        for(int i =0 ; i < left.length ; i++)
        {
            left[i] = key[i];
        }
        for(int i =0  ; i <right.length; i++)
        {
            right[i] = key[i + 5];
        }


        left = shiftArray(left, no_of_shifts);
        right = shiftArray(right, no_of_shifts);

        return new int[][]{left, right};
    }

    public static int[] shiftArray(int[] array, int no_of_shifts)
    {
        int length = array.length;
        int[] shifted = new int[length];
        for (int i = 0; i < length; i++)
        {
            shifted[i] = array[(i + no_of_shifts) % length];
        }
        return shifted;
    }

    public int menu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 :: For Key Generation");
        System.out.println("2 :: To Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }
}
