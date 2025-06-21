public class Cell {
    Jump jump;

    public Cell(int row, int col, Jump jump) {
        this.row = row;
        this.col = col;
        this.jump = jump;
    }

    int row;
    int col;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
