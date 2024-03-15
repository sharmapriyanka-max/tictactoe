package casestudies.tictactoe.strategies.WinningStrategies;

import casestudies.tictactoe.models.Board;
import casestudies.tictactoe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
}
