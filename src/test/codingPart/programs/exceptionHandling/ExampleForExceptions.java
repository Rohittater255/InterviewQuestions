package codingPart.programs.exceptionHandling;

import org.testng.annotations.Test;

public class ExampleForExceptions {

    @Test
    public void exampleOfNullPointerException() {
        String s = null;
        System.out.println("Example of Null pointer exception: " + s.toLowerCase());

        //Below will not give null pointer
        String sa = "";
        System.out.println("Example of Null pointer exception: " + sa.toLowerCase());

    }

//    @Test
//    public void exampleOfInitializationError(){
//        String s;
//        System.out.println("Example of Null pointer exception: "+ s.toLowerCase());
//    }


    @Test
    public void exampleOfClassNotFoundException() {
        try {
            // Attempt to load a class at runtime
            Class<?> clazz = Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            // Handle the exception
            System.err.println("ClassNotFoundException: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void exampleOfNoClassDefFoundError() {
        try {
            // Create an instance of a class that exists at compile time but not at runtime
            new SomeExistingClass();
        } catch (NoClassDefFoundError e) {
            System.err.println("NoClassDefFoundError: " + e.getMessage());
            e.printStackTrace();
        }
    }

    class SomeExistingClass {
        static {
            if (true)
                throw new NoClassDefFoundError("Simulated NoClassDefFoundError");
        }
    }
}
