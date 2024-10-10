package codingPart.programs;

import org.testng.annotations.Test;

public class LongestSubstring {

    @Test
    public void longestSubstring() {
        String str = "abcdcbasbf";
        String sub = "";
        String longestSub = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length(); j > i + 1; j--) {
                sub = str.substring(i, j);
                //System.out.println("For i=" + i + " and for j=" + j + " the value of sub=" + sub);
                //System.out.println("For sub=" + sub + " palindrome=" + isPalindrome(sub));

                //Checking Plaindrome
                if (isPalindrome(sub) && sub.length() > longestSub.length()) {
                    longestSub = sub;
                    break;
                }
            }
        }
        System.out.println("Longest  palindrome subtring=" + longestSub);


    }

//    public boolean isPalindrome(String str) {
//        String rev = "";
//        for (int i = str.length() - 1; i >= 0; i--) {
//            rev = rev + str.charAt(i);
//        }
//        //System.out.println("Original=" + str + " and Rev=" + rev);
//
//        if (str.equalsIgnoreCase(rev)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
