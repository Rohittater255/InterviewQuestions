package codingPart.programs.recurssion;

public class SortedArray {

    public static int count;

    public static void main(String[] args) {
//        int[] arr = {2, 4, 6, 0, 7};
        int[] arr = {2, 4, 6, 7, 7};

        boolean flag = checkSorted(arr, 0);
        System.out.println("Sorted:- " + flag);
    }

    public static boolean checkSorted(int[] arr, int n) {
        System.out.println("Running for count=" + count++ + " With n=" + n);
        if (n == arr.length - 1) {
            return true;
        }


        return arr[n] <= arr[n + 1] && checkSorted(arr, n + 1);
    }
}
