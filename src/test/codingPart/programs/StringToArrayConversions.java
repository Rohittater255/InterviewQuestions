package codingPart.programs;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StringToArrayConversions {


    @Test(description = "String, Arraylist & Array conversion")
    public void stringConversion() {
        String str = "STRING";
        String[] starr = {"A", "R", "R", "A", "Y"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "R", "R", "A", "Y", "L", "I", "S", "T"));

        //Array to String
        System.out.println("Array to String: " + String.join("", starr));
        //ArrayList to String
        System.out.println("ArrayList to String: " + String.join("", list));


        //String To Arraylist
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(str.split("")));
        System.out.println("String To Arraylist: " + list2);
        //Array To Arraylist
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(starr));
        System.out.println("Array To Arraylist: " + list3);


        //String to Array
        System.out.println("String to Array " + Arrays.toString(str.toCharArray()));

        //Arraylist to Array
        String[] array = list.toArray(new String[0]);
        System.out.println("Arraylist to Array " + Arrays.toString(array));
    }
}
