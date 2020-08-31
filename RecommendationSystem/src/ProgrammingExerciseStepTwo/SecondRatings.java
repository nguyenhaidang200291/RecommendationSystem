package ProgrammingExerciseStepTwo;

import java.util.ArrayList;

import ProgrammingExerciseStepOne.FirstRatings;
import dao.Movie;
import dao.Rater;
import dao.Rating;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public ArrayList<Movie> getMyMovies() {
		return myMovies;
	}

	public void setMyMovies(ArrayList<Movie> myMovies) {
		this.myMovies = myMovies;
	}

	public ArrayList<Rater> getMyRaters() {
		return myRaters;
	}

	public void setMyRaters(ArrayList<Rater> myRaters) {
		this.myRaters = myRaters;
	}
    
    public SecondRatings (String moviefile, String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        this.myMovies = firstRatings.loadMovies(moviefile);
        this.myRaters = firstRatings.loadRaters(ratingsfile);
    }
    
    public int getMovieSize () {
        return myMovies.size();
    }
    
    public int getRaterSize () {
        return myRaters.size();
    }
    
    private double getAverageByID (String id, int minimalRaters) {
        double total = 0.0;
        int count = 0;
       
        for (Rater rater : this.myRaters) {
            if (rater.hasRating(id)) {
            	total += rater.getRating(id);
                count += 1;
            }
        }
        
        if (count >= minimalRaters) {
            return total / count;
        } else {
            return 0.0;
        }
    }
    
    public ArrayList<Rating> getAverageRatings (int minimalRaters) {
        ArrayList<Rating> averageRatings = new ArrayList<Rating> ();
        
        for (Movie movie : this.myMovies) {
            String movieID = movie.getId();
            double averageValue = getAverageByID(movieID, minimalRaters);
            if (averageValue != 0.0) {
                Rating rating = new Rating(movieID, averageValue);
                averageRatings.add(rating);
            }
        }
        
        return averageRatings;
    }
    
    public String getTitle (String id) {
        String title = null;
        
        for (Movie movie : this.myMovies) {
            if (movie.getId().equals(id)) {
                title = movie.getTitle();
            }
        }
        
        if (title != null) {
            return title;
        } else {
            return "The ID was not found.";
        }
    }
    
    public String getID (String title) {
        String movieID = null;
        
        for (Movie movie : myMovies) {
            if (movie.getTitle().equals(title)) {
                movieID = movie.getId();
            }
        }
        
        if (movieID != null) {
            return movieID;
        } else {
            return "NO SUCH TITLE.";
        }
    }
    
    
}
