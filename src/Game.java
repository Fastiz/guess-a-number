import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Game {
    private static final int numberLength = 4;

    private int number;

    private Player player;

    public Game(Player player, int number){
        this.number = number;
        this.player = player;
    }

    public void play(){
        Result res;
        do{
            int move = player.makeMove();
            res = calculateResult(number, move);
            player.receiveResult(res);
            System.out.println(String.format("%0"+numberLength+"d", move)+": "+res.toString());
        }while(res.getPerfectMatches() != numberLength);
    }

    private Result calculateResult(int number, int guess){
        int perfectMatches = 0;
        int matches = 0;

        char[] numberString = String.format("%0"+numberLength+"d", number).toCharArray();
        char[] guessString = String.format("%0"+numberLength+"d", guess).toCharArray();

        for(int i=0; i< guessString.length; i++){
            char a = guessString[i];

            if(a == numberString[i])
                perfectMatches++;

            for(char b : numberString){
                if(a == b){
                    matches += 1;
                }
            }
        }

        return new Result(guess, matches, perfectMatches);
    }
}
