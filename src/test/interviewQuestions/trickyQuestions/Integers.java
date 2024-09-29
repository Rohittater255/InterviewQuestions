package test.interviewQuestions.trickyQuestions;

import org.testng.annotations.Test;

public class Integers {

    @Test
    public void sum_StringAndInteger() {
        int a = 2;
        int b = 8;
        System.out.println(a+b+"Yahoo");
        System.out.println("Yahoo"+a+b);
    }

    @Test
    public void sum_DifferentBase() {

        int a = 10;
        int b = 20;
        System.out.println(a+b);

        int c = 010;//(8*2)*0 + (8*1)*1 + (8*0)*0=8
        int d = 020;//(8*2)*0 + (8*1)*2 + (8*0)*0=16
        System.out.println(c+d);//24

        int e = 0010;//(8*3)*0 + (8*2)*0 + (8*1)*1 + (8*0)*0=8
        int f = 0020;//(8*3)*0 + (8*2)*0 + (8*1)*2 + (8*0)*0=24
        System.out.println(e+f);
    }


}
