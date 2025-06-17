import model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPeice cross = new PeiceX();
        Player player1 = new Player("player1",cross);
        PlayingPeice nought = new PeiceO();
        Player player2 = new Player("player2",nought);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();
            List<String>freeSpace = gameBoard.getFreeSpaces();
            if(freeSpace.isEmpty()){
                noWinner = false;
                continue;
            }
            gameBoard.printBoard();
            System.out.println("Player Turn: " + playerTurn.getName());
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);
            boolean peicedAddedSuccessfully = gameBoard.addPeice(playerTurn,row,col);
            if(!peicedAddedSuccessfully){
                System.out.println("Incorrect Position, please choose another: ");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean isWinner = gameBoard.getWinner(playerTurn.getSymbol());
            if(isWinner){
                gameBoard.printBoard();
                return playerTurn.getName();
            }
        }
        return "DRAW";
    }
}
