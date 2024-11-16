package codingPart.programs.leetcode;

import java.util.HashSet;

public class HappyNumber {

    public static int squareOfDigits(int n) {
        int sumofSquareOfDigits = 0;
        while (n > 0) {
            int rem = n % 10;
            sumofSquareOfDigits += rem * rem;
            n = n / 10;

        }
        System.out.println("Returning Sum of Square " + sumofSquareOfDigits);
        return sumofSquareOfDigits;
    }


    public static void main(String args[]) {

        int n = 19;
        HashSet set = new HashSet<>();

        do {
            n = squareOfDigits(n);
        }
        while (set.add(n));
        if (n == 1) {
            System.out.println("Happy Number");
        } else {
            System.out.println("Not Happy Number");
        }
    }
}
