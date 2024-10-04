package MachineCoding.TicTacToe.DesignPatterns.Stratergies.GameWinningStratergies;

import MachineCoding.TicTacToe.Models.Board;
import MachineCoding.TicTacToe.Models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStratergy implements GameWinningStratergy {
    List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();

    List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();

    HashMap<Character, Integer> topLeftDiagonalSymbolCounts = new HashMap<>();

    HashMap<Character, Integer> topRightDiagonalSymbolCounts = new HashMap<>();

    public OrderOneGameWinningStratergy(int dimensions) {
        for(int i = 0; i < dimensions; ++i) {
            rowSymbolCounts.add(new HashMap<Character, Integer>());
            colSymbolCounts.add(new HashMap<Character, Integer>());
        }
    }

    //If element is present at top left corner then row no and col no are equal

    private boolean isCellOnTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int dimensions) {
        return row + col == dimensions;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        char symbol = move.getPlayer().getSymbol();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        int dimensions = board.getBoard().size();

        if (!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).get(symbol) + 1);

        if (!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).get(symbol) + 1);

        //If element is present at top left corner then row no and col no are equal

        if (isCellOnTopLeftDiagonal(row, col)) {
            if (!topLeftDiagonalSymbolCounts.containsKey(symbol)) {
                topLeftDiagonalSymbolCounts.put(symbol, 0);
            }
            topLeftDiagonalSymbolCounts.put(symbol, topLeftDiagonalSymbolCounts.get(symbol) + 1);
        }

        if (isCellOnTopRightDiagonal(row, col, dimensions)) {
            if (!topRightDiagonalSymbolCounts.containsKey(symbol)) {
                topRightDiagonalSymbolCounts.put(symbol, 0);
            }
            topRightDiagonalSymbolCounts.put(symbol, topRightDiagonalSymbolCounts.get(symbol) + 1);
        }

        //now we updated our hashmaps now we will check the winner :
        if (rowSymbolCounts.get(row).get(symbol) == dimensions
        || colSymbolCounts.get(col).get(symbol) == dimensions) {
            return true;
        }

        if (isCellOnTopLeftDiagonal(row, col) && topLeftDiagonalSymbolCounts.get(symbol) == dimensions) {
            return true;
        }

        if (isCellOnTopRightDiagonal(row, col, dimensions) && topRightDiagonalSymbolCounts.get(symbol) == dimensions) {
            return true;
        }
        return false;
    }
}
