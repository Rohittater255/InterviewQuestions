package codingPart.programs.recurssion;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9};
        int target = 2;
        int index = linearSearch(arr, 0, target);
        System.out.println("The index "+index);
    }

    public static int linearSearch(int[] arr, int index, int target) {
        if (index == arr.length-1) {
            return -1;
        }
        if (arr[index] == target) {
                return index;
            } else {
                return linearSearch(arr, index + 1, target);
            }
        }


}
