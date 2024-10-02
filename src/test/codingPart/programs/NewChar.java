package test.codingPart.programs;

import org.testng.annotations.Test;

public class NewChar {

    @Test
    public void a() {
        String a = "abz";//abc
        String b = "";

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'z'){
                b=b + "a";
            }else {
                b = b + (char) (a.charAt(i) + 1);
            }
            System.out.println("b:- " + b);
        }
    }
}
