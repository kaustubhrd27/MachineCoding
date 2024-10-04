package MachineCoding.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board (int dimensions){
        //so whenever this class will be called this constuctor of this class will be responsible for creating an empty board
        this.board = new ArrayList<>();
        for (int i=0;i < dimensions; ++i){
            this.board.add(new ArrayList<Cell>());
            for (int j=0; j < dimensions; ++j){
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void boardDisplay(){
        for (int i = 0;i < board.size(); i++){
            for (int j = 0;j < board.size(); j++){
                if (board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.print("| |");
                } else {
                    System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol()+" |");
                }
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }



    public void applyMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        this.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        this.getBoard().get(row).get(col).setPlayer(move.getPlayer());
    }

}
