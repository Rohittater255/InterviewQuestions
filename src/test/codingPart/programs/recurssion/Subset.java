package codingPart.programs.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static int count;

    public static void main(String[] args) {
//        String s = "ABC";
//        printSubset("", s);

        int[] k = {1, 4, 5};
        printSubset(new ArrayList<>(), k,0);
    }

    private static void printSubset(String proccesed, String unprocessed) {
        //System.out.println("Running for count=" + count++);

        //Base Condition: If the unprocessed becomes empty then print
        if (unprocessed.isEmpty()) {
            System.out.println(proccesed);
            return;
        }

        //Pick first character from unprocesses
        char c = unprocessed.charAt(0); //Iteration 1, c=A,
        printSubset(proccesed + c, unprocessed.substring(1));
        //Iteration 1 : printSubset (""+ A ,BC)
        //Iteration 2 : printSubset ("A"+ B ,C)
        //Iteration 3 : printSubset ("AB"+ C ,"")

        printSubset(proccesed, unprocessed.substring(1));
    }


    private static void printSubset(List<Integer> processed, int[] unprocessed, int n) {
        //System.out.println("Running for count=" + count++);

        //Base Condition:
        if (n == unprocessed.length) {
            System.out.println(processed);
            return;
        }

        //Pick first character from unprocesses
        int c = unprocessed[n]; //Iteration 1, c=A,
        processed.add(c);
        printSubset(processed, unprocessed, n + 1);
        //Iteration 1 : printSubset (""+ 1 ,{1,2,3},1)
        //Iteration 2 : printSubset ("1"+ 2 ,{1,2,3},2)
        //Iteration 3 : printSubset ("12"+ 3 ,{1,2,3},3)
        processed.remove(processed.size()-1);
        printSubset(processed, unprocessed,n+1);
    }


}
