package nyc.c4q.tashsmit;

import java.util.Scanner;
import java.util.ArrayList;

public class CaesarCipher {
    public static String decode(String enc, int offset) {
        return encode(enc, 26 - offset);
    }

    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static void main(String[] args) {

        String firstStr;
        String secondStr;
        String firstEncodedStr;
        String secondEncodedStr;
        int offset1;
        int offset2;
        Boolean match;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string to encode");
        firstStr = sc.nextLine();
        System.out.println("Enter offset for first string: ");
        offset1 = sc.nextInt();
        sc.nextLine();
        System.out.println();

        firstEncodedStr = CaesarCipher.encode(firstStr, offset1);

        System.out.println("Enter second string to encode: ");
        secondStr = sc.nextLine();
        System.out.println("Enter offset for second string: ");
        offset2 = sc.nextInt();
        sc.nextLine();
        System.out.println();

        secondEncodedStr = CaesarCipher.encode(secondStr, offset2);

        System.out.println("Your two encoded strings:");
        System.out.println(firstEncodedStr);
        System.out.println(secondEncodedStr);
        System.out.println();

        System.out.print("Your two encoded strings are");
        match = codeBreakerSol2(firstEncodedStr, secondEncodedStr);

        if (match)
            System.out.print(" the same!");
        else
            System.out.print(" different!");

        //print out the decoded strings
        System.out.println();
        //System.out.println(match);
        System.out.println(decode(firstEncodedStr, offset1));
        System.out.println(decode(secondEncodedStr, offset2));
    }


    //Solution 1- see if absolute value of the difference of abscii values of each
    //each character are the same
    //This solution is a WORK IN PROGRESS! It only works for certain words and offset values

    public static Boolean codeBreakerSol1(String cipher1, String cipher2) {

        int absVal = 0;
        int newAbsVal = 0;
        Boolean match = false;

        //check first if lengths are the same
        if (cipher1.length() != cipher2.length())
            return false;
        else {
            //find out first absolute value of pair, save to absVal variable
            int value1 = (int) cipher1.charAt(0);
            int value2 = (int) cipher2.charAt(0);
            absVal = Math.abs(value1 - value2);

            for (int i = 1; i < cipher1.length(); i++) {

                //find out absolute value of each pair after the first
                value1 = (int) cipher1.charAt(i);
                value2 = (int) cipher2.charAt(i);
                //save to newAbsVal variable
                newAbsVal = Math.abs(value1 - value2);

                if (absVal != newAbsVal) {
                    match = false;
                    break;
                } else {
                    absVal = newAbsVal;
                    match = true;
                    continue;
                }
            }
            return match;
        }

    }

    //Solution 2- take each cipher, decode it 1 - 26 and store each value into two different arrays
    //then compare each array to see if there is a matching word

    public static Boolean codeBreakerSol2(String cipher1, String cipher2) {

        Boolean match = false;

        ArrayList<String> array1 = new ArrayList();
        ArrayList<String> array2 = new ArrayList();

        //Create array1, fill in cipher1 decode values 26 times
        for (int i=0; i < 26; i++) {
            String str = decode(cipher1, i);
            array1.add(str);
        }

        //Create array2, fill in cipher2 decode values 26 times
        for (int i=0; i < 26; i++) {
            String str = decode(cipher2, i);
            array2.add(str);
        }

        //Now check if there are any matches between the two arrays
        for (int i=0; i < array1.size(); i++) {

            if (match == true)
                break;

            for (int m=0; m < array2.size(); m++) {

                if (array1.get(i).equals(array2.get(m))) {
                    match = true;
                    break;
                }
                else
                    continue;

            }
        }
        return match;

    }
}
