package com.ashishwaghmare.core.entity;

import lombok.Data;

@Data
public class Grid {

  private State[][] cells = null;

  public Grid(int rows, int columns) {
    cells = new State[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        cells[i][j] = State.EMPTY;
      }
    }
  }

  public State get(int row, int column) {
    //TODO put validation
    return cells[row][column];
  }

  public enum State {
    EMPTY,
    MARKED_X,
    MARKED_O;
  }
}
