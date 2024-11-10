package codingPart.programs.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class Sorting {


    @Test(description = "Sort integer elements in array")
    public void sortArray() {
        int[] arr = {3, 1, 4};

        System.out.println("Before Sorting:- " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //For i=0, j=1
                    int tmp = arr[j]; //{3, 1, 4}
                    arr[j] = arr[i]; //{3, 3, 4}
                    arr[i] = tmp;//{1, 3, 4}
                }

            }
        }

        System.out.println("After Sorting:- " + Arrays.toString(arr));
    }

    @Test(description = "Sort integer elements in array")
    public void sortArrayList() {

        List<Integer> list = new ArrayList<>(List.of(5, 2, 2));

        System.out.println("### Before Sorting ###");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Integer" + list.get(i));
        }

        Collections.sort(list);

        System.out.println("### After Sorting ###");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Integer " + list.get(i));
        }

    }


    @Test(description = "Suppose map exists with un-sorted key-value pairs. Sort elements in map")
    public void sortMap() {
        Map<String, Integer> players = new HashMap<>();
        players.put("Rohit", 1);
        players.put("Shubman", 2);
        players.put("Kohli", 3);
        players.put("Pant", 4);


        System.out.println("######## BEFORE SORTING ######## ");
        for (Map.Entry<String, Integer> map : players.entrySet()) {
            System.out.println("Key:- " + map.getKey() + " Value:- " + map.getValue());
        }


        SortedMap<String, Integer> sortedPlayers = new TreeMap();
        sortedPlayers.putAll(players);

        System.out.println("######## AFTER SORTING ######## ");
        for (Map.Entry<String, Integer> map : sortedPlayers.entrySet()) {
            System.out.println("Key:- " + map.getKey() + " Value:- " + map.getValue());
        }


        SortedMap<String, Integer> sortedPlayers_Desc = new TreeMap(Collections.reverseOrder());
        sortedPlayers_Desc.putAll(players);

        System.out.println("######## AFTER SORTING ######## ");
        for (Map.Entry<String, Integer> map : sortedPlayers_Desc.entrySet()) {
            System.out.println("Key:- " + map.getKey() + " Value:- " + map.getValue());
        }
    }
}
