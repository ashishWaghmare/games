package com.ashishwaghmare.core.entity;

import lombok.Data;

@Data
public class Grid {

  public void row(final int row, final State col1, final State col2, final State col3) {
    cells[row][0] = col1;
    cells[row][1] = col2;
    cells[row][2] = col3;
  }

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

    int[] verticalLines = new int[rows];
    int[] horizontalLines = new int[columns];

    //Diagonal lines will have more than max rows or columns. Mostly twice and middle one
    int maxIndex = columns - 1;
    int maxDiagonalLines = maxIndex * 2 + 1;
    int[] diagonalLines = new int[maxDiagonalLines];
    int[] reverseDiagonalLines = new int[maxDiagonalLines];

    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        if (cells[row][column] == symbol) {
          if (++verticalLines[column] == rows) {
            return true;
          }
          if (++horizontalLines[row] == columns) {
            return true;
          }
          int slope = row - column;
          int reverseSloppe = row + column;
          //Slope can be negative and can't be stored hence subtracting from high number
          if (++diagonalLines[maxIndex - slope] == columns) {
            return true;
          }
          if (++reverseDiagonalLines[reverseSloppe] == rows) {
            return true;
          }
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
