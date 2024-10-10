package codingPart.programs.CollectionImp;

import org.testng.annotations.Test;

public class CollectionImpTest {


    @Test
    public void stack() {
        StackTest stack = new StackTest(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        System.out.println("Initial Stack ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("For i=" + i + " the element=" + stack.get(i));
        }

        stack.pop();
        System.out.println("Later Stack ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("For i=" + i + " the element=" + stack.get(i));
        }


    }
}
