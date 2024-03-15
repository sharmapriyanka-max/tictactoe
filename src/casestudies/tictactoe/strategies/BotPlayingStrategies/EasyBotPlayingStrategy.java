package casestudies.tictactoe.strategies.BotPlayingStrategies;

import casestudies.tictactoe.models.Board;
import casestudies.tictactoe.models.Cell;
import casestudies.tictactoe.models.CellState;
import casestudies.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row:board.getCells())
        {
            for(Cell cell:row)
            {
                if(cell.getCellstate().equals(CellState.EMPTY))
                {
                    return new Move(cell,null);
                }
            }
        }
        return null;
    }
}
