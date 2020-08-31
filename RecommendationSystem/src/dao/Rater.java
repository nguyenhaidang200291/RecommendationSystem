package dao;

import java.util.ArrayList;

public class Rater {
    private String myID;
    private ArrayList<Rating> myRatings;

    public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {
		this.myID = myID;
	}

	public ArrayList<Rating> getMyRatings() {
		return myRatings;
	}

	public void setMyRatings(ArrayList<Rating> myRatings) {
		this.myRatings = myRatings;
	}

	public Rater(String id) {
        this.myID = id;
        this.myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
    	this.myRatings.add(new Rating(item, rating));
    }

    public String getID() {
        return myID;
    }
    
    public double getRating(String item) {
        for (int i = 0; i < this.myRatings.size(); i++) {
            if (this.myRatings.get(i).getItem().equals(item)) {
                return myRatings.get(i).getValue();
            }
        }
        return -1;
    }
       
    public int numRatings() {
        return myRatings.size();
    }
    
    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < this.myRatings.size(); i++) {
            list.add(this.myRatings.get(i).getItem());
        }
        return list;
    }
    
    public boolean hasRating(String item) {
        for (int i = 0; i < this.myRatings.size(); i++) {
            if (this.myRatings.get(i).getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
