package codingPart.programs.basicJava.Java8Features;

import org.testng.annotations.Test;
import java.util.*;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.time.Month;

public class Java8Features {

    @Test
    public void feature1_LambdaFunction() {
        // Lambda Expressions: Simplifies the use of functional interfaces and enables more concise code.
        // Here we create a list of names and print each name using a lambda expression.
        List<String> names = Arrays.asList("Sachin", "Rohit", "Kohli");
        names.forEach(name -> System.out.println(name));
    }

    @Test
    public void feature2_StreamAPI() {
        // Streams API: Provides a powerful way to process collections of objects in a functional manner.
        // Here we create a list of names, sort them using the stream API, and collect the sorted names into a new list.
        List<String> names = Arrays.asList("Sachin", "Rohit", "Kohli");

        System.out.println("Sorted Names: " +  names.stream().toList());
    }

    @Test
    public void feature3_DefaultMethods() {
        // Default Methods: Allows adding new methods to interfaces without breaking existing implementations.
        // We define a 'Vehicle' interface with a default 'start' method, and a 'Car' class that implements this interface.
        Vehicle car = new Car();
        car.start(); // Calls the default 'start' method from the Vehicle interface.
    }

    @Test
    public void feature4_Optional() {
        // Optional: Helps prevent NullPointerException by providing a container that may or may not contain a value.
        // Here we create an Optional object and print its value if it's present.
        Optional<String> name = Optional.ofNullable("Sachin");
        name.ifPresent(System.out::println); // Prints "Sachin" if the value is present.
    }

    @Test
    public void feature5_DateTimeAPI() {
        // Date and Time API: A modern and comprehensive API for date and time handling.
        // Here we get the current date and create a specific date using the new API.
        LocalDate today = LocalDate.now(); // Gets the current date.
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1); // Creates a specific date.
        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);
    }

    @Test
    public void feature6_FunctionalInterfaces() {
        // Functional Interfaces: Predefined interfaces like Function, Predicate, Consumer, and Supplier make code more concise and functional.
        // Here we use a Predicate to test if a number is positive.
        Predicate<Integer> isPositive = i -> i > 0;
        System.out.println(isPositive.test(5)); // true - 5 is positive.
    }
}

// Supporting classes and interfaces
interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting"); // Default method implementation.
    }
}

class Car implements Vehicle {
    // Car-specific implementations can be added here.
}
