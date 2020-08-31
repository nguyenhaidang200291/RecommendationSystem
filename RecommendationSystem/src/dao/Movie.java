package dao;

public class Movie {
    private String id;
    private String title;
    private int year;
    private String genres;
    private String director;
    private String country;
    private int minutes;
    private String poster;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Movie (String anID, String aTitle, String aYear, String theGenres) {
        this.id = anID.trim();
        this.title = aTitle.trim();
        this.year = Integer.parseInt(aYear.trim());
        this.genres = theGenres;
    }

    public Movie (String anID, String aTitle, String aYear, String theGenres, String aDirector,
    String aCountry, String aPoster, int theMinutes) {
    	this.id = anID.trim();
    	this.title = aTitle.trim();
    	this.year = Integer.parseInt(aYear.trim());
    	this.genres = theGenres;
    	this.director = aDirector;
    	this.country = aCountry;
    	this.poster = aPoster;
    	this.minutes = theMinutes;
    }

    public String toString () {
        String result = "Movie [id=" + id + ", title=" + title + ", year=" + year;
        result += ", genres= " + genres + "]";
        return result;
    }
}
