package ProgrammingExerciseStepThree.Module2.Filter;

import ProgrammingExerciseStepThree.Module2.MovieDatabase;

public class MinutesFilter implements Filter {
    private int minMinutes;
    private int maxMinutes;

    public MinutesFilter(int min, int max) {
        this.minMinutes = min;
        this.maxMinutes = max;
    }

    public boolean satisfies(String id) {
        return MovieDatabase.getMinutes(id) >= this.minMinutes && MovieDatabase.getMinutes(id) <= this.maxMinutes;
    }
}
