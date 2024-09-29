package test.interviewQuestions.programs;

import org.testng.annotations.Test;

public class Q1_Palindrome {

    @Test
    public void palindrome() {
        String str = "ROHIT";
        //String str = "NITIN";
        String revStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            revStr = revStr + str.charAt(i);
        }

        System.out.println("revStr " + revStr);

        if (str.equalsIgnoreCase(revStr)) {
            System.out.println("This is palindrome");
        } else {
            System.out.println("This isn't a palindrome");
        }

    }


    @Test
    public void palindrome1() {
        String a = "A man, a plan, a canal: Panama";
        System.out.println("a:- " + a);
        a = a.toLowerCase();
        System.out.println("LowerCase: a:- " + a);
        a = a.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Remove space and special char: a:- " + a);

        String rev = "";

        for (int i = a.length() - 1; i >= 0; i--) {
            rev = rev + a.charAt(i);
        }

        System.out.println(" a:- " + a);
        System.out.println(" rev:- " + rev);

        if (rev.equalsIgnoreCase(a)) {
            System.out.println("This is Palindrome");
        } else
            System.out.println("This is not Palindrome");
    }

}
