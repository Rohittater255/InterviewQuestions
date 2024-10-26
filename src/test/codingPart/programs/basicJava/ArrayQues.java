package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.Arrays;

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
}
