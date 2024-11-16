package test.codingPart.programs.recurssion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static Map<Integer, Integer> map = new HashMap<>();

    //0,1,1,2,3,5,8,13
    public static void main(String[] args) {
        int result = findFibo(10);
        System.out.println("result:- " + result);
        int result1 = findFiboMap(10);
        System.out.println("result1:- " + result1);
    }

    public static int findFibo(int n) {
        if (n <= 1) {
            return n;
        }

        return findFibo(n - 1) + findFibo(n - 2);
    }

    public static int findFiboMap(int n) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int s = findFibo(n - 1) + findFibo(n - 2);
        map.put(n, s);
        return s;
    }
}
