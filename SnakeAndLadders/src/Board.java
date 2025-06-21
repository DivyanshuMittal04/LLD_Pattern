import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    Cell[][] cells;

    Board(int size, int numberOfSnakes, int numberOfLadders){
        cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j] = new Cell(i,j,null);
            }
        }
        addSnakes(numberOfSnakes);
        addLadders(numberOfLadders);
    }

    private void addSnakes(int numberOfSnakes){
        int size = cells.length;
        while(numberOfSnakes > 0) {
            int startRow = ThreadLocalRandom.current().nextInt(1, size);
            int startCol = ThreadLocalRandom.current().nextInt(0, size);

            int endRow = ThreadLocalRandom.current().nextInt(0, startRow);
            int endCol = ThreadLocalRandom.current().nextInt(0, size);

            Cell startCell = cells[startRow][startCol];
            Cell endCell = cells[endRow][endCol];

            if (startCell.getJump() == null && endCell.getJump() == null) {
                Jump jump = new Jump(startCell, endCell);
                startCell.setJump(jump);
                numberOfSnakes--;
            }
        }
    }

    private void addLadders(int numberOfLadders){
        int size = cells.length;
        while(numberOfLadders > 0) {
            int startRow = ThreadLocalRandom.current().nextInt(0, size-1);
            int startCol = ThreadLocalRandom.current().nextInt(0, size);

            int endRow = ThreadLocalRandom.current().nextInt(startRow+1, size);
            int endCol = ThreadLocalRandom.current().nextInt(0, size);

            Cell startCell = cells[startRow][startCol];
            Cell endCell = cells[endRow][endCol];

            if (startCell.getJump() == null && endCell.getJump() == null) {
                Jump jump = new Jump(startCell, endCell);
                startCell.setJump(jump);
                numberOfLadders--;
            }
        }
    }

    public void move(Player player, int diceNumber){
        int size = cells.length;
        int row = player.getCurrentPosition().getRow();
        int col = player.getCurrentPosition().getCol();

        while (diceNumber > 0) {
            int remainingInRow = size - col - 1; // cells left in this row (including current position)

            if (diceNumber <= remainingInRow) {
                // Move within the current row
                col += diceNumber;
                diceNumber = 0;
            } else {
                // Move to the end of row and go to next row
                diceNumber -= (remainingInRow + 1);
                col = 0;
                row++;

                if (row >= size) {
                    // We've gone beyond the last row, no change
                    row = player.getCurrentPosition().getRow();
                    col = player.getCurrentPosition().getCol();
                    diceNumber = 0;
                }
            }
        }

        player.setCurrentPosition(cells[row][col]);

        // Handle snake or ladder
        if (cells[row][col].getJump() != null) {
            player.setCurrentPosition(cells[row][col].getJump().getEnd());
        }
    }

    public void printBoard(Deque<Player> players) {
        int size = cells.length;

        for (int row = size - 1; row >= 0; row--) {
            for (int col = 0; col < size; col++) {
                Cell cell = cells[row][col];
                String marker = ".";
                String endPos = "";
                String playerPos = "";

                if (cell.getJump() != null) {
                    Cell end = cell.getJump().getEnd();
                    if (cell.getJump().getStart() == cell && end != null) {
                        if (end.getRow() < row || (end.getRow() == row && end.getCol() < col)) {
                            marker = "S";
                        } else {
                            marker = "L";
                        }
                        endPos = String.format("->(%d,%d)", end.getRow(), end.getCol());
                    }
                }

                for (Player player : players) {
                    Cell pos = player.getCurrentPosition();
                    if (pos.getRow() == row && pos.getCol() == col) {
                        playerPos += "P" + player.getId();
                    }
                }

                System.out.printf("(%d,%d)%s%s%s\t", row, col, marker, endPos, playerPos);
            }
            System.out.println();
        }
    }
}
