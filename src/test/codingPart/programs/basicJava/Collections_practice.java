package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.*;

public class Collections_practice {


    @Test
    public void arraylist() {
        //Stores Duplicate Values
        //Maintains insertion order
        List<String> list = new ArrayList<>();

        list.add("Rohit Sharma");
        list.add("Shubhman Gill");
        list.add("Virat Kholi");
        list.add("KL Rahul");
        list.add("Rishabh Pant");
        list.add("Hardik Pandya");
        list.add("Hardik Pandya");

        for (String s : list) {
            System.out.println("Cricketer: " + s);
        }
    }


    @Test
    public void vector() {
        //Stores Duplicate Values
        //Maintains insertion order
        List<String> list = new Vector<>();

        list.add("Rohit Sharma");
        list.add("Shubhman Gill");
        list.add("Virat Kholi");
        list.add("KL Rahul");
        list.add("Rishabh Pant");
        list.add("Hardik Pandya");
        list.add("Hardik Pandya");


        for (String s : list) {
            System.out.println("Cricketer: " + s);
        }
    }


    @Test
    public void hashset() {
        //Stores Unique Values
        //Doesnt mantain insertion order
        HashSet<String> set = new HashSet<>();

        set.add("Rohit Sharma");
        set.add("Shubhman Gill");
        set.add("Virat Kholi");
        set.add("KL Rahul");
        set.add("Rishabh Pant");
        set.add("Hardik Pandya");
        set.add("Hardik Pandya");


        for (String s : set) {
            System.out.println("Cricketer: " + s);
        }
    }

    @Test
    public void linkedHashset() {
        //Stores Unique Values
        //Maintains insertion order
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("Rohit Sharma");
        set.add("Shubhman Gill");
        set.add("Virat Kholi");
        set.add("KL Rahul");
        set.add("Rishabh Pant");
        set.add("Hardik Pandya");
        set.add("Hardik Pandya");


        for (String s : set) {
            System.out.println("Cricketer: " + s);
        }
    }


    @Test
    public void treeSet() {
        //Stores Unique Values
        //Maintain Natural/specified order
//        SortedSet<String> set = new TreeSet<>();
        TreeSet<String> set = new TreeSet<>();

        set.add("Rohit Sharma");
        set.add("Shubhman Gill");
        set.add("Virat Kholi");
        set.add("KL Rahul");
        set.add("Rishabh Pant");
        set.add("Hardik Pandya");
        set.add("Hardik Pandya");


        for (String s : set) {
            System.out.println("Cricketer: " + s);
        }

    }


    @Test
    public void map() {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1, "Rohit Sharma");
        map.put(2, "Shubhman Gill");
        map.put(3, "Virat Kholi");
        map.put(4, "KL Rahul");
        map.put(5, "Rishabh Pant");
        map.put(6, "Hardik Pandya");
        map.put(6, "Krunal Pandya");


        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println("At Position="+ entry.getKey() + ", Cricketer: " + entry.getValue());
        }

    }

}
