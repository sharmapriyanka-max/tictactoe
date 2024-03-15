package casestudies.tictactoe.controllers;

import Exceptions.BotCountException;
import Exceptions.PlayersCountException;
import Exceptions.SymbolCountException;
import casestudies.tictactoe.models.Game;
import casestudies.tictactoe.models.GameState;
import casestudies.tictactoe.models.Players;
import casestudies.tictactoe.strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimensions, List<Players> player, List<WinningStrategy> winningStrategy) throws BotCountException, SymbolCountException, PlayersCountException {
       return  Game.getBuilder().setDimensions(dimensions)
                .setPlayers(player)
                .setWinningStrategies(winningStrategy)
                .Build();

    }
    public void displayBoard(Game game)
    {
         game.displayBoard();
    }
    public void makeMove(Game game)
    {
          game.makeMove();
    }
    public GameState checkState(Game game)
    {
       return game.getGamestate();
    }
    public void undo()
    {

    }

    public void getWinner()
    {

    }
}
