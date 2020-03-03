public interface Player {
    //Guesses a number
    public int makeMove();

    //Receives result from previous guess
    public void receiveResult(Result res);
}
