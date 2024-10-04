package MachineCoding.TicTacToe.DesignPatterns.Stratergies.BotPlayerWinningStratergy;

import MachineCoding.TicTacToe.Models.Board;
import MachineCoding.TicTacToe.Models.Move;
import MachineCoding.TicTacToe.Models.Player;

public interface BotPlayingStratergy {
    Move decideMove(Player player, Board board);
}
