package test.codingPart.programs.leetcode;

import org.testng.annotations.Test;

public class NumberQues {

    @Test
    public void sumOfDigits() {
        int n = 578;
        int result = 0;

        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        System.out.println("result:- " + result);
    }


    @Test
    public void reverseDigits() {
        int n = 578;
        int result = 0;

        while (n != 0) {
            result = result * 10 + n % 10; //1st iteration, result = 0+8  //2nd iteration, result = 8*10+7 //3rd iteration, result = 87*10+5
            n /= 10;
        }
        System.out.println("result:- " + result);
    }

    @Test
    public void factorial() {
        int n = 5;
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("result:- " + result);
    }

    @Test
    public void fibonacci() {
        // 0, 1, 1, 2, 3, 5, 8, 13
        int n = 8;
        int a = 0;
        int b = 1;
        int result = 0;


        if (n == 1 || n == 2) {
            result = 1;
        } else {
            for (int i = 2; i < n; i++) {

                result = a + b; //1st Itr, n=2 so 0+1=1  //2nd Itr, n=3 so 0+1=1
                a = b;
                b = result;
            }
        }
        System.out.println("result:- " + result);


    }


}
