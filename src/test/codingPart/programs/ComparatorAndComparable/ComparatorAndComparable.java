package test.codingPart.programs.ComparatorAndComparable;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorAndComparable {

    @Test
    public void comparator(){
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("######### Printing Before Sorting  #########");
        for(Movie movie : list){
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }

        //Using Rating Comparator
       RatingComparator ratingComparator = new RatingComparator();
        Collections.sort(list,ratingComparator);

        System.out.println("######### Printing After Sorting  #########");
        for(Movie movie : list){
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }

    @Test
    public void comparable() {
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("######### Printing Before Sorting  #########");
        for(Movie movie : list){
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }

        Collections.sort(list);

        System.out.println("######### Printing After Sorting  #########");
        for(Movie movie : list){
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }

    }
}
