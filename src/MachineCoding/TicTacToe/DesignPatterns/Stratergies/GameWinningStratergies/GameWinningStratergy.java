package MachineCoding.TicTacToe.DesignPatterns.Stratergies.GameWinningStratergies;

import MachineCoding.TicTacToe.Models.Board;
import MachineCoding.TicTacToe.Models.Move;

public interface GameWinningStratergy {
    public boolean checkWinner(Board board, Move move);
}
