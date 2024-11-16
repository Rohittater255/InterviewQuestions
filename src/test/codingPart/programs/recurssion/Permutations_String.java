package test.codingPart.programs.recurssion;

import java.util.ArrayList;

public class Permutations_String {

    public static int count=0;
    public static ArrayList<String> list= new ArrayList<>();

    public static void main(String[] args) {
        findStringSequence("", "ABC");
        System.out.println("Result:- "+ String.join(", ",list));
    }

    public static void findStringSequence(String processed, String unProcessed) {
        //System.out.println("I am being called for "+ count++ +"nth time with value processed="+processed+ " and unProcessed="+unProcessed );
        if(unProcessed.isEmpty()){
           // System.out.println(processed);
            list.add(processed);
            return;
        }

        char c = unProcessed.charAt(0);
        findStringSequence(processed + c, unProcessed.substring(1));
        findStringSequence(processed, unProcessed.substring(1));

    }


}
