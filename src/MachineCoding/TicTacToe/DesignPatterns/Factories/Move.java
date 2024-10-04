package MachineCoding.TicTacToe.DesignPatterns.Factories;

import MachineCoding.TicTacToe.Models.Cell;
import MachineCoding.TicTacToe.Models.Player;

public class Move {
    private Player player;

    private MachineCoding.TicTacToe.Models.Cell cell;

    public Move(Player player, MachineCoding.TicTacToe.Models.Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MachineCoding.TicTacToe.Models.Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
