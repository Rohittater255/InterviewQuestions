package test.codingPart.programs.basicJava.ComparatorAndComparable;

public class Movie implements Comparable<Movie> {

    double rating;
    private final String name;
    private final int year;

    // Constructor
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Used to sort movies by year
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    // Getter methods for accessing private data
    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }


}

