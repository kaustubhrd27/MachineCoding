package MachineCoding.TicTacToe.DesignPatterns.Factories;

import MachineCoding.TicTacToe.DesignPatterns.Stratergies.BotPlayerWinningStratergy.BotPlayingStratergy;
import MachineCoding.TicTacToe.Models.PlayerType;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStratergy botPlayingStratergy;

    public Bot(char symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory.
                        getBotPlayingStratergyDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStratergy.decideMove(this, board);
    }
}
