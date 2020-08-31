package ProgrammingExerciseStepFour;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;
import ProgrammingExerciseStepThree.Module2.Filter.*;
import dao.Rating;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {
	
	public static void main(String[] args) {
		MovieRunnerSimilarRatings movieRunnerSimilarRatings = new MovieRunnerSimilarRatings();
		movieRunnerSimilarRatings.printSimilarRatings();
		System.out.println("-----------------------------------");
		movieRunnerSimilarRatings.printSimilarRatingsByGenre();
		System.out.println("-----------------------------------");
		movieRunnerSimilarRatings.printSimilarRatingsByDirector();
		System.out.println("-----------------------------------");
		movieRunnerSimilarRatings.printSimilarRatingsByGenreAndMinutes();
		System.out.println("-----------------------------------");
		movieRunnerSimilarRatings.printSimilarRatingsByYearAfterAndMinutes();
		System.out.println("-----------------------------------");
		movieRunnerSimilarRatings.printAverageRatingsByYearAfterAndGenre();
	}
	
    public void printSimilarRatings() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String id = "65";
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatings(id, numSimilarRaters, minimalRaters);
        System.out.println("Found " + similarRatings.size() + " movie(s) matched");

        for (Rating rating : similarRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }
	
    public void printSimilarRatingsByGenre() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String genre = "Action";
        GenreFilter genreFilter = new GenreFilter(genre);

        String id = "65";
        int numSimilarRaters = 20;
        int minimalRaters = 5;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatingsByFilter
                (id, numSimilarRaters, minimalRaters, genreFilter);
        System.out.println("Found " + similarRatings.size() + " movie(s) matched");

        for (Rating rating : similarRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre: " + MovieDatabase.getGenres(rating.getItem()));
        }
    }
    
    public void printSimilarRatingsByDirector() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directors = "Clint Eastwood,Sydney Pollack,DavidCronenberg,Oliver Stone";
        DirectorsFilter directorsFilter = new DirectorsFilter(directors);

        String id = "1034";
        int numSimilarRaters = 10;
        int minimalRaters = 3;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatingsByFilter
                (id, numSimilarRaters, minimalRaters, directorsFilter);
        System.out.println("Found " + similarRatings.size() + " movie(s) matched");

        for (Rating rating : similarRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by : " + MovieDatabase.getDirector(rating.getItem()));
        }
    }
    
    public void printAverageRatings() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minNumOfRatings = 35;
        ArrayList<Rating> averageRatings = fourthRatings.getAverageRatings(minNumOfRatings);
        System.out.println("There are " + averageRatings.size() + " movies with " +
                minNumOfRatings + " or more rating(s) :");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 1980;
        YearAfterFilter yearAfterFilter = new YearAfterFilter(year);

        String genre = "Romance";
        GenreFilter genreFilter = new GenreFilter(genre);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(yearAfterFilter);
        allFilters.addFilter(genreFilter);

        int minNumOfRatings = 1;
        ArrayList<Rating> avgRatings = fourthRatings.getAverageRatingsByFilter(minNumOfRatings, allFilters);
        System.out.println("Found " + avgRatings.size() + " movie(s) matched");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre : " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printSimilarRatingsByGenreAndMinutes() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");       
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String genre = "Adventure";
        GenreFilter genreFilter = new GenreFilter(genre);

        int minMin = 100;
        int maxMin = 200;
        MinutesFilter minutesFilter = new MinutesFilter(minMin, maxMin);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(genreFilter);
        allFilters.addFilter(minutesFilter);

        String id = "65";
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatingsByFilter
                (id, numSimilarRaters, minimalRaters, allFilters);
        System.out.println("Found " + similarRatings.size() + " movie(s) matched");

        for (Rating rating : similarRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem())
                    + " Time: " + MovieDatabase.getMinutes(rating.getItem()));
            System.out.println("Genre: " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes() {
        FourthRatings fourthRatings = new FourthRatings("ratings");
        System.out.println("Read data for " + RaterDatabase.size() + " raters");
        
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 2000;
        YearAfterFilter yearAfterFilter = new YearAfterFilter(year);

        int minMin = 80;
        int maxMin = 100;
        MinutesFilter minutesFilter = new MinutesFilter(minMin, maxMin);

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(yearAfterFilter);
        allFilters.addFilter(minutesFilter);

        String id = "65";
        int numSimilarRaters = 10;
        int minimalRaters = 5;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatingsByFilter
                (id, numSimilarRaters, minimalRaters, allFilters);
        System.out.println("Found " + similarRatings.size() + " movie(s) mathed");

        for (Rating rating : similarRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem())
                    + " Year: " + MovieDatabase.getYear(rating.getItem()) + " Time: "
                    + MovieDatabase.getMinutes(rating.getItem()));
        }
    }
}
