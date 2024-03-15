package casestudies.tictactoe.strategies.BotPlayingStrategies;

import casestudies.tictactoe.models.BotDifficultylevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultylevel botDifficultylevel)
    {
        if(botDifficultylevel.equals(BotDifficultylevel.EASY))
        {
            return new EasyBotPlayingStrategy();
        }
        if(botDifficultylevel.equals(BotDifficultylevel.MEDIUM))
        {
            return new MediumBotPlayingStrategy();
        }
        if(botDifficultylevel.equals(BotDifficultylevel.HARD))
        {
            return new HardBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
