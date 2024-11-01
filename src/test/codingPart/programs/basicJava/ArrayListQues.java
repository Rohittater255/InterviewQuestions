package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

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
    public void findCommonElements_3ArrayList() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "D"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("E", "B", "D"));

        list1.retainAll(list2);
        list1.retainAll(list3);
        System.out.println("Common Elements " + list1);
    }

    @Test
    public void findDuplicateInArraylist() {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            hashmap.put(list.get(i), hashmap.getOrDefault(list.get(i), 0) + 1);
        }

        System.out.println("Below are Duplicate Elements");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    @Test
    public void findUniqueInArrayList() {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");

        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            hashmap.put(list.get(i), hashmap.getOrDefault(list.get(i), 0) + 1);
        }

        System.out.println("Below are Unique Elements");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    @Test
    public void removeDuplicateInArray() {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");

        LinkedHashSet<String> hashSet = new LinkedHashSet<>(list);
        System.out.println(hashSet.size());
        list = new ArrayList<>(hashSet);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("list--> " + list.get(i));
        }


        HashSet<String> hashSet1 = new HashSet<>(list);
        System.out.println(hashSet1.size());
        list = new ArrayList<>(hashSet1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("list--> " + list.get(i));
        }
    }

    @Test
    public void findUniqueDuplicate() {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");


        System.out.println("Print All Elements:- "+list.stream().sorted().toList());
        System.out.println("Print Unique Elements:- "+list.stream().distinct().sorted().toList());

        Set<String> allItems = new HashSet<>();
        List<String> duplicateElements = list.stream()
                .filter(e -> !allItems.add(e))
                .distinct()
                .toList();
        System.out.println("Print Duplicate Elements: " + duplicateElements);



    }

}
