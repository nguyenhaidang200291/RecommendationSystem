package ProgrammingExerciseStepThree.Module2.Filter;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;

public class DirectorsFilter implements Filter {
    String strDirectors;

    public DirectorsFilter(String directors) {
    	this.strDirectors = directors;
    }

    public boolean satisfies(String id) {
        String[] directorsSplit = this.strDirectors.split(",");
        for (int i = 0; i < directorsSplit.length; i++) {
            if (MovieDatabase.getDirector(id).indexOf(directorsSplit[i]) != -1) {
                return true;
            }
        }
        return false;
    }
}
