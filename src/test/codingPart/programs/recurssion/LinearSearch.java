package test.codingPart.programs.recurssion;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9};
        int target = 2;//8
        int index = linearSearch(arr, 0, target);
        System.out.println("The arr " + Arrays.toString(arr));
        System.out.println("The index " + index);
    }

    public static int linearSearch(int[] arr, int index, int target) {
        if (index == arr.length - 1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return linearSearch(arr, index + 1, target);
        }
    }


}
