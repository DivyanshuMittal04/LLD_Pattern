public class Jump {
    public Jump(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }

    Cell start;
    Cell end;

    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }
}
