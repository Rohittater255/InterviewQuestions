package codingPart.programs.recurssion;

public class Factorial {

    public static void main(String[] args) {
        int result = findFactorial(6);
        System.out.println("result:-" + result);
    }

    private static int findFactorial(int n) {
        if (n <= 1) {
            return n;
        }
        return n * findFactorial(n - 1);
    }

}
