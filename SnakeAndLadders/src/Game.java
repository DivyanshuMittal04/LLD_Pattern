import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player> players;
    Dice dice;

    Game(){
        initialiseGame();
    }

    private void initialiseGame(){
        board = new Board(5,2,2);
        dice = new Dice();
        players = new LinkedList<>();
        addPlayers();
    }

    private void addPlayers(){
        Player p1 = new Player("P1",new Cell(0,0,null));
        Player p2 = new Player("P2",new Cell(0,0,null));
        players.add(p1);
        players.add(p2);
    }

    private boolean checkWinner(Player player){
        int row = player.getCurrentPosition().getRow();
        int col = player.getCurrentPosition().getCol();
        int size = board.getCells().length;
        return row == size - 1 && col == size - 1;
    }

    public Player startGame(){
        boolean isWinner = false;
        board.printBoard(players);
        while(!isWinner){
            Player player = players.getFirst();
            System.out.println("Player's id turn :- " + player.getId());
            int diceNumber = dice.rollDice();
            System.out.println("Dice Count :- " + diceNumber);
            board.move(player,diceNumber);
            board.printBoard(players);
            isWinner = checkWinner(player);
            players.remove(player);
            players.addLast(player);
        }
        return players.getLast();
    }
}
