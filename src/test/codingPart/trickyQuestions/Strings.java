package test.codingPart.trickyQuestions;

import org.testng.annotations.Test;

public class Strings {

    @Test
    public void replaceSpecialCharacters() {
        String s="I am @Rohit Tater. My B'Day is 25th May";
        System.out.println("Before replace "+s);

        String a= s.replaceAll("[^a-zA-Z]","");
        System.out.println("Replace Special Characters and number-->"+a);

        String b= s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println("Replace Special Characters but not numbers-->"+b);

        String c= s.replaceAll("[^a-zA-Z0-9_ ]","");
        System.out.println("Replace Special Characters but not numbers and space -->"+c);

        String d= s.replaceAll("[^a-zA-Z0-9_._ ]","");
        System.out.println("Replace Special Characters but not numbers, space and fullstop -->"+d);
    }

    @Test
    public void stringEquals() {
        String a= new String("Hello World");
        String b= "Hello World";
        String c= "Hello ";
        String d= "World";
        boolean z;

        z= a.equalsIgnoreCase(b);
        System.out.println("Z--> "+z);

        z=a.equals(b);
        System.out.println("Z--> "+z);

        z=a.equals(c+d);
        System.out.println("Z--> "+z);

        z=a==b;
        System.out.println("Z--> "+z);
    }

    @Test
    public void findIndex(){
        String k="23";
        int num=0;
        num=Integer.valueOf(k.substring(0,1));
        System.out.println("num"+ num);
    }
}
