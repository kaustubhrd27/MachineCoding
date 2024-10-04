package MachineCoding.TicTacToe.Models;

import MachineCoding.TicTacToe.DesignPatterns.Stratergies.GameWinningStratergies.GameWinningStratergy;
import MachineCoding.TicTacToe.DesignPatterns.Stratergies.GameWinningStratergies.OrderOneGameWinningStratergy;
import MachineCoding.TicTacToe.Exceptions.InvalidGameDimensionException;
import MachineCoding.TicTacToe.Exceptions.InvalidNoOfPlayersException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    private List<Player> players;

    private  List<Move> moves;

    private GameStatus gameStatus;

    private int nextPlayerIndex;

    private Player winner;

    public static Builder getBuilder(){
        return new Builder();
    }

    public void displayBoard() {
        this.board.boardDisplay();
    }

    public GameWinningStratergy gameWinningStratergy;

    public GameWinningStratergy getGameWinningStratergy() {
        return gameWinningStratergy;
    }

    public void setGameWinningStratergy(GameWinningStratergy gameWinningStratergy) {
        this.gameWinningStratergy = gameWinningStratergy;
    }

    public void makeNextMove() {
        //Steps :
        //1. Player should be able to decide the move
        //2. Check the validation of the move, if move is valid then make the move

        Player playerToMove = players.get(nextPlayerIndex);  // --- >>> Current Player

        System.out.println("It is " + playerToMove.getName() + "'s turn");
        Move move = playerToMove.decideMove(board);

        //Validate the Move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();


        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            //Now move is valid so make it happen
            board.applyMove(move);
            moves.add(move);

            nextPlayerIndex += 1;
            nextPlayerIndex %= (players.size());

            //Now as move has happened so we can check the winner here itself
            if (gameWinningStratergy.checkWinner(board, move)) {
                gameStatus = GameStatus.ENDED;
                winner = playerToMove;
            }

        } else {
            //throw some exception
        }

        //


    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }


    //As here we are having more number of attributes and also we need some validations before creating an board we will be using builder design pattern in this'

    public static class Builder {
        //private Board board;  -> as we are going to create board we take dimensions from user

        private int dimensions;

        private List<Player> players;

        //private  List<Move> moves;  -> here we are just initializing the game so don't need any moves here
        //private GameStatus gameStatus; -> as game is not yet started we do not need any game status here


        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public boolean isValid() throws InvalidNoOfPlayersException, InvalidGameDimensionException{
            if (players.size() != dimensions - 1) {
                throw new InvalidNoOfPlayersException("Number of players should be 1 less than dimension");
            }
            if (dimensions < 3) {
                throw new InvalidGameDimensionException("Dimension can't be less than 3");
            }
            return true;
        }

        public Game Build()  {
            try {
                isValid();
            } catch (InvalidNoOfPlayersException e) {
                System.out.println(e.getMessage());
                return null;
            } catch (InvalidGameDimensionException e) {
                System.out.println(e.getMessage());
                return null;
            }

            //now from above if any of the exception is not thrown then all of our validations have been passed and we can start the game

            Game game = new Game();

            game.setGameStatus(GameStatus.InPROGRESS);
            game.setBoard(new Board(dimensions));  // --> these dimensions will be provided by the user on that basis our board will be created
            game.setMoves(new ArrayList<Move>());
            game.setNextPlayerIndex(0);
            game.setPlayers(players);
            game.setGameWinningStratergy(new OrderOneGameWinningStratergy(dimensions));

            return game;
        }
    }
}
