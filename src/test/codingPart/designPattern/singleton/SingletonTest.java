package codingPart.designPattern.singleton;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void singleton_test(){
        System.out.println("Hashcode1: "+ Singleton.getInstance().hashCode());
        System.out.println("Hashcode2: "+ Singleton.getInstance().hashCode());


    }


}
