package test.codingPart.programs;

import org.testng.annotations.Test;

import java.util.HashSet;

public class LongestSubstring {

    @Test
    public void rt(){
        String s ="abcabcbb";
        int n = s.length();
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;

        while (i < n && j < n) {
            System.out.println("Running for i="+i+" and j="+j);
            // Try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                System.out.println("Adding in Set:- "+s.charAt(j++));
                set.add(s.charAt(j++));

                System.out.println("Checking what is max "+result +" or "+(j-i));
                result = Math.max(result, j - i);
            } else {
                System.out.println("Removing- " +s.charAt(i++));
                set.remove(s.charAt(i++));
            }
        }
        System.out.println("FInal Result "+result);
    }

    public int a(){
        int a=5;
        int b=6;
        return  a>b?a:b;
    }

}
