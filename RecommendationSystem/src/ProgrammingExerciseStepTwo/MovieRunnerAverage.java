package ProgrammingExerciseStepTwo;

import java.util.ArrayList;
import java.util.Collections;

import dao.Rating;

public class MovieRunnerAverage {
	
    public static void main(String[] args) {
    	MovieRunnerAverage movieRunnerAverage = new MovieRunnerAverage();
    	movieRunnerAverage.printAverageRatings();
    	System.out.println("-----------------------------------");
    	movieRunnerAverage.getAverageRatingOneMovie();
    }
	
    public void printAverageRatings () {
        SecondRatings secondRatings = new SecondRatings("ratedmovies_short", "ratings_short");
        
        System.out.println("Total number of movies : " + secondRatings.getMovieSize());
        System.out.println("Total number of raters : " + secondRatings.getRaterSize());
        
        // add code to print a list of movies and their average ratings, for all those movies that have at least a
        //specified number of ratings, sorted by averages
        int minimalRaters = 3;
        ArrayList<Rating> averageRatings = secondRatings.getAverageRatings(minimalRaters);
        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + secondRatings.getTitle(rating.getItem()));
        }
    }
    
    public void getAverageRatingOneMovie () {
        SecondRatings secondRatings = new SecondRatings("ratedmovies_short", "ratings_short");
        
        String title = "The Godfather";
        int MinNumOfRatings = 1;
        
        String movieID = secondRatings.getID(title);
        ArrayList<Rating> averageRatings = secondRatings.getAverageRatings(MinNumOfRatings);
        for (Rating rating : averageRatings) {
            if (rating.getItem().equals(movieID)) {
                System.out.println("The average for the movie \"" + title + "\" would be rating is " 
                + rating.getValue());
            }
        }
    }
}
