package MachineCoding.TicTacToe.DesignPatterns.Factories;

import MachineCoding.TicTacToe.Models.Board;
import MachineCoding.TicTacToe.Models.Cell;
import MachineCoding.TicTacToe.Models.Move;
import MachineCoding.TicTacToe.Models.PlayerType;

import java.util.Scanner;

public class Player {
    private char symbol;

    private String name;

    private MachineCoding.TicTacToe.Models.PlayerType type;

    public Player(char symbol, String name, MachineCoding.TicTacToe.Models.PlayerType type) {
        this.symbol = symbol;
        this.name = name;
        this.type = type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MachineCoding.TicTacToe.Models.PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public MachineCoding.TicTacToe.Models.Move decideMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the row to make a move : ");
        int row = scanner.nextInt();

        System.out.println("Please enter the column to make a move : ");
        int col = scanner.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
