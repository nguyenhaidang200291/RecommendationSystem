package PeerGradedAssignmentStepFive;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;
import ProgrammingExerciseStepThree.Module2.Filter.TrueFilter;
import dao.Rating;

import java.util.ArrayList;
import java.util.Random;

import ProgrammingExerciseStepFour.FourthRatings;
import ProgrammingExerciseStepFour.RaterDatabase;

public class RecommendationRunner implements Recommender {

    public ArrayList<String> getItemsToRate() {
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> dataMovies = MovieDatabase.filterBy(new TrueFilter());

        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            int random = rand.nextInt(dataMovies.size());
            if (!items.contains(dataMovies.get(random))) {
            	items.add(dataMovies.get(random));
            }
        }

        return items;
    }

    public void printRecommendationsFor(String webRaterID) {
        FourthRatings fourthRatings = new FourthRatings();
        int numSimilarRaters = 50;
        int minNumOfRatings = 1;
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("<p>Read data for " + Integer.toString(RaterDatabase.size()) + " raters</p>");
        RaterDatabase.initialize("ratings");       
        System.out.println("<p>Read data for " + Integer.toString(MovieDatabase.size()) + " movies</p>");

        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatings(webRaterID, numSimilarRaters, minNumOfRatings);

        if (similarRatings.size() == 0) {
            System.out.println("<p>No movies matched</p>");
        } else {
            String header = ("<table> <tr> <th>Movie Title</th> <th>Rating Value</th>  <th>Genres</th> </tr>");
            String body = "";
            for (Rating rating : similarRatings) {
                body += "<tr> <td>" + MovieDatabase.getTitle(rating.getItem()) + "</td> <td>"
                        + Double.toString(rating.getValue()) + "</td> <td>" + MovieDatabase.getGenres(rating.getItem())
                        + "</td> </tr> ";
            }
            System.out.println(header + body + "</table>");
        }
    }
}
