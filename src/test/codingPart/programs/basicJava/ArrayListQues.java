package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.*;

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

    @Test()
    public void findCommonElements_3Arrays() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "D"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("E", "B", "D"));

        list1.retainAll(list2);
        list1.retainAll(list3);
        System.out.println("Common Elements " + list1);
    }

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
        arrList = new ArrayList<>(hashSet);

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("arrList--> " + arrList.get(i));
        }


        HashSet<String> hashSet1 = new HashSet<>(arrList);
        System.out.println(hashSet1.size());
        arrList = new ArrayList<>(hashSet1);

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("arrList--> " + arrList.get(i));
        }
    }

}
