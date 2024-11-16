package test.codingPart.programs.basicJava;

import org.testng.annotations.Test;

public class operatorsQues {

    @Test
    public void bitwise() {
        int a = 0b0111; // Binary representation of 7
        int b = 0b1000; // Binary representation of 8
        System.out.println("AND Operation: " + (a & b)); // 0111 & 1000 = 0000
        System.out.println("OR Operation: " + (a | b));  // 0111 | 1000 = 1111
        System.out.println("XOR Operation: " + (a ^ b)); // 0111 ^ 1000 = 1111
        System.out.println("Complement Operation: " + ~b); // 0111 ^ 1000 = 1111
    }

    @Test
    public void bitwise2() {
        int a = 7; // 0111 in binary
        int b = 8; // 1000 in binary
        System.out.println("AND Operation: " + (a & b)); // 0111 & 1000 = 0000
        System.out.println("OR Operation: " + (a | b));  // 0111 | 1000 = 1111
        System.out.println("XOR Operation: " + (a ^ b)); // 0111 ^ 1000 = 1111
        System.out.println("Complement Operation: " + ~b); // 0111 ^ 1000 = 1111
    }

    @Test(description = "FindNumber is even or odd")
    public void leftShift() {
        //Left shift is always doubles the number
        // calculation: a*2^b
        int a = 10;
        System.out.println(a << 1); //a*2^1=10*2=20
        System.out.println(a << 2); //a*2^2=10*4=40
    }

    @Test(description = "FindNumber is even or odd")
    public void rightShift() {
        //Left shift is always halves the number
        // calculation: a/(2^b)
        int a = 20;
        System.out.println(a >> 1); //a/(2^1)=20/2=10
        System.out.println(a >> 2); //a/(2^2)=20/4=5
    }

    @Test(description = "FindNumber is even or odd")
    public void adding() {
        int a, b;

        a = 10;
        b = 20;
        System.out.println(a + b);

        a = 0010;//(8^3)*0  + (8^2)*0  (8^1)*1 + (8^0)*0 =8
        b = 0020;//(8^3)*0  + (8^2)*0  (8^1)*2 + (8^0)*0 =16
        System.out.println(a + b);//8+16=24

        a = 0b0010; //(2^3)*0  + (2^2)*0  (2^1)*1 + (2^0)*0 =2
        b = 0b0011;  //(2^3)*0  + (2^2)*0  (2^2)*1 + (2^1)*0 =3
        System.out.println(a + b);//2+3=5
    }


    @Test(description = "FindNumber is even or odd")
    public void findEvenOrOdd() {
        int a = 7; // 0111 in binary
        int b = 8; // 1000 in binary
        System.out.println(isEven(a));
        System.out.println(isEven(b));
    }

    private boolean isEven(int a) {
        return (a & 1) == 1 ? true : false;
    }

    @Test(description = "Find Unique")
    public void findUnique() {
        int[] a = {5, 7, 3, 7, 5}; // 0111 in binary

        int num = 0;
        for (int i = 0; i < a.length; i++) {
            num = num ^ a[i];
        }

        System.out.println(num);
    }


    @Test(description = "Magic Number")
    public void magicNumber() {

    }

    @Test(description = "Magic Number")
    public void numberOfSetB() {

    }
}
