package test.codingPart.programs;

import org.testng.annotations.Test;

public class Regex {

    @Test
    public void removeSpecialCharacters() {
        String a = "My Name, is  Rohit";

        System.out.println("Before: " + a);
        System.out.println("After Removing All Special Char(Including space): " + a.replaceAll("[^a-zA-Z0-9]", ""));
        System.out.println("After Removing All Special Char(Excluding space): " + a.replaceAll("[^a-zA-Z0-9] ", ""));
    }
}
