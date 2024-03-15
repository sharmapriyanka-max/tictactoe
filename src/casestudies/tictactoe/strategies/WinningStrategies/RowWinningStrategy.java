package casestudies.tictactoe.strategies.WinningStrategies;

import casestudies.tictactoe.models.Board;
import casestudies.tictactoe.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
