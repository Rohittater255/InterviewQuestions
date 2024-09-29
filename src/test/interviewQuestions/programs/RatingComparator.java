package test.interviewQuestions.programs;

import java.util.Comparator;

class RatingComparator implements Comparator<Movie> {


    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getRating()<o2.getRating()){
            return -1;
        }
        if(o1.getRating()>o2.getRating()){
            return 1;
        }
        else
            return 0;
    }



}
