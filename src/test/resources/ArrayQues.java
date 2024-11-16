package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayQues {


    @Test
    public void sortArray() {

        int[] arr = {1, 2, 5, 4};
        System.out.println("Arrays before: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("Ascending sort: " + Arrays.toString(arr));


        int[] newArr = {1, 2, 5, 4};
        System.out.println("Arrays before: " + Arrays.toString(newArr));
        for (int i = 0; i < newArr.length; i++) {
            for (int j = i + 1; j < newArr.length; j++) {
                if (newArr[i] < newArr[j]) {
                    int tmp = newArr[i];
                    newArr[i] = newArr[j];
                    newArr[j] = tmp;
                }
            }
        }
        System.out.println("Descending sort: " + Arrays.toString(newArr));

    }


    @Test
    public void permutations() {
        String s = "ABC";
        List<String> resultList = new ArrayList();
        permutation("", s, resultList);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }

    public static void permutation(String processed, String unprocessed, List<String> resultList) {
        //Exit Criteria For
        if (unprocessed.isEmpty()) {
            System.out.println("processed:- " + processed);
            resultList.add(processed);
            return;
        }
        char c = unprocessed.charAt(0);
        //System.out.println("Char:- "+ c);

        for (int i = 0; i <= processed.length(); i++) {
            //System.out.println("Running for i:- "+ i);
            String initialSubString = processed.substring(0, i);
            String lastSubstring = processed.substring(i);
            System.out.println("initialSubString:- " + initialSubString + " lastSubstring:- " + lastSubstring + " Char:- " + c);
            permutation(initialSubString + c + lastSubstring, unprocessed.substring(1), resultList);
        }

    }

//    public static List<String> permutation(String processed, String unprocessed) {
//        List<String> list = new ArrayList<>();
//        //Exit Criteria For
//        if (unprocessed.isEmpty()) {
//            System.out.println(processed);
//            list.add(processed);
//            return list;
//        }
//        char c = unprocessed.charAt(0);
//        System.out.println("Char:- "+ c);
//
//        for (int i = 0; i <= processed.length(); i++) {
//            String initialSubString = processed.substring(0, i);
//            String lastSubstring = processed.substring(i);
//            permutation(initialSubString + c + lastSubstring, unprocessed.substring(1));
//        }
//        return list;
//    }

    @Test
    public void mergeSortedArrays() {
        int[] arr1 = {1, 2, 5, 7};
        int[] arr2 = {3, 4, 6,8};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] res = new int[arr1.length + arr2.length];

        int index = 0;
        int arr1index = 0;
        int arr2index = 0;

        while (arr1index < arr1.length && arr2index < arr2.length) {
            System.out.println(Arrays.toString(res));
            if (arr1[arr1index] <= arr2[arr2index]) {
                res[index++] = arr1[arr1index++];
            } else {
                res[index++] = arr2[arr2index++];
            }
        }
        System.out.println(Arrays.toString(res));
        System.out.println("First While loop is over");

        while (arr1index != arr1.length) {
            res[index++] = arr1[arr1index++];
        }
        System.out.println(Arrays.toString(res));
        System.out.println("Second While loop is over");


        while (arr2index != arr2.length) {
            res[index++] = arr2[arr2index++];
        }
        System.out.println(Arrays.toString(res));
        System.out.println("Third While loop is over");

    }
}
