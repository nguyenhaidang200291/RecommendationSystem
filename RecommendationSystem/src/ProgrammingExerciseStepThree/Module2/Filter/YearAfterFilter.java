package ProgrammingExerciseStepThree.Module2.Filter;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;

public class YearAfterFilter implements Filter {
    private int myYear;
    
    public YearAfterFilter(int year) {
        this.myYear = year;       
    }

    public boolean satisfies(String id) {
        return MovieDatabase.getYear(id) >= this.myYear;
    }
}
