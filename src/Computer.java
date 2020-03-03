import java.util.*;

public class Computer implements Player{
    private static final int numberLength = 4;
    private static final int safeSearchMargin = 1000;

    private int guesses;
    private List<Integer> possibleNumbers;

    public Computer(){
        possibleNumbers = new ArrayList<>();
        for(int i=0; i<9999; i++){
            possibleNumbers.add(i);
        }
    }

    @Override
    public int makeMove(){
        if(possibleNumbers.size() > safeSearchMargin)
            return possibleNumbers.get((int)Math.floor(Math.random()*possibleNumbers.size()));

        if(possibleNumbers.size()==1)
            return possibleNumbers.get(0);

        int bestMove = 0;
        int bestMoveValue = 10000;

        for(int i=0; i<10000; i++){
            Map<Result, Integer> groups = new HashMap<>();
            for(Integer num : possibleNumbers){
                Result newRes = calculateResult(num, i);
                if(groups.containsKey(newRes)){
                    groups.put(newRes, groups.get(newRes)+1);
                }else{
                    groups.put(newRes, 1);
                }
            }

            int max = 0;
            for(Integer size : groups.values()){
                if(size > max){
                    max = size;
                }
            }

            if(bestMoveValue > max){
                bestMove = i;
                bestMoveValue = max;
            }
        }

        return bestMove;
    }

    @Override
    public void receiveResult(Result result){
        List<Integer> aux = new ArrayList<>();
        int guess = result.getGuess();
        for(Integer num: possibleNumbers){
            if(result.equals(calculateResult(num, guess)))
                aux.add(num);
        }
        possibleNumbers = aux;
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
