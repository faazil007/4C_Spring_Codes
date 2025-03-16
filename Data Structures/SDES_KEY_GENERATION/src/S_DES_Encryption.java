import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class S_DES_Encryption
{
    public static void main(String [] args)
    {
        S_DES_Encryption encr = new S_DES_Encryption();
        SDES_KEY sd = new SDES_KEY();
        int input_pt[] ; // 8  Bit Plain text for Encryption
        int input_key[]; // 10 Bit Key used in encryption
        int choice;
        while(true)
        {
            choice = encr.menu();
            switch(choice)
            {
                case 1:
                {
                    Scanner scan = new Scanner(System.in);

                    int size = 10;
                    int size_pt =8;
                    input_pt = new int[size_pt];
                    input_key = new int[size];


                    System.out.println("Enter values for the PT (0 or 1 only):");
                    for (int i = 0; i < input_pt.length; i++)
                    {
                        while (true)
                        {
                            System.out.print("Enter value for index " + i + ": ");
                            int value = scan.nextInt();
                            if (value == 0 || value == 1)
                            {
                                input_pt[i] = value;
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid value! Only 0 or 1 is allowed.");
                                System.out.println("Please enter again.");
                            }
                        }
                    }
                    System.out.println(" Now Enter Values for the Key (0 or 1 Only):");
                    for (int i = 0; i < input_key.length; i++)
                    {
                        while (true)
                        {
                            System.out.print("Enter value for index " + i + ": ");
                            int value = scan.nextInt();
                            if (value == 0 || value == 1)
                            {
                                input_key[i] = value;
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid value! Only 0 or 1 is allowed.");
                                System.out.println("Please enter again.");
                            }
                        }
                    }
                    int [][]generated_keys = sd.key_generator(input_key);
                    int[] key1 = generated_keys[0];
                    int[] key2 = generated_keys[1];

                    int generated_Cipher [] = Encryption(input_pt , key1 , key2 );
                    int generated_PlainText[] = Decryption(generated_Cipher , key1, key2);
                    System.out.println("Original PT Bits : " + Arrays.toString(input_pt));
                    System.out.println("Generated Cipher Bits : " + Arrays.toString(generated_Cipher));
                    System.out.println("Generated Plain Text Bits : " + Arrays.toString(generated_PlainText));
                }
                case 2:
                {
                    break;
                }
            }
        }
    }
    // Encryption...
    public static int[] Encryption(int[] input, int[] key1 , int[]key2)
    {
        // Round 1 Using Key1

        int[] p8Key = permute8(input);
        int[] p4_lo = new int[4];
        int[] p4_Ro = new int[4];

        for (int i = 0; i < 4; i++)
        {
            p4_lo[i] = p8Key[i];
        }
        for (int i = 0; i < 4; i++)
        {
            p4_Ro[i] = p8Key[i + 4];
        }
          int[] EP = E_p8(p4_Ro);

        int XOR_EP[] = S_DES_XOR(EP, key1);

        int C_P[] = pre_C_P(XOR_EP);

        int left[] = left_XOR_right(p4_lo, C_P);

        int final_result[] = new int[8];

        for (int i = 0; i < 4; i++)
        {
            final_result[i] = p4_Ro[i];
        }
        for (int i = 0; i < 4; i++)
        {
            final_result[i + 4] = left[i];
        }

        // Round 2 Using Key 2

        int[] p8Key_2 = permute8(final_result);
        int[] p4_lo_2 = new int[4];
        int[] p4_Ro_2 = new int[4];

        for (int i = 0; i < 4; i++)
        {
            p4_lo_2[i] = p8Key_2[i];
        }
        for (int i = 0; i < 4; i++)
        {
            p4_Ro_2[i] = p8Key_2[i + 4];
        }
        int[] EP_2 = E_p8(p4_Ro);

        int XOR_EP_2[] = S_DES_XOR(EP, key2);

        int C_P_2[] = pre_C_P(XOR_EP);

        int left_2[] = left_XOR_right(p4_lo, C_P);

        int final_result_2[] = new int[8];

        for (int i = 0; i < 4; i++)
        {
            final_result_2[i] = p4_Ro_2[i];
        }
        for (int i = 0; i < 4; i++)
        {
            final_result_2[i + 4] = left_2[i];
        }
        return final_result_2;

    }

    // Decrption...
    public static int[] Decryption(int[] input, int[] key1 , int[]key2)
    {
        // Round 1 Using Key2

        int[] p8Key = permute8(input);
        int[] p4_lo = new int[4];
        int[] p4_Ro = new int[4];

        for (int i = 0; i < 4; i++)
        {
            p4_lo[i] = p8Key[i];
        }
        for (int i = 0; i < 4; i++)
        {
            p4_Ro[i] = p8Key[i + 4];
        }
        int[] EP = E_p8(p4_Ro);

        int XOR_EP[] = S_DES_XOR(EP, key2);

        int C_P[] = pre_C_P(XOR_EP);

        int left[] = left_XOR_right(p4_lo, C_P);

        int final_result[] = new int[8];

        for (int i = 0; i < 4; i++)
        {
            final_result[i] = p4_Ro[i];
        }
        for (int i = 0; i < 4; i++)
        {
            final_result[i + 4] = left[i];
        }

        // Round 2 Using Key 1

        int[] p8Key_2 = permute8(final_result);
        int[] p4_lo_2 = new int[4];
        int[] p4_Ro_2 = new int[4];

        for (int i = 0; i < 4; i++)
        {
            p4_lo_2[i] = p8Key_2[i];
        }
        for (int i = 0; i < 4; i++)
        {
            p4_Ro_2[i] = p8Key_2[i + 4];
        }
        int[] EP_2 = E_p8(p4_Ro);

        int XOR_EP_2[] = S_DES_XOR(EP, key2);

        int C_P_2[] = pre_C_P(XOR_EP);

        int left_2[] = left_XOR_right(p4_lo, C_P);

        int final_result_2[] = new int[8];

        for (int i = 0; i < 4; i++)
        {
            final_result_2[i] = left_2[i];
        }
        for (int i = 0; i < 4; i++)
        {
            final_result_2[i + 4] = p4_Ro_2[i];
        }
        return final_result_2;

    }



    public static int[] left_XOR_right(int [] input , int[] SOP)
    {
        int result[] = new int[4];
        for(int i =0 ; i < input.length;i++)
        {
            if(input[i] == 0 && SOP[i] == 0)
            {
                result[i] =0;
            }
            else if(input[i] == 1 && SOP[i] ==1)
            {
                result[i] =0;
            }
            else
            {
                result[i] = 1;
            }
        }
        return result;
    }
    public static int[] pre_C_P(int[] XOR_EP)
    {
        int []p= {2,3,4,1};
        return CP(XOR_EP, p , 4);
    }
    public static int[] CP(int[] input, int[] permutationTable, int newsize)
    {
        int [] result = new int[newsize];
        for(int i =0 ; i < newsize ; i++)
        {
            result[i] = input[permutationTable[i]];
        }
        return result;

    }
    public static int[] S_DES_XOR(int[]EP , int[] key)
    {
        int EP_lo[] = {EP[0] , EP[1] , EP[2] , EP[3]};
        int EP_Ro[] = {EP[4] , EP[5] , EP[6] , EP[7]};
        int key_lo[] = {key[0] , key[1] , key[2] , key[3]};
        int key_Ro[] = {key[4] , key[5] , key[6] , key[7]};
        int Lo[] = new int[4];
        int Ro[] = new int[4];
        for(int i =0 ; i < Lo.length;i++)
        {
            if(EP_lo[i] == key_lo[i])
            {
                Lo[i] =0;
            }
            else
            {
                Lo[i] =1;
            }
        }
        for(int i =0 ; i < Ro.length; i++)
        {
            if(EP_Ro[i]== key_Ro[i])
            {
                Ro[i] =0 ;
            }
            else
            {
                Ro[i] =1;
            }
        }
        int final_XOR[] = new int[8];
        for(int i =0 ; i < Lo.length; i++)
        {
            final_XOR[i] = Lo[i];
        }
        for(int i =0 ; i < Ro.length ; i++)
        {
            final_XOR[i+4] = Ro[i];
        }
        return final_XOR;

    }
    public static int[] E_p8(int[] input)
    {
        int []p_table = {3,0,1,2,1,2,3,0};
        return E_P(input,p_table,8);
    }
    public static int[] E_P(int[] input , int[] permutationTable , int newsize)
    {
        int []result = new int[newsize];
        for(int i =0 ; i < newsize ; i++)
        {
            result[i] = input[permutationTable[i]];
        }
        return result;
    }
    public static int [] permute8(int[] input)
    {
        int []p = {1,5,2,0,3,7,4,6};
        return permute(input , p ,8);
    }
    public static int[] permute(int [] input , int[] permutationTable , int newsize)
    {
        int []result = new int[newsize];
        for(int i =0 ; i < newsize; i++)
        {
            result[i]= input[permutationTable[i]];
        }
        return result;
    }
    public int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 :: For Encryption");
        System.out.println("2 :: To Exit");
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }



































}

