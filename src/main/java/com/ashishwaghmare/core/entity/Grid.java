package com.ashishwaghmare.core.entity;

import lombok.Data;

@Data
public class Grid {

  public enum State {
    EMPTY(" "),
    O("O"),
    X("X");
    String display;

    State(String display) {
      this.display = display;
    }
  }

  private State[][] cells = null;
  private int rows;
  private int columns;
  private boolean full;

  public Grid(int rows, int columns) {
    this.full = false;
    this.rows = rows;
    this.columns = columns;
    cells = new State[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        cells[i][j] = State.EMPTY;
      }
    }
  }

  public State get(int row, int column) {
    return cells[row][column];
  }

  public boolean mark(int row, int column, State currentSymbol) {
    if (cells[row][column] == State.EMPTY) {
      cells[row][column] = currentSymbol;
      return true;
    }
    return false;
  }

  public boolean allMarked() {
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (cells[row][column] == State.EMPTY) {
          return false;
        }
      }
    }
    this.full = true;
    return true;
  }


  public boolean isDone(State symbol) {
    //TODO use better algorithm
    int[] verticalCount = new int[rows];
    int[] horizontalCount = new int[columns];
    int[] diagnolCount = new int[columns];
    int[] antiDiagnolCount = new int[columns];
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (cells[row][column] == symbol) {
          if (++verticalCount[row] == rows) {
            return true;
          }
          if (++horizontalCount[column] == columns) {
            return true;
          }
          //Diagonal checks TODO not working
          if (row == column) {
            if (++antiDiagnolCount[column] == columns) {
              return true;
            }
            if (++diagnolCount[row] == rows) {
              return true;
            }
          }
        } else {
          verticalCount[row] = -rows;
          horizontalCount[column] = -columns;
        }
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    int cellNo = 0;
    for (State[] rows : cells) {
      for (State cell : rows) {
        builder.append("|").append(cellNo++).append("=").append(cell.display).append("|");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
}
