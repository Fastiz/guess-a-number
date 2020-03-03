public class Main {
    public static void main(String[] args){
        //int num = 2345;
        int num = (int)Math.floor(Math.random()*9999);
        System.out.println("Number: "+num);
        Player player = new Computer();
        Game game = new Game(player, num);
        game.play();
    }
}
