package codingPart.programs.basicJava.Java8Features;

import org.testng.annotations.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctions {


    @Test
    public void consumer() {
        Consumer<Integer> consumer = (Integer val) -> {
            System.out.println("I am GROOT:- " + val);
        };
        consumer.accept(10);
    }

    @Test
    public void supplier() {
        Supplier<Integer> supplier = () -> {
            return 5;
        };
        System.out.println(supplier.get());
    }


    @Test
    public void functional() {
        Function<Integer, Integer> function = (Integer val) -> {
            return val * 5;
        };
        System.out.println("Functional " + function.apply(4));
    }


    @Test
    public void predicate() {
        Predicate<Integer> predicate = (Integer val) -> {
            return val % 2 == 0 ? true : false;
        };
        System.out.println("Is Number Even " + predicate.test(4));
        System.out.println("Is Number Even " + predicate.test(3));
    }
}
