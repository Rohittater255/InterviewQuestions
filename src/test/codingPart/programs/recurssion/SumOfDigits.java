package test.codingPart.programs.recurssion;

public class SumOfDigits {

    public static void main(String[] args) {
        int n = 9878;
        calculateSum(n);
    }

    public static void calculateSum(int n) {
        //base condition
        if (n <= 9) {
            System.out.println("The final Sum is " + n);
            return;
        }

        //calculate sum
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum = sum + rem;
            n = n / 10;
        }
        System.out.println("The Initial Sum is " + sum);
        //recusrion
        calculateSum(sum);
    }
}
