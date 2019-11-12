package com.ashishwaghmare.core.entity;

import com.ashishwaghmare.core.entity.Grid.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

  Grid grid;

  @Before
  public void setup() {
    grid = new Grid(3, 3);
  }

  @Test
  public void test_vertical_win() {
    grid.row(0, State.O, State.X, State.O);
    grid.row(1, State.O, State.X, State.O);
    grid.row(2, State.O, State.X, State.X);
    Assert.assertTrue(grid.isDone(State.X));
  }

  @Test
  public void test_horizontal_win() {
    grid.row(0, State.O, State.X, State.O);
    grid.row(1, State.X, State.X, State.X);
    grid.row(2, State.O, State.O, State.X);
    Assert.assertTrue(grid.isDone(State.X));
  }

  @Test
  public void test_diagonal_win() {
    grid.row(0, State.X, State.O, State.O);
    grid.row(1, State.O, State.X, State.O);
    grid.row(2, State.O, State.O, State.X);
    Assert.assertTrue(grid.isDone(State.X));
  }

  @Test
  public void test_reverse_diagonal_win() {
    grid.row(0, State.O, State.O, State.X);
    grid.row(1, State.O, State.X, State.O);
    grid.row(2, State.X, State.O, State.O);
    Assert.assertTrue(grid.isDone(State.X));
  }

}
