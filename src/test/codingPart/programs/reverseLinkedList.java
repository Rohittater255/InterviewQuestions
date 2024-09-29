package test.codingPart.programs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;

public class reverseLinkedList {

    @Test
    public void reverse() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("linkedList:- " + linkedList.get(i));
        }
        // Print initail head
        System.out.println("New head: " + linkedList.getFirst());

        // Reverse the list
        Collections.reverse(linkedList);
//        Collections.frequency(linkedList);
        // Print reversed list
        System.out.println("Reversed LinkedList:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("linkedList: " + linkedList.get(i));
        }

        // Print new head
        System.out.println("New head: " + linkedList.getFirst());
    }

}
