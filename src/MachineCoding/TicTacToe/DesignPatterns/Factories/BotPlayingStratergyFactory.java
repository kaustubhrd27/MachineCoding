package MachineCoding.TicTacToe.DesignPatterns.Factories;

import MachineCoding.TicTacToe.DesignPatterns.Stratergies.BotPlayerWinningStratergy.BotPlayingStratergy;
import MachineCoding.TicTacToe.DesignPatterns.Stratergies.BotPlayerWinningStratergy.EasyBotPlayingStratergy;
import MachineCoding.TicTacToe.Models.BotDifficultyLevel;

public class BotPlayingStratergyFactory {
    public static BotPlayingStratergy getBotPlayingStratergyDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStratergy();
        }

        /*else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStratergy();
        }*/

        return null;
    }
}
