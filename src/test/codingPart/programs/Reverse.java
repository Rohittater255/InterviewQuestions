package test.codingPart.programs;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class Reverse {

    @Test
    public void rt() {
        String a = "ROHITH";
        String rev = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            rev = rev + a.charAt(i);
        }

        System.out.println("ORIGNAL " + a);
        System.out.println("REVERSE " + rev);

        LinkedHashSet hashSet = new LinkedHashSet<>();
        for (int i = 0; i < a.length(); i++) {
            hashSet.add(a.charAt(i));
        }
        Iterator it = hashSet.iterator();
        for (int i = 0; i < hashSet.size(); i++) {
            System.out.println("Hashset: Char " + i + " " + it.next());
        }

        HashMap<Character, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Character c = a.charAt(i);
            hashmap.put(c, hashmap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            System.out.println("Entry Key " + entry.getKey() + " Entry Value " + entry.getValue());
        }


    }
}
