package ProgrammingExerciseStepThree.Module2.Filter;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;

public class GenreFilter implements Filter {
    private String strGenre;
    
    public GenreFilter (String genre) {
    	this.strGenre = genre;
    }

    public boolean satisfies(String id) {
        return MovieDatabase.getGenres(id).contains(this.strGenre);
    }
}
