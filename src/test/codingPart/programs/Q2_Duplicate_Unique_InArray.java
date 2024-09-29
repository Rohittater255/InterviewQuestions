package test.codingPart.programs;

import org.testng.annotations.Test;

import java.util.*;

public class Q2_Duplicate_Unique_InArray {

    @Test
    public void findDuplicateInArray() {

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("a");
        arrList.add("a");
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i = 0; i < arrList.size(); i++) {
            hashmap.put(arrList.get(i), hashmap.getOrDefault(arrList.get(i), 0) + 1);
        }

        System.out.println("Below are Duplicate Elements");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    @Test
    public void findUniqueInArray() {

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("a");

        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i = 0; i < arrList.size(); i++) {
            hashmap.put(arrList.get(i), hashmap.getOrDefault(arrList.get(i), 0) + 1);
        }

        System.out.println("Below are Unique Elements");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    @Test
    public void removeDuplicateInArray() {

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("a");
        String[] arr;

        LinkedHashSet<String> hashSet = new LinkedHashSet<String>(arrList);
        System.out.println(hashSet.size());
        arrList= new ArrayList<>(hashSet);

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("arrList--> "+ arrList.get(i));
        }


        HashSet<String> hashSet1 = new HashSet<>(arrList);
        System.out.println(hashSet1.size());
        arrList= new ArrayList<>(hashSet1);

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("arrList--> "+ arrList.get(i));
        }
    }
}
