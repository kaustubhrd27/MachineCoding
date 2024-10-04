package MachineCoding.TicTacToe.Controllers;

// now actually we don't want that oue user be directly get interacted with the Game class
//so we will have a game controller class which will be interacting with the game class

import MachineCoding.TicTacToe.Models.Game;
import MachineCoding.TicTacToe.Models.GameStatus;
import MachineCoding.TicTacToe.Models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players) {
        Game game = Game.getBuilder().setDimensions(dimension).setPlayers(players).Build();
        return game;
    }

    public void undo(Game game) {
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }
}


// main use of this game controller class is that we do not client should directly interact with game class ideally we should have one layer in between so that we client can interact with that layer and that layer will further interact with the our Game class
