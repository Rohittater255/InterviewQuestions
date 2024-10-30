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
            permutation("",s,resultList);
            for (int i = 0; i <resultList.size(); i++) {
                System.out.println(resultList.get(i));
            }
        }

        public static void permutation(String processed, String unprocessed,  List<String> resultList ) {
            //Exit Criteria For
            if (unprocessed.isEmpty()) {
                System.out.println("processed:- "+ processed);
                resultList.add(processed);
                return;
            }
            char c = unprocessed.charAt(0);
            //System.out.println("Char:- "+ c);

            for (int i = 0; i <= processed.length(); i++) {
                //System.out.println("Running for i:- "+ i);
                String initialSubString = processed.substring(0, i);
                String lastSubstring = processed.substring(i);
                System.out.println("initialSubString:- "+ initialSubString+ " lastSubstring:- "+ lastSubstring + " Char:- "+ c);
                permutation(initialSubString + c + lastSubstring, unprocessed.substring(1),resultList);
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
}
