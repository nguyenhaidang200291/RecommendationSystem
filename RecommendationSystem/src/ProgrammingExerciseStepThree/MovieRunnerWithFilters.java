package ProgrammingExerciseStepThree;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;
import ProgrammingExerciseStepThree.Module2.ThirdRatings;
import ProgrammingExerciseStepThree.Module2.Filter.*;
import dao.Rating;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {
	
    public static void main(String[] args) {
    	MovieRunnerWithFilters movieRunnerWithFilters = new MovieRunnerWithFilters();
    	movieRunnerWithFilters.printAverageRatings();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByYearAfter();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByGenre();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByMinutes();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByDirectors();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByYearAfterAndGenre();
    	System.out.println("-----------------------------------");
    	movieRunnerWithFilters.printAverageRatingsByDirectorsAndMinutes();
    }
    
    public void printAverageRatings() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");       
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minNumOfRatings = 1;
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatings(minNumOfRatings);
        System.out.println("Found " + averageRatings.size() + " movies ​with a minimal rater of " +
                minNumOfRatings);

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfter() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 2000;
        YearAfterFilter yaf = new YearAfterFilter(year);

        int minNumOfRatings = 1;
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, yaf);
        System.out.println("Found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");        
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String genre = "Crime";
        GenreFilter gf = new GenreFilter(genre);

        int minNumOfRatings = 1;
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, gf);
        System.out.println("Found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre(s) : " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");       
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minMinutes = 110;
        int maxMinutes = 170;
        MinutesFilter minutesFilter = new MinutesFilter(minMinutes, maxMinutes);

        int minNumOfRatings = 1;
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, minutesFilter);
        System.out.println("Found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectors() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directorsList = "Charles Chaplin,Michael Mann,Spike Jonze";
        DirectorsFilter directorsFilter = new DirectorsFilter(directorsList);

        int minNumOfRatings = 1; 
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, directorsFilter);
        System.out.println("Found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by : " + MovieDatabase.getDirector(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");       
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 1980;
        YearAfterFilter yearAfterFilter = new YearAfterFilter(year);

        String genre = "Romance";
        GenreFilter genreFilter = new GenreFilter(genre);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(yearAfterFilter);
        allFilters.addFilter(genreFilter);

        int minNumOfRatings = 1;
        ArrayList<Rating> avgRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, allFilters);
        System.out.println("Found " + avgRatings.size() + " movie(s) matched");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre : " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        ThirdRatings thirdRatings = new ThirdRatings("ratings_short");
        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        
        MovieDatabase.initialize("ratedmovies_short");       
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String strdirectors = "Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola";
        DirectorsFilter directorsFilter = new DirectorsFilter(strdirectors);

        int minMinutes = 30;
        int maxMinutes = 170;
        MinutesFilter minutesFilter = new MinutesFilter(minMinutes, maxMinutes);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(directorsFilter);
        allFilters.addFilter(minutesFilter);

        int minNumOfRatings = 1;
        ArrayList<Rating> avgRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, allFilters);
        System.out.println("Found " + avgRatings.size() + " movie(s) matched");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by : " + MovieDatabase.getDirector(rating.getItem()));
        }
    }
}
