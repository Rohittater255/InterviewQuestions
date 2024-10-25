package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.Arrays;

public class StringsQues {

    @Test
    public void sum_StringAndInteger() {
        int a = 2;
        int b = 8;
        System.out.println(a + b + "Yahoo");
        System.out.println("Yahoo" + a + b);
    }

    @Test
    public void sum_DifferentBase() {

        int a = 10;
        int b = 20;
        System.out.println(a + b);

        int c = 010;//(8*2)*0 + (8*1)*1 + (8*0)*0=8
        int d = 020;//(8*2)*0 + (8*1)*2 + (8*0)*0=16
        System.out.println(c + d);//24

        int e = 0010;//(8*3)*0 + (8*2)*0 + (8*1)*1 + (8*0)*0=8
        int f = 0020;//(8*3)*0 + (8*2)*0 + (8*1)*2 + (8*0)*0=24
        System.out.println(e + f);


    }

    @Test
    public void replaceSpecialCharacters() {
        String s = "I am @Rohit Tater. My B'Day is 25th May";
        System.out.println("Before replace " + s);

        String a = s.replaceAll("[^a-zA-Z]", "");
        System.out.println("Replace Special Characters and number: " + a);

        String b = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Replace Special Characters but not numbers: " + b);

        String c = s.replaceAll("[^a-zA-Z0-9_ ]", "");
        System.out.println("Replace Special Characters but not numbers and space: " + c);

        String d = s.replaceAll("[^a-zA-Z0-9_._ ]", "");
        System.out.println("Replace Special Characters but not numbers, space and fullstop: " + d);
    }


    @Test
    public void differentRegex() {
        String a = "          Hello            World               !!"+ System.currentTimeMillis();
        System.out.println("Original String      :-     " + a);
        System.out.println("Remove Multiple Space:-     " + a.replaceAll("\\s+", " "));
        System.out.println("Remove Multiple Character:- " + a.replaceAll("\\w+", " "));
        System.out.println("Remove Multiple Digits:-    " + a.replaceAll("\\d+", " "));
        System.out.println("Remove Special Character:- " + a.replaceAll("\\w+", " "));
    }


    @Test
    public void removeSpecialCharacters() {
        String a = " @  My Name, is   Rohit   ";

        System.out.println("Before: " + a);
        System.out.println("After Removing All Special Char(Including space): " + a.replaceAll("[^a-zA-Z0-9]", ""));
        System.out.println("After Removing All Special Char(Excluding space): " + a.replaceAll("[^a-zA-Z0-9] ", ""));
        System.out.println("After Removing All Special Char(Excluding space): " + a.replaceAll("\\s+", " "));
        System.out.println("After Removing All Special Char(Excluding space): " + a.replaceAll("\\W+", " "));
    }

    @Test
    public void stringEquals() {
        String a = "Hello World";
        String b = "Hello World";
        String c = "Hello ";
        String d = "World";
        boolean z;

        z = a.equalsIgnoreCase(b);
        System.out.println("Z: " + z);

        z = a.equals(b);
        System.out.println("Z: " + z);

        z = a.equals(c + d);
        System.out.println("Z: " + z);

        z = a == b;
        System.out.println("Z: " + z);
    }

    @Test
    public void findIndex() {
        String k = "23";
        int num = 0;
        num = Integer.valueOf(k.substring(0, 1));
        System.out.println("num: " + num);
    }


    @Test(description = "https://leetcode.com/problems/reverse-words-in-a-string-ii/description/?envType=problem-list-v2&envId=string")
    public void reverse2() {
        String[] a = {"t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"};
        String[] b = new String[a.length];
        int index = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == " ") {
                int n=a.length -index;
                for (int j = i+1; j < n; j++) {
                    b[index++] = a[j];
                }
                b[index++] = " ";
                System.out.println("Reverse:- " + Arrays.toString(b));
            }
        }

        System.out.println("Initial:- " + Arrays.toString(a));
        System.out.println("Reverse:- " + Arrays.toString(b));

    }
}
