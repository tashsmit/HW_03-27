package nyc.c4q.tashsmit;

/**
 * Created by c4q-tashasmith on 3/21/15.
 */

import java.util.Scanner;


public class UniqueCharacters {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String text;

        System.out.println("Enter a string: ");
        text = input.nextLine();
        System.out.println(uniqueCharacters(text));

    }

    public static String uniqueCharacters(String someStr) {

        String newStr = "";

        someStr.trim();
        someStr = someStr.toLowerCase();
        //string should only be one word, look for space?
        //should not contain numbers

        for (int i = 0; i < someStr.length(); i++) {

            if (someStr.charAt(i) == ' ')
                continue;
            if (someStr.substring(i + 1).contains(someStr.substring(i, i + 1))) {
                newStr += someStr.charAt(i);
                someStr = someStr.replace(someStr.charAt(i), ' ');
            } else
                newStr += someStr.charAt(i);
        }

        return newStr;
    }
}


