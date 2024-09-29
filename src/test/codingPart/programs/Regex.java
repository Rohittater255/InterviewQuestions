package test.codingPart.programs;

import org.testng.annotations.Test;

public class Regex {

    @Test
    public void rt(){
        String a="My Name, is  Rohit";

        System.out.println("Before: "+a);
        a = a.replaceAll("[^a-zA-Z0-9 ]","");
        a = a.replaceAll("  "," ");
        System.out.println("After: "+a);
    }
}
