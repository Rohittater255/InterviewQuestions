package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListQues {

    @Test()
    public void findAdditionalElement() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "D"));

        //Print Additional Element in List( Element is present in A but not in B)
        list1.removeAll(list2);
        System.out.println("list1 " + list1);
    }


    @Test()
    public void findMissingElement() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "D"));

        //Print Missing Element in List( Element is present in B but not in A)
        list2.removeAll(list1);
        System.out.println("list2 " + list2);
    }

    @Test()
    public void findCommonElements() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "D"));

        list1.retainAll(list2);
        System.out.println("Common Elements " + list1);
    }

}
