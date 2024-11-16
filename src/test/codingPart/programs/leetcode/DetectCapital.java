package test.codingPart.programs.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class DetectCapital {


    //Check if String have proper capital Letter
    //Case1 : USA - valid //If All Char is capital, then it is valid
    //Case2 : India - valid //If only Char is capital, then it is valid
    //Case3 : nepal - valid //If only Char is not-capital, then it is valid
    //Case4 : RUssia - Invalid
    @Test
    public void a() {
        ArrayList<String> list = new ArrayList<>();
        list.add("USA");
        list.add("India");
        list.add("nepal");
        list.add("RUssia");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("For String=" + list.get(i) + " Valid Capital=" + isValidCapital(list.get(i)));
        }
    }

    public boolean isValidCapital(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        if (Character.isUpperCase(str.charAt(0)) && count == str.length()) {
            return true;
        } else if (Character.isUpperCase(str.charAt(0)) && count == 1) {
            return true;
        } else return !Character.isUpperCase(str.charAt(0)) && count == 0;
    }
}
