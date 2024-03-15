package casestudies.tictactoe.models;

public class Move {
   private Cell cells;
   private Players players;

    public Move(Cell cells,Players players) {
        this.cells = cells;
        this.players=players;
    }

    public Cell getCells() {
        return cells;
    }

    public void setCells(Cell cells) {
        this.cells = cells;
    }
}
