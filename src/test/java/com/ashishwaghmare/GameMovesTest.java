package com.ashishwaghmare;

import com.ashishwaghmare.core.entity.Game;
import com.ashishwaghmare.core.entity.Grid.State;
import com.ashishwaghmare.core.entity.Player;
import org.junit.Before;
import org.junit.Test;

public class GameMovesTest {

  Game game;

  @Before
  public void setup() {
    game = new Game();
    Player player1 = game.getPlayer("Player1", State.X);
    Player player2 = game.getPlayer("Player2", State.O);
  }

  @Test
  public void test_simple_win() {

  }

  @Test
  public void test_diagonal() {
    game.simulate(0, 1, 4, 3, 8, 7);
  }

  @Test
  public void test_reverse_diagonal_win() {

  }

}
