package codingPart.programs;

import org.testng.annotations.Test;

import java.util.*;

public class ArrayListQues {

    @Test
    public void a() {
        ArrayList list = new ArrayList(Arrays.asList(3,4,2));
        HashSet set = new HashSet<>();
        ArrayList listOfLists = new ArrayList();

        System.out.println("The size of list ="+listOfLists.size());
        System.out.println("The size of set ="+set.size());
        //for possible permutations
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                    Collections.swap(list, i, j);
                    if (set.add(new ArrayList(list))) {
                        listOfLists.add(new ArrayList<>(list));
                    }
                    Collections.swap(list, j, i);

            }
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()){
//                System.out.println("Iteration Number"+i);
//                System.out.println(iterator.next());
//                System.out.println("Iteration Number"+i);
//            }
        }
        System.out.println("The size of list ="+listOfLists.size());
        System.out.println("The size of set ="+set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    //Find list where

    }




}
