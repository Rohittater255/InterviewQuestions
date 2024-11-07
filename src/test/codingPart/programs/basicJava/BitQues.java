package codingPart.programs.basicJava;

import org.testng.annotations.Test;

public class BitQues {

    @Test
    public void  integerToBit(){
        int n=7;
        System.out.println("Integer to Bit:-"+Integer.toBinaryString(n));

        n=3;
        System.out.println("Integer to Bit:-"+Integer.toBinaryString(n));
    }

    @Test
    public void  integerToOctal(){
        int n=9;
        System.out.println("Integer to Octal:- "+Integer.toOctalString(n));

        n=99;
        System.out.println("Integer to Octal:- "+Integer.toOctalString(n));
    }


    @Test
    public void  integerToHex(){
        int n=17;
        System.out.println("Integer to Hex:- "+Integer.toHexString(n));

        n=177;
        System.out.println("Integer to Octal:- "+Integer.toHexString(n));
    }
}
