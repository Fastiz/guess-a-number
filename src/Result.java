public class Result {
    private int guess;
    private int matches;
    private int perfectMatches;

    public Result(int guess, int matches, int perfectMatches){
        this.guess = guess;
        this.matches = matches;
        this.perfectMatches = perfectMatches;
    }

    public int getMatches() {
        return matches;
    }

    public int getPerfectMatches() {
        return perfectMatches;
    }

    public int getGuess() {
        return guess;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o instanceof Result == false)
            return false;
        Result aux = (Result)o;
        if(this.matches == aux.matches && this.perfectMatches == aux.perfectMatches)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return this.perfectMatches+" MB & "+this.matches+" B";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + matches;
        result = 31 * result + perfectMatches;
        return result;
    }
}
