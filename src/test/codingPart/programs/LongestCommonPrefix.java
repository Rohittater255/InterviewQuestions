package codingPart.programs;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class LongestCommonPrefix {

    @Test
    public void preferredApproach() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Flower");
        words.add("Flaw");
        words.add("Flamingos");

        String prefix = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            while (words.get(i).indexOf(prefix) != 0) {
                System.out.println("prefix "+words.get(i).indexOf(prefix) );
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        System.out.println("prefix " + prefix);
    }

    @Test
    public void preferredApproach2() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Flower");
        words.add("Flaw");
        words.add("Flamingos");

        String prefix = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            if(!words.get(i).startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
                System.out.println("prefix " + prefix);
            }else {
                break;
            }
        }
        System.out.println("prefix " + prefix);
//            while (words.get(i).indexOf(prefix) != 0) {
//                System.out.println("prefix "+words.get(i).indexOf(prefix) );
//                prefix = prefix.substring(0, prefix.length() - 1);
//            }

    }
}
