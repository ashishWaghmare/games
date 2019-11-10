package com.ashishwaghmare;

import com.ashishwaghmare.core.entity.Game;
import com.ashishwaghmare.core.entity.Grid;
import com.ashishwaghmare.core.entity.Grid.State;
import com.ashishwaghmare.core.entity.Player;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

  //1. Program starts, prints out an empty grid.
  @Test
  public void startGame_printEmptyGrid() {
    Game game = new Game(3, 3);
    Grid grid = game.getGrid();
    Assert.assertEquals(grid.get(0, 0), State.EMPTY);
    Assert.assertEquals(grid.get(0, 1), State.EMPTY);
    Assert.assertEquals(grid.get(0, 2), State.EMPTY);
    Assert.assertEquals(grid.get(1, 0), State.EMPTY);
    Assert.assertEquals(grid.get(1, 1), State.EMPTY);
    Assert.assertEquals(grid.get(1, 2), State.EMPTY);
    Assert.assertEquals(grid.get(2, 0), State.EMPTY);
    Assert.assertEquals(grid.get(2, 1), State.EMPTY);
    Assert.assertEquals(grid.get(2, 2), State.EMPTY);
  }

  //      1. The program then prompts for Player 1 name, followed by their preferred symbol; assigns a default 'X'.
  @Test
  public void askPreferencePlayer1_defaultX() {
    Game game = new Game();
    Player player1 = game.getPlayer(1);
    Assert.assertEquals(player1.getSymbol(), State.MARKED_X);
  }

  //      1. Same for Player 2 name, followed by their preferred symbol; assigns a default 'O'.
  @Test
  public void askPreferencePlayer2_defaultO() {
    Game game = new Game();
    Player player2 = game.getPlayer(2);
    Assert.assertEquals(player2.getSymbol(), State.MARKED_O);
  }

  //      1. Players take turns making their move. If a step is illegal or invalid, the program prints out the error and asks them to enter again.
  @Test
  public void onTurn_askMove() {
    Game game = new Game();
    Player currentPlayer = game.getActivePlayer();
    Assert.assertTrue(currentPlayer.move(1, 2));
  }

  //      1. The game continues until it's over, when the game is over, it announces the result.
  @Test
  public void onMultipleMoves_gameOver() {
    Game game = new Game();
    Player currentPlayer = game.getActivePlayer();
    Assert.assertTrue(currentPlayer.move(1, 2));
    Assert.assertFalse(game.isOver());
  }
}
