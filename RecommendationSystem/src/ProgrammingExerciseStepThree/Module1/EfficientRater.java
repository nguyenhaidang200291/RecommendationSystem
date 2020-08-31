package ProgrammingExerciseStepThree.Module1;

import java.util.ArrayList;
import java.util.HashMap;

import dao.Rating;

public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String, Rating> myRatings;

    public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}

	public HashMap<String, Rating> getMyRatings() {
		return myRatings;
	}

	public void setMyRatings(HashMap<String, Rating> myRatings) {
		this.myRatings = myRatings;
	}

	public EfficientRater(String id) {
        this.myID = id;
        this.myRatings = new HashMap<String, Rating> ();
    }

    public void addRating(String item, double rating) {
    	this.myRatings.put(item, new Rating(item,rating));
    }

    public boolean hasRating(String item) {
        if (this.myRatings.containsKey(item)) {
            return true;
        }
       
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        for (String movieID : this.myRatings.keySet()) {
            if (movieID.equals(item)) {
                return myRatings.get(movieID).getValue();
            }
        }
       
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String> ();
        for (String movieID : this.myRatings.keySet()) {
            list.add(this.myRatings.get(movieID).getItem());
        }
        
        return list;
    }
}
