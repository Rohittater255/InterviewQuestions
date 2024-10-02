package test.codingPart.programs;

import org.testng.annotations.Test;

import java.util.HashSet;

public class LongestSubstring {

    @Test
    public void rt() {
        String s = "abcabcbb";
        int n = s.length();
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;

        while (i < n && j < n) {
            System.out.println("Running for i=" + i + " and j=" + j);
            // Try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                System.out.println("Adding in Set:- " + s.charAt(j++));
                set.add(s.charAt(j++));

                System.out.println("Checking what is max " + result + " or " + (j - i));
                result = Math.max(result, j - i);
            } else {
                System.out.println("Removing- " + s.charAt(i++));
                set.remove(s.charAt(i++));
            }
        }
        System.out.println("FInal Result " + result);
    }

    public int returnWithConditions() {
        int a = 5;
        int b = 6;
        return a > b ? a : b;
    }

    @Test
    public void fibbonaci() {
        int n = 7;
        int a = 0;
        int b = 1;
        int result = 0;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            for (int i = 2; i <= n; i++) {
                result = a + b;
                a = b;
                b = result;
                System.out.println("For n=" +i + " the result=" + result);
            }
        }
        System.out.println("For n=" + n + " the result=" + result);
    }

}
