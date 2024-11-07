package codingPart.programs.basicJava.exceptionHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ExampleForExceptions {

    @Test
    public void exampleOfNullPointerException() {

        //Below will not give null pointer
        String sa = "";
        System.out.println("Not Example of Null pointer exception: " + sa.toLowerCase());

        try {
            String s = null;
            System.out.println("Example of Null pointer exception: " + s.toLowerCase());
        } catch (NullPointerException e) {
            // Handle the exception
            System.err.println("NullPointerException: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //    @Test
//    public void exampleOfInitializationError(){
//        String s;
//        System.out.println("Example of Null pointer exception: "+ s.toLowerCase());
//    }

    @Test
    public void example_ConcurrentModificationException() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 32, 34));
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println("Get " + number);
            if (number.equals(32)) {
                iterator.remove();
                System.out.println("Removing " + number);
            }
        }
        System.out.println("Final List: " + list); // Outputs: [12, 34]


    }

    @Test
    public void exampleOfArithmeticException() {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            // Handle the exception
            System.err.println("ArithmeticException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void exampleOfNumberFormatException() {
        try {
            String s = "Rohit";
            System.out.println(Integer.valueOf(s));
        } catch (NumberFormatException e) {
            // Handle the exception
            System.err.println("NumberFormatException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void exampleOfClassNotFoundException() {
        try {
            // Attempt to load a class at runtime
            Class.forName("com.example.NonExistentClass");
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


    //Thread Exception
    public class ThreadClass extends Thread {

        public void run() {
        }

        @Test
        public void exampleOfThreadException() {
            try {
                ThreadClass tc = new ThreadClass();
                tc.start();
                tc.start();
            } catch (IllegalThreadStateException e) {
                System.err.println("IllegalThreadStateException: " + e.getMessage());
                e.printStackTrace();
            }

        }

    }


    @Test
    public void exampleOfIllegalStateException() {

        //Below will not give null pointer
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.close();
        try {
            driver.get("https://www.google.com/");
        } catch (IllegalStateException e) {
            // Handle the exception
            System.err.println("IllegalStateException: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

