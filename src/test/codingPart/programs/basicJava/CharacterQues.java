package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CharacterQues {

    @Test
    public void countNumber() {
        String s = "a#% !AB23";
        char[] arr = s.toCharArray();
        System.out.println("String:- " + s);
        System.out.println("Array :- " + Arrays.toString(arr));

        int specialChar = 0;
        int digits = 0;
        int uppercase = 0;
        int lowercase = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!Character.isLetterOrDigit(arr[i])) {
                //System.out.println("Space at index="+i+ " is "+ arr[i]);
                specialChar++;
            } else if (Character.isDigit(arr[i])) {
                //System.out.println("Digit at index="+i+ " is "+ arr[i]);
                digits++;
            } else if (Character.isUpperCase(arr[i])) {
                //System.out.println("Uppercase at index="+i+ " is "+ arr[i]);
                uppercase++;
            } else if (Character.isLowerCase(arr[i])) {
                //System.out.println("Lowercase at index="+i+ " is "+ arr[i]);
                lowercase++;
            }
        }
        System.out.println("The  specialChar=" + specialChar);
        System.out.println("The  digits=" + digits);
        System.out.println("The  lowercase=" + lowercase);
        System.out.println("The  uppercase=" + uppercase);
    }
}
