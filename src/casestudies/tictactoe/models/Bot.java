package casestudies.tictactoe.models;

import casestudies.tictactoe.strategies.BotPlayingStrategies.BotPlayingStrategy;
import casestudies.tictactoe.strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Players{
    private BotDifficultylevel botdifficultylevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(Long id, String name, Symbols symbol,PlayerType playerType, BotDifficultylevel botdifficultylevel)
    {    super(id,name,symbol,playerType);
        this.botdifficultylevel=botdifficultylevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botdifficultylevel);

    }

    public BotDifficultylevel getBotdifficultylevel() {
        return botdifficultylevel;
    }

    public void setBotdifficultylevel(BotDifficultylevel botdifficultylevel) {
        this.botdifficultylevel = botdifficultylevel;
    }
    public Move makeMove(Board board)
    {
        return this.botPlayingStrategy.makeMove(board);


      }
}
