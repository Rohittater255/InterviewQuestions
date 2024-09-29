package test.interviewQuestions;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils5 {

    @Test
    public void a() {
        String a = "I, am groot";

        System.out.println("String" + a);

        System.out.println("First Char:- " + a.charAt(0));
        System.out.println("Last Char:- " + a.charAt(a.length() - 1));

        System.out.println("First 3 Char:- " + a.substring(0, 3));
        System.out.println("First Char after space:- " + a.split(" ")[1]);
        System.out.println("Second Char after space:- " + a.split(" ")[2]);
        System.out.println("Second Char after space:- " + a.replace(" ", ""));
        System.out.println("Second Char after space:- " + a.replaceAll("[^a-zA-Z0-9]", ""));
        System.out.println("Second Char after space:- " + a.intern());
    }

    @Test
    public void conversion() {
        String a = "I, am groot";
        //String to array
        char[] k = a.toCharArray();
        for (int i = 0; i < k.length; i++) {
            System.out.println("Char Array " + k[i]);
        }

        //array to String
        String newA = String.valueOf(k);
        System.out.println("array to String:- " + newA);

        //String to Arraylist
        ArrayList arrayList = new ArrayList<>(Arrays.asList(a.split("")));
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("ArrayList: " + arrayList.get(i));
        }

        //Arraylist to String
        String newAA = String.join("", arrayList);
        System.out.println("Arraylist to String:- " + newAA);

    }

    @Test
    public void conversion2() {
        int[] a = {1, 2, 3};

        for (int i = 0; i < a.length; i++) {
            System.out.println("Int Array " + a[i]);
        }

//        Collections.addAll(a);

        //String to Arraylist
        List<Integer> arrayList = Arrays.stream(a).boxed().collect(Collectors.toList());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("ArrayList: " + arrayList.get(i));
        }


    }
}
