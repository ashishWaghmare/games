package com.ashishwaghmare;

import com.ashishwaghmare.core.entity.Game;
import com.ashishwaghmare.core.entity.Grid.State;
import com.ashishwaghmare.core.entity.Player;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Game ticTacToe = new Game();
    Scanner scanner = new Scanner(System.in);

    System.out.println("This is game of Tic Tac Toe to be played by two players.\n"
        + "First symbols will be selected and then position on grid will be asked \n"
        + "To facilitate single number entry, Position is running number and not x,y \n");

    join("Player1 ", ticTacToe, scanner);
    join("Player2 ", ticTacToe, scanner);

    System.out.println(ticTacToe.getGrid().toString());
    while (!ticTacToe.isDone()) {
      ticTacToe.nextTurn();
      System.out.println(ticTacToe.getActivePlayer() + " enter your position:");
      int position = scanner.nextInt();
      if (ticTacToe.move(position / 3, position % 3)) {
        System.out.println(ticTacToe.getGrid().toString());
      } else {
        System.out.println("Wrong move please try again");
      }
    }
    if (ticTacToe.getGrid().isFull()) {
      System.out.println("Game Over Nobody won");
    } else {
      System.out.println(ticTacToe.getActivePlayer() + " Won !! Hurray");
    }
  }

  public static void join(String playerName, Game game, Scanner scanner) {
    Player player = null;
    while (player == null) {
      try {
        System.out
            .println(playerName + "Enter your preferred Symbol ::" + game.getRemainingSymbol());
        String symbol = scanner.next();
        player = game.getPlayer(playerName, State.valueOf(symbol.toUpperCase()));
      } catch (Throwable ex) {
        System.out.println(playerName + " enter options available only");
      }

    }
  }
}
