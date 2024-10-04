package MachineCoding.TicTacToe;

import MachineCoding.TicTacToe.Controllers.GameController;
import MachineCoding.TicTacToe.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Game is getting started................");

        Scanner scanner = new Scanner(System.in);

        List<Player> players = new ArrayList<>();

        System.out.println("With what dimensions you would like to play the game : ");
        int dimensions = scanner.nextInt();

        System.out.println("Will there be any bot : if yes press y else press n");
        String isBot = scanner.next();

        //now initially human players will be simply dimensions - 1 otherwise the game will not be initialized

        int noOfHumanPlayers = dimensions - 1;

        //now if any user presses y it means we do have a bot so we need to reduce the no of human players

        if(isBot.equals('y')){
            noOfHumanPlayers = dimensions - 2;

            System.out.println("Please suggest the name for the bot you are going to play with : ");
            String botName = scanner.next();

            System.out.println("Please suggest the symbol for the bot you are going to play with");
            String botSymbol = scanner.next();

            players.add(new Bot(botSymbol.charAt(0), botName, BotDifficultyLevel.EASY));

        }

        // for human players we need to create them using a class Player and for that we also need name of the player and symbol they are going to use

        for(int i = 0; i < noOfHumanPlayers; ++i){
            System.out.println("Please enter the name of player no : "+ (i+1) );
            String name = scanner.next();

            System.out.println("Hey "+name+" Please enter the symobl with which you want to play with for player  : " );
            String symbol = scanner.next();

            Player player = new Player(symbol.charAt(0), name, PlayerType.HUMAN);
            players.add(player);
        }

       /* Game game = Game.getBuilder().
                setDimensions(dimensions).
                setPlayers(players).Build();

        */ // --- >>> client should not do this work bcoz in restraunt we can not give order directly to the cheff
        // there is an waiter for this work in our case we should have one controller for this work which can do all of these tasks

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimensions, players);

        while (gameController.getGameStatus(game).equals(GameStatus.InPROGRESS)){
            //players will play the game
            System.out.println("This is the current board  ");
            gameController.displayBoard(game);

            System.out.println("Do you want to undo  : y/n");
            String input = scanner.next();

            if (input.equals("y")){
                gameController.undo(game);
            } else {
                gameController.executeNextMove(game);
            }
        }

        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            System.out.println("Game Has Drawn");
        }
        if(gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
            // if game is ended then some one might have win the game
            System.out.println("GAME ENDED");
            System.out.println("Winner is " + gameController.getWinner(game).getName());

        }

    }
}
