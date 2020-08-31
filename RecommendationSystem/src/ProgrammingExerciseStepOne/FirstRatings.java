package ProgrammingExerciseStepOne;

import edu.duke.FileResource;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import dao.Movie;
import dao.Rater;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstRatings {
	
    public static void main(String[] args) {
        FirstRatings firstRatings = new FirstRatings();
        firstRatings.testLoadMovies();
        System.out.println("-----------------------------------");
        firstRatings.testLoadRaters();
    }
	
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movieData = new ArrayList<Movie>();

        FileResource fileResource = new FileResource("data/" + filename + ".csv");
        CSVParser csvParser = fileResource.getCSVParser();

        for (CSVRecord csvRecord : csvParser) {
            String currentID = csvRecord.get(0);
            String currentTitle = csvRecord.get(1);
            String currentYear = csvRecord.get(2);
            String currentCountry = csvRecord.get(3);
            String currentGenre = csvRecord.get(4);
            String currentDirector = csvRecord.get(5);
            int currentMinutes = Integer.parseInt(csvRecord.get(6));
            String currentPoster = csvRecord.get(7);

            Movie currentMovie = new Movie(currentID, currentTitle, currentYear, currentGenre, currentDirector,
                    currentCountry, currentPoster, currentMinutes);

            movieData.add(currentMovie);
        }

        return movieData;
    }

    
    public void testLoadMovies() {
        ArrayList<Movie> movies = loadMovies("ratedmovies_short");

        System.out.println("Number of movies: " + movies.size());

        //Add code to determine how many movies include the Comedy genre
        //Add code to determine how many movies are greater than 150 minutes in length
        String strComedy = "Comedy";
        int totalComedy = 0;

        int minutes = 150;
        int countMinutes = 0;

        for (Movie movie : movies) {
            if (movie.getGenres().contains(strComedy)) {
            	totalComedy += 1;
            }

            if (movie.getMinutes() > minutes) {
                countMinutes += 1;
            }
        }
        
        System.out.println("There are " + totalComedy + " movies in the Comedy genre");
        System.out.println("There are " + countMinutes + " movies are greater than " + minutes +
                " minutes in length");

        //Add code to determine the maximum number of movies by any director, and who the
        //directors are that directed that many movies
        HashMap<String, Integer> countMoviesByDirector = new HashMap<String, Integer>();
        for (Movie movie : movies) {
            String[] directors = movie.getDirector().split(",");

            for (String director : directors) {
                director = director.trim();
                if (!countMoviesByDirector.containsKey(director)) {
                    countMoviesByDirector.put(director, 1);
                } else {
                    countMoviesByDirector.put(director, countMoviesByDirector.get(director) + 1);
                }
            }
        }
       
        int maxNumOfMovies = 0;
        for (String director : countMoviesByDirector.keySet()) {
            if (countMoviesByDirector.get(director) > maxNumOfMovies) {
                maxNumOfMovies = countMoviesByDirector.get(director);
            }
        }

        ArrayList<String> directorsList = new ArrayList<String>();
        for (String director : countMoviesByDirector.keySet()) {
            if (countMoviesByDirector.get(director) == maxNumOfMovies) {
                directorsList.add(director);
            }
        }
        
        System.out.println("Maximum number of movies by any director: " + maxNumOfMovies);
        System.out.println("The directors who has directed many films is " + directorsList);
    }  
    
    
    public void testLoadRaters() {
        ArrayList<Rater> raters = loadRaters("ratings_short");
        //Print the total number of raters
        System.out.println("Total number of raters: " + raters.size());

        HashMap<String, HashMap<String, Double>> hashmap = new HashMap<String, HashMap<String, Double>>();
        for (Rater rater : raters) {
            HashMap<String, Double> ratings = new HashMap<String, Double>();
            ArrayList<String> itemsRated = rater.getItemsRated();

            for (int i = 0; i < itemsRated.size(); i++) {
                String movieID = itemsRated.get(i);
                double movieRating = rater.getRating(movieID);

                ratings.put(movieID, movieRating);
            }
            hashmap.put(rater.getID(), ratings);
        }

        //Add code to find the number of ratings for a particular rater you specify in your code
        String raterID = "2";
        int ratingsSize = hashmap.get(raterID).size();
        System.out.println("Number of ratings for the rater " + raterID + " : " + ratingsSize);
        //Add code to find the maximum number of ratings by any rater
        int maxNumOfRatings = 0;
        for (String key : hashmap.keySet()) {
            int currAmountOfRatings = hashmap.get(key).size();

            if (currAmountOfRatings > maxNumOfRatings) {
                maxNumOfRatings = currAmountOfRatings;
            }
        }
        System.out.println("Maximum number of ratings by any rater : " + maxNumOfRatings);

        //Add code to find the number of ratings a particular movie has
        String movieID = "1798709";
        int numOfRatings = 0;
        for (String key : hashmap.keySet()) {
            if (hashmap.get(key).containsKey(movieID)) {
                numOfRatings += 1;
            }
        }
        System.out.println("Number of ratings movie " + movieID + " has : " + numOfRatings);

        //Add code to determine how many different movies have been rated by all these raters
        ArrayList<String> uniqueMovies = new ArrayList<String>();
        for (String key : hashmap.keySet()) {
            for (String currMovieID : hashmap.get(key).keySet()) {
                if (!uniqueMovies.contains(currMovieID)) {
                    uniqueMovies.add(currMovieID);
                }
            }
        }
        System.out.println("Total number of movies that were rated : " + uniqueMovies.size());
    }
    
 
    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> listRater = new ArrayList<Rater>();
        ArrayList<String> listID = new ArrayList<String>();

        FileResource fileResource = new FileResource("data/" + filename + ".csv");
        CSVParser csvParser = fileResource.getCSVParser();

        for (CSVRecord csvRecord : csvParser) {
            String currentRaterID = csvRecord.get(0);
            String currentMovieID = csvRecord.get(1);
            double currentMovieRating = Double.parseDouble(csvRecord.get(2));

            if (!listID.contains(currentRaterID)) {
                Rater currentRater = new Rater(currentRaterID);
                listRater.add(currentRater);
                currentRater.addRating(currentMovieID, currentMovieRating);

            } else {
                for (int i = 0; i < listRater.size(); i++) {
                    if (listRater.get(i).getID().equals(currentRaterID)) {
                    	listRater.get(i).addRating(currentMovieID, currentMovieRating);
                    }
                }
            }

            listID.add(currentRaterID);
        }

        return listRater;
    }

}
