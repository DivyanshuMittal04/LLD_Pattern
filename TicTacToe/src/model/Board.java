package model;

import java.util.LinkedList;
import java.util.List;

public class Board {
    int size;
    PlayingPeice [][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPeice[size][size];
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].type);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }

    public List<String> getFreeSpaces(){
        List<String>freeSpace = new LinkedList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    freeSpace.add(i+","+j);
                }
            }
        }
        return freeSpace;
    }

    public boolean addPeice(Player player, int row, int col){
        if(row > size || col > size || row < 0 || col < 0)
            return false;
        else if(board[row][col]!=null)
            return false;
        board[row][col] = player.getSymbol();
        return true;
    }

    public boolean getWinner(PlayingPeice peiceType) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            // Check row
            if (board[i][0] == peiceType &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return true;
            }

            // Check column
            if (board[0][i] == peiceType &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                return true;
            }

            // Check diagonals
            if (board[0][0] == peiceType &&
                    board[0][0] == board[1][1] &&
                    board[1][1] == board[2][2]) {
                return true;
            }

            if (board[0][2] == peiceType &&
                    board[0][2] == board[1][1] &&
                    board[1][1] == board[2][0]) {
                return true;
            }
        }
        return false;
    }
}
