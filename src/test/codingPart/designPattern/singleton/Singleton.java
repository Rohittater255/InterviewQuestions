package codingPart.designPattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    //1. Private Static Instance
    private static Singleton singleton1;

    //2. Private Constructor
    private Singleton() {
        //Below code is required to prevent singleton class from Reflection API
        if (singleton1 != null) {
            throw new IllegalStateException("cannot create second instance");
        }
    }

    //3. static method to get Instance
    static Singleton getInstance() {
        //### Below code is required to prevent singleton class from Multiple THREADS ###
        if (singleton1 == null) {//check if instance is null
            synchronized (Singleton.class) { //required for multiple threads
                if (singleton1 == null) {//check if instance is null and creates new instnce
                    singleton1 = new Singleton();
                }
            }
        }
        return singleton1;
    }


    protected Object readResolve() {
        return getInstance();
    }


}
