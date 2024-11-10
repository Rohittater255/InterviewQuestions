package codingPart.programs.leetcode;

import org.testng.annotations.Test;

public class FindSubsequentChar {

    @Test
    public void subsequentChar() {
        String str = "abt";//abc
        String b = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'z') {
                b = b + "str";
            } else {
                b = b + (char) (str.charAt(i) + 1);
            }
            System.out.println("Subsequent Char for char=" + str.charAt(i) + b);
        }
    }
}
