package test.codingPart.programs.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Q4_CheckArrayList_SortedORNot {

    @Test
    public void checkSortedArray() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Rohit");
        arr.add("Rahul");

        ArrayList<String> copy = new ArrayList<>(arr);

        Collections.sort(copy);
        System.out.println("arr" + arr);
        System.out.println("copt" + copy);

        boolean flag = copy.equals(arr);
        System.out.println("Flag-->" + flag);

    }

}
