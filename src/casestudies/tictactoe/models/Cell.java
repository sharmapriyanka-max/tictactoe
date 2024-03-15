package casestudies.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellstate;
    private Players player;

    public Cell(int row, int col) {
        this.row=row;
        this.col=col;
        this.cellstate=CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }
}
