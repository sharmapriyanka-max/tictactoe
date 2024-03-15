package casestudies.tictactoe;

import casestudies.tictactoe.controllers.GameController;
import casestudies.tictactoe.models.*;
import casestudies.tictactoe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        try{
            int dimensions=3;
            List<Players> player=new ArrayList<>();
            player.add(new Players(1L,"AB",new Symbols( 'X'), PlayerType.HUMAN));
            player.add(new Bot(2L, "GPT", new Symbols('O'),PlayerType.BOT,BotDifficultylevel.EASY));
            List<WinningStrategy> winningStrategy=new ArrayList<>();

            Game game=gameController.startGame(dimensions,player,winningStrategy);
            while(gameController.checkState(game).equals(GameState.IN_PROGRESS))
            {
                gameController.displayBoard(game);
                gameController.makeMove(game);
            }
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong in creating the game" +e);
        }
        System.out.println("Game has been created");

    }
}
