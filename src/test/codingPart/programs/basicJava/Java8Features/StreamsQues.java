package codingPart.programs.basicJava.Java8Features;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsQues {

    @Test
    public void waysToCreateStream() {

        //1. Create Stream from ArrayList
        List<Integer> list = Arrays.asList(4, 2, 3);
        System.out.println("Original: " + list);
        System.out.println("Stream: " + list.stream().toList());

        //2. Create Stream from Array
        int[] arr = {7, 4, 6};
        System.out.println("Original: " + Arrays.toString(arr));

        //3. Create Stream directly
        Stream a= Stream.of(1,3,4,5);
        System.out.println("a: " + a.toList() );

    }

    @Test
    public void basics() {
        List<Integer> list = Arrays.asList(4, 2, 3);
        System.out.println("Original: " + list);
        System.out.println("Stream: " + list.stream().toList());

        System.out.println("############## SORTING #######: ");
        System.out.println("Original: " + list);
        System.out.println("Sorted: " + list.stream().sorted().toList());
        System.out.println("Original is not affected by Streams-Sorting: " + list);
    }




    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(4, 2, 2, 3);
        System.out.println("Original: " + list);
        System.out.println("Ascending Sorted: " + list.stream().sorted().toList());
        System.out.println("Descending Sorted: " + list.stream().sorted(Comparator.reverseOrder()).toList());
    }

    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("Distinct: " + list.stream().distinct().toList());
    }

    @Test
    public void peek() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("PEEK: " + list.stream().peek((Integer val) -> System.out.println("Peeking:- " + val)).toList());
    }

    @Test
    public void filter() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("FILTER: " + list.stream().filter((Integer val) -> val > 3).toList());
    }

    @Test
    public void map() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("MAP: " + list.stream().map((Integer val) -> val * 4).toList());
    }

    @Test
    public void flatMap() {
        List<Integer> list1 = Arrays.asList(4, 2, 3, 2);
        List<Integer> list2 = Arrays.asList(4, 2, 3, 2);
        List<List<Integer>> list = Arrays.asList(list1, list2);
        System.out.println("Original: " + list);

        List<Integer> flatList = list.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("FlatMap: " + flatList);
        System.out.println("Original is not affected by FlatMap: " + list);
    }

    @Test
    public void mapToDouble() {
        List<String> list = Arrays.asList("1.1", "2.2", "3.3", "4.4");;
        System.out.println("Original: " + list);
        //This basically converts string elements to Double
        System.out.println("MAP to Double: " + list.stream().mapToDouble((String val) -> Double.parseDouble(val) ).sum());
    }


    @Test
    public void mapToInteger() {
        List<String> list = Arrays.asList("1", "2", "3", "4");;
        System.out.println("Original: " + list);
        //This basically converts string elements to Integer
        System.out.println("MAP: " + list.stream().mapToInt((String val) -> Integer.parseInt(val)).sum());
    }


    @Test
    public void mapToLong() {
        List<String> list = Arrays.asList("1", "2", "3", "4");;
        System.out.println("Original: " + list);
        //This basically converts string elements to Integer
        System.out.println("MAP: " + list.stream().mapToLong((String val) -> Long.parseLong(val)).sum());
    }



    @Test
    public void limit() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("LIMIT: " + list.stream().limit(2).toList());
    }


    @Test
    public void skip() {
        List<Integer> list = Arrays.asList(4, 2, 3, 2);
        System.out.println("Original: " + list);
        System.out.println("SKIP: " + list.stream().skip(2).toList());
    }


    @Test
    public void multipleOperations() {
        List<Integer> list = Arrays.asList(9, 7, 8, 2);
        System.out.println("Original: " + list);

        list.stream()
                .filter((Integer val) -> val > 3)
                .peek((Integer val) -> System.out.println("The value after Filter:- " + val))
                .map((Integer val) -> val * 10)
                .peek((Integer val) -> System.out.println("The value after Map(Multiplying):- " + val))
                .sorted()
                .peek((Integer val) -> System.out.println("The value after Sorting:- " + val))
                .toList();


        // First Filter, is performed on each element
        // Then Map, is performed on each element
        //  Once Filter and map is performed on each element, then sorting is performed


        System.out.println("Original is not affected by All these operations: " + list);
    }

    @Test
    public void noActionIsPerformedIfOutputOperationIsNotPerfomred() {
        List<Integer> list = Arrays.asList(4, 2, 3);
        System.out.println("Original: " + list);


        list.stream().map((Integer val) -> val * 4);
        list.stream().filter((Integer val) -> val > 2);
        list.stream().sorted();
        list.stream().peek((Integer cal) -> System.out.println(cal));
    }



}

